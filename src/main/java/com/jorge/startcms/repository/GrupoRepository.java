package com.jorge.startcms.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jorge.startcms.mapper.GrupoMapper;
import com.jorge.startcms.model.Grupo;

import javax.sql.DataSource;

//@Repository
public class GrupoRepository implements GrupoRep{

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Grupo grupo) {

		try {
			String sql = String.format("insert into Grupo (Nombre) values ('%s')", grupo.getNombre());
			jdbcTemplate.execute(sql);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}

	@Override
	public boolean update(Grupo grupo) {

		if(grupo.getIdGrupo() > 0)
		{
			String sql = String.format("update Grupo set Nombre='%s' "
					+ "where IdGrupo='%d'", 
					grupo.getNombre(),grupo.getIdGrupo());
			jdbcTemplate.execute(sql);
			return true;
		}
		
		return false;
		
	}

	@Override
	public List<Grupo> findAll(Pageable pageable) {
		
		return jdbcTemplate.query("select * from Grupo",new GrupoMapper());
	}

	@Override
	public Grupo findBy(int Id) {
		
		Object[] params = new Object[] {Id};
		return jdbcTemplate.queryForObject("select * from Grupo where IdGrupo = ?", new GrupoMapper(),params);
		
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
}

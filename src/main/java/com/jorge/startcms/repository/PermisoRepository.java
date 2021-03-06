package com.jorge.startcms.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jorge.startcms.mapper.PermisoMapper;
import com.jorge.startcms.model.Permiso;

import javax.sql.DataSource;

//@Repository
public class PermisoRepository implements PermisoRep{

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Permiso permiso) {

		try {
			String sql = String.format("insert into Permiso (Nombre) values ('%s')", permiso.getNombre());
			jdbcTemplate.execute(sql);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}

	@Override
	public boolean update(Permiso permiso) {

		if(permiso.getIdPermiso() > 0)
		{
			String sql = String.format("update Permiso set Nombre='%s' "
					+ "where IdPermiso='%d'", 
					permiso.getNombre(),permiso.getIdPermiso());
			jdbcTemplate.execute(sql);
			return true;
		}
		
		return false;
		
	}

	@Override
	public List<Permiso> findAll(Pageable pageable) {
		
		return jdbcTemplate.query("select * from Permiso",new PermisoMapper());
	}

	@Override
	public Permiso findBy(int Id) {
		
		Object[] params = new Object[] {Id};
		return jdbcTemplate.queryForObject("select * from Permiso where IdPermiso = ?", new PermisoMapper(),params);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
}

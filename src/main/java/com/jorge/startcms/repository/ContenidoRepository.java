package com.jorge.startcms.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jorge.startcms.mapper.ContenidoMapper;
import com.jorge.startcms.model.Contenido;

import javax.sql.DataSource;

//@Repository
public class ContenidoRepository implements ContenidoRep {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Contenido contenido) {

		try {
			String sql = String.format("insert into Contenido (Tipo,Contenido,IdPost) "
					+ "values ('%s','%s','%d')", 
					contenido.getTipo(),contenido.getContenido(),contenido.getIdPost());
			jdbcTemplate.execute(sql);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}

	@Override
	public boolean update(Contenido contenido) {

		if(contenido.getIdContenido() > 0)
		{
			String sql = String.format("update Contenido set Tipo='%s', Contenido='%d', IdPost='%d' "
					+ "where IdContenido='%d'", 
					contenido.getTipo(),contenido.getContenido(),contenido.getIdPost(),contenido.getIdContenido());
			jdbcTemplate.execute(sql);
			return true;
		}
		
		return false;
		
	}

	@Override
	public List<Contenido> findAll(Pageable pageable) {
		
		return jdbcTemplate.query("select * from Contenido",new ContenidoMapper());
	}

	@Override
	public Contenido findBy(int Id) {
		
		Object[] params = new Object[] {Id};
		return jdbcTemplate.queryForObject("select * from Comentario where IdComentario = ?", new ContenidoMapper(),params);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
}

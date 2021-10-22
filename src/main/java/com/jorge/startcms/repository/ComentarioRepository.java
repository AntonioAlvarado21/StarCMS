package com.jorge.startcms.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;

import com.jorge.startcms.mapper.ComentarioMapper;
import com.jorge.startcms.model.Comentario;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

//@Repository
public class ComentarioRepository implements ComentarioRep {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void postContruct()
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean save(Comentario comentario) {
		
		try {
			String sql = String.format("insert into Comentario (Comentario,IdPost,IdUsuario,Respuesta) "
					+ "values ('%s','%s','%d')", 
					comentario.getComentario(),comentario.getIdPost(),comentario.getIdUsuario(),comentario.getRespuesta());
			jdbcTemplate.execute(sql);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean update(Comentario comentario) {

		if(comentario.getIdComentario() > 0)
		{
			String sql = String.format("update Comentario set Comentario='%s', IdPost='%d', IdUsuario='%d', Respuesta='%s' "
					+ "where IdComentario='%d'",
					comentario.getComentario(),comentario.getIdPost(),comentario.getIdUsuario(),comentario.getRespuesta(),
					comentario.getIdComentario());
			jdbcTemplate.execute(sql);
			return true;
		}
		
		return false;
		
	}

	@Override
	public List<Comentario> findAll(Pageable pageable) {
		
		return jdbcTemplate.query("select * from Comentario",new ComentarioMapper());
	}

	@Override
	public Comentario findBy(int Id) {
		
		Object[] params = new Object[] {Id};
		return jdbcTemplate.queryForObject("select * from Comentario where IdComentario = ?", new ComentarioMapper(),params);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
}

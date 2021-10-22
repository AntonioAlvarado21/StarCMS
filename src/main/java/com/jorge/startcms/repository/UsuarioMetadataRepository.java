package com.jorge.startcms.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jorge.startcms.mapper.UsuarioMetadataMapper;
import com.jorge.startcms.model.UsuarioMetadata;

import javax.sql.DataSource;

//@Repository
public class UsuarioMetadataRepository implements UsuarioMetadataRep{

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(UsuarioMetadata usuarioMetadata) {

		try {
			String sql = String.format("insert into Usuario_Metadata (IdUsuario,Clave,Valor,Tipo) "
					+ "values ('%d','%s','%s','%s')", 
					usuarioMetadata.getIdUsuario(),usuarioMetadata.getClave(),usuarioMetadata.getValor(),usuarioMetadata.getTipo());
			jdbcTemplate.execute(sql);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}

	@Override
	public boolean update(UsuarioMetadata usuarioMetadata) {
		
		if(usuarioMetadata.getIdUsuarioMetadata() > 0)
		{
			String sql = String.format("update Usuario_Metadata set Clave='%s', Valor='%s',Tipo='%s' "
					+ "where (IdUsuarioMetadata='%d' and IdUsuario='%d')",
					usuarioMetadata.getClave(),usuarioMetadata.getValor(),usuarioMetadata.getTipo(),
					usuarioMetadata.getIdUsuarioMetadata(),usuarioMetadata.getIdUsuario());
			
			jdbcTemplate.execute(sql);
			return true;
		}
		
		return false;
	}

	@Override
	public List<UsuarioMetadata> findAll(Pageable pageable) {
		
		return jdbcTemplate.query("select * from Usuario_Metadata",new UsuarioMetadataMapper());
	}

	@Override
	public UsuarioMetadata findBy(int Id) {
		
		Object[] params = new Object[] {Id};
		return jdbcTemplate.queryForObject("select * from Usuario_Metadata where IdUsuarioMetadata = ?", new UsuarioMetadataMapper(),params);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
}

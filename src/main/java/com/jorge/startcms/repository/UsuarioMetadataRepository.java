package com.jorge.startcms.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jorge.startcms.model.UsuarioMetadata;

@Repository
public class UsuarioMetadataRepository implements UsuarioMetadataRep{

	@Autowired
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
		
		if((usuarioMetadata.getIdUsuarioMetadata()) != 0)
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioMetadata findBy(int Id) {
		// TODO Auto-generated method stub
		return null;
	}
}

package com.jorge.startcms.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jorge.startcms.model.PostMetadata;

@Repository
public class PostMetadataRepository implements PostMetadataRep{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(PostMetadata postMetadata) {
		
		try {
			String sql = String.format("insert into Post_Metadata (Clave,Valor,Tipo,IdPost) "
					+ "values ('%s','%s','%s','%d')", 
					postMetadata.getClave(),postMetadata.getValor(),postMetadata.getTipo(),postMetadata.getIdPost());
			jdbcTemplate.execute(sql);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean update(PostMetadata postMetadata) {
		
		if(postMetadata.getIdPostMetadata() > 0)
		{
			String sql = String.format("update Post_Metadata set Clave='%s', Valor='%s', Tipo='%s',IdPost='%d' "
					+ "where IdPostMetadata='%d'",
					postMetadata.getClave(),postMetadata.getValor(),postMetadata.getTipo(),
					postMetadata.getIdPost());
			
			jdbcTemplate.execute(sql);
			return true;
		}
		
		return false;
		
	}

	@Override
	public List<PostMetadata> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostMetadata findBy(int Id) {
		// TODO Auto-generated method stub
		return null;
	}
}

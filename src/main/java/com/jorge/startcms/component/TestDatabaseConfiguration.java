package com.jorge.startcms.component;

import javax.management.MXBean;
import javax.sql.DataSource;

import com.jorge.startcms.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;


@Configuration
public class TestDatabaseConfiguration {
	
	@Bean
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test_blog?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC\r\n");
		dataSource.setUsername("jorge");
		dataSource.setPassword("root");
		
		return dataSource;
	}
	
	@Bean
	public CategoriaRepository categoriaRepository()
	{
		return new CategoriaRepository();
	}

	@Bean
	public ComentarioRepository comentarioRepository(){return new ComentarioRepository();}

	@Bean
	public ContenidoRepository contenidoRepository(){return new ContenidoRepository();}

	@Bean
	public GrupoPermisoRepository grupoPermisoRepository(){return new GrupoPermisoRepository();}

	@Bean
	public GrupoRepository grupoRepository(){return new GrupoRepository();}

	@Bean
	public PermisoRepository permisoRepository(){return new PermisoRepository();}

	@Bean
	public PostMetadataRep postMetadataRep(){return new PostMetadataRepository();}

	@Bean
	public PostRepository postRepository(){return  new PostRepository();}

	@Bean
	public UsuarioMetadataRepository usuarioMetadataRepository(){return new UsuarioMetadataRepository();}

	@Bean
	public UsuarioRepository usuarioRepository(){return new UsuarioRepository();}

}

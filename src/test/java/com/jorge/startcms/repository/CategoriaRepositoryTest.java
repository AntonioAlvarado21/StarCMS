package com.jorge.startcms.repository;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.jorge.startcms.component.TestDatabaseConfiguration;
import com.jorge.startcms.model.Categoria;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class CategoriaRepositoryTest {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Test
	public void testInsert()
	{
		Categoria categoria = new Categoria();
		
		categoria.setNombre("Test 2");
		categoria.setFecha(new Date());
		categoria.setDescripcion("Este es un ejemplo de categoria superior 2");
		categoria.setCategoriaSuperior(1);
	
		boolean result = categoriaRepository.save(categoria);
		//categoriaRepository.deleteAll();
		Assert.assertTrue(result);
	}

	@Test
	public void testUpdate()
	{
		Categoria categoria = new Categoria();

		categoria.setIdCategoria(1);
		categoria.setNombre("Test2");
		categoria.setDescripcion("Cambiando la descripción");
		categoria.setCategoriaSuperior(1);

		boolean result = categoriaRepository.update(categoria);

		Assert.assertTrue(result);
	}

	@Test
	public void testFindById()
	{
		Categoria categoria = categoriaRepository.findBy(1);

		Assert.assertTrue(categoria != null);
		Assert.assertTrue("Test2".equals(categoria.getNombre()));

	}

	@Test
	public void testfindAll()
	{
		SpringDataWebProperties.Pageable pageable = new SpringDataWebProperties.Pageable();
		Assert.assertFalse(categoriaRepository.findAll(pageable).isEmpty());
	}
	
}

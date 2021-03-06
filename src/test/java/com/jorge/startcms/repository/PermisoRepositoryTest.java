package com.jorge.startcms.repository;

import com.jorge.startcms.component.TestDatabaseConfiguration;
import com.jorge.startcms.model.Permiso;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class PermisoRepositoryTest {

    @Autowired
    private PermisoRepository permisoRepository;

    @Test
    public void testA(){
        Permiso permiso = new Permiso();
        permiso.setIdPermiso(1);
        permiso.setNombre("Nuevo Permismo");

        Assert.assertTrue(permisoRepository.save(permiso));
    }

    @Test
    public void testB(){
        Permiso permiso = new Permiso();
        permiso.setIdPermiso(1);
        permiso.setNombre("Nuevo Permismo2");

        Assert.assertTrue(permisoRepository.update(permiso));
    }

    @Test
    public void testC(){
        Assert.assertFalse(permisoRepository.findAll(new SpringDataWebProperties.Pageable()).isEmpty());
    }

    @Test
    public void testD(){
        Assert.assertTrue(permisoRepository.findBy(1).getNombre().equalsIgnoreCase("Nuevo Permismo2"));
    }
}

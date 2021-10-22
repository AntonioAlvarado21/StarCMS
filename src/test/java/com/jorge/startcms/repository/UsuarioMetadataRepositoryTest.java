package com.jorge.startcms.repository;

import com.jorge.startcms.component.TestDatabaseConfiguration;
import com.jorge.startcms.model.UsuarioMetadata;
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
public class UsuarioMetadataRepositoryTest {

    @Autowired
    private UsuarioMetadataRepository usuarioMetadataRepository;

    @Test
    public void testA(){
        UsuarioMetadata usuarioMetadata = new UsuarioMetadata();
        usuarioMetadata.setClave("Edad");
        usuarioMetadata.setIdUsuario(1);
        usuarioMetadata.setTipo(Integer.class.getName());
        usuarioMetadata.setValor("18");
        usuarioMetadata.setIdUsuarioMetadata(1);

        Assert.assertTrue(usuarioMetadataRepository.save(usuarioMetadata));
    }

    @Test
    public void testB(){
        UsuarioMetadata usuarioMetadata = new UsuarioMetadata();
        usuarioMetadata.setClave("Edad");
        usuarioMetadata.setIdUsuario(1);
        usuarioMetadata.setTipo(Integer.class.getName());
        usuarioMetadata.setValor("19");
        usuarioMetadata.setIdUsuarioMetadata(1);

        Assert.assertTrue(usuarioMetadataRepository.update(usuarioMetadata));
    }

    @Test
    public void testC(){
        Assert.assertFalse(usuarioMetadataRepository.findAll(new SpringDataWebProperties.Pageable()).isEmpty());
    }

    @Test
    public void testD(){
        Assert.assertTrue(usuarioMetadataRepository.findBy(1).getValor().equalsIgnoreCase("19"));
    }
}

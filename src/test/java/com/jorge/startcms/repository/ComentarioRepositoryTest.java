package com.jorge.startcms.repository;

import com.jorge.startcms.component.TestDatabaseConfiguration;
import com.jorge.startcms.model.Comentario;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class ComentarioRepositoryTest {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Test
    public void testA(){
        Comentario comentario = new Comentario();

        comentario.setComentario("ComentarioA");
        comentario.setIdPost(3);
        comentario.setIdUsuario(1);
        comentario.setRespuesta(null);

        boolean result = comentarioRepository.save(comentario);
        Assert.assertTrue(result);
    }

    @Test
    public void testB(){
        Comentario comentario = new Comentario();
        comentario.setIdComentario(1);
        comentario.setComentario("ComentarioB");
        comentario.setIdPost(3);
        comentario.setIdUsuario(1);
        comentario.setRespuesta(null);

        Assert.assertTrue(comentarioRepository.update(comentario));
    }

    @Test
    public void testC(){
        Assert.assertFalse(comentarioRepository.findAll(new SpringDataWebProperties.Pageable()).isEmpty());
    }

    @Test
    public void testD(){
        Assert.assertTrue(comentarioRepository.findBy(1).getComentario().equalsIgnoreCase("ComentarioB"));
    }

}

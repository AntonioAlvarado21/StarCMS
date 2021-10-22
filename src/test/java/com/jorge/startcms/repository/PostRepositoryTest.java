package com.jorge.startcms.repository;

import com.jorge.startcms.component.TestDatabaseConfiguration;
import com.jorge.startcms.model.Post;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;


    @Test
    public void insert() throws IOException {
        Post post = new Post();
        post.setIdPost(1);
        post.setImagenDestacada("image.jpg");
        post.setCategoria(1);
        post.setExtracto("Extracto de ejemplo");
        post.setSlug("nuevo-post");
        post.setTitulo("Nuevo Post");
        post.setTipo("Nuevo");
        post.setIdUsuario(1);

        boolean result = postRepository.save(post);

        Assert.assertTrue(result);
    }

    @Test
    public void update() throws IOException {
        Post post = new Post();
        post.setIdPost(1);
        post.setImagenDestacada("image.jpg");
        post.setCategoria(1);
        post.setExtracto("Extracto de ejemplo");
        post.setSlug("nuevo-post-xd");
        post.setTitulo("Nuevo Post XD");
        post.setTipo("Nuevo");
        post.setIdUsuario(1);

        boolean result = postRepository.update(post);

        Assert.assertTrue(result);
    }

    @Test
    public void findById(){
        Post post = postRepository.findBy(3);
        Assert.assertNotNull(post);
    }

    @Test
    public void findAll(){
        SpringDataWebProperties.Pageable pageable = new SpringDataWebProperties.Pageable();
        Assert.assertFalse(postRepository.findAll(pageable).isEmpty());
    }

}

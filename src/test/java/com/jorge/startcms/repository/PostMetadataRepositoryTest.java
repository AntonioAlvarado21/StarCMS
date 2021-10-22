package com.jorge.startcms.repository;

import com.jorge.startcms.component.TestDatabaseConfiguration;
import com.jorge.startcms.model.PostMetadata;
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
public class PostMetadataRepositoryTest {

    @Autowired
    private PostMetadataRepository postMetadataRepository;

    @Test
    public void testA(){
        PostMetadata postMetadata = new PostMetadata();
        postMetadata.setClave("Visitas");
        postMetadata.setIdPost(1);
        postMetadata.setTipo(Integer.class.getName());
        postMetadata.setValor("13");
        postMetadata.setIdPostMetadata(1);

        Assert.assertTrue(postMetadataRepository.save(postMetadata));
    }

    @Test
    public void testB(){
        PostMetadata postMetadata = new PostMetadata();
        postMetadata.setClave("Visitas");
        postMetadata.setIdPost(1);
        postMetadata.setTipo(Integer.class.getName());
        postMetadata.setValor("18");
        postMetadata.setIdPostMetadata(1);

        Assert.assertTrue(postMetadataRepository.update(postMetadata));
    }

    @Test
    public void testC(){
        Assert.assertFalse(postMetadataRepository.findAll(new SpringDataWebProperties.Pageable()).isEmpty());
    }

    @Test
    public void testD(){
        Assert.assertTrue(postMetadataRepository.findBy(1).getValor().equalsIgnoreCase("19"));
    }

}

package com.jorge.startcms;

import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class StarCmsApplication implements CommandLineRunner {

	/*@Autowired
	private Environment environment;*/

	public static void main(String[] args) {
		SpringApplication.run(StarCmsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//LogFactory.getLog(getClass()).info(environment.getProperty("jorge.propiedad"));

	}
}

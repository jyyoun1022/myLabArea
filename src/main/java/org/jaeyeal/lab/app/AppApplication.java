package org.jaeyeal.lab.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.*;

@EnableCaching // 스프링에게 캐싱기능이 필요하다고 전달
@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		ClassPathResource resource = new ClassPathResource("redis.yml");
		try {
			System.out.println("resource.getFile() = " + resource.getFile());
			System.out.println("resource.getFilename() = " + resource.getFilename());
			System.out.println("resource.getInputStream() = " + resource.getInputStream());
			System.out.println("resource.getPath() = " + resource.getPath());
			System.out.println("resource.getURL() = " + resource.getURL());
			System.out.println("resource.getURI() = " + resource.getURI());
			System.out.println("===========================================");

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		new SpringApplicationBuilder(AppApplication.class)
				.run(args);
	}


}

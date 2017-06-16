package br.com.tecommerce.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import br.com.tecommerce.application.ApplicationConfiguration;
import br.com.tecommerce.repository.RepositoryConfiguration;


@SpringBootApplication
@ComponentScan(basePackageClasses = Application.class)
@Import({ RepositoryConfiguration.class, ApplicationConfiguration.class })
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}

}
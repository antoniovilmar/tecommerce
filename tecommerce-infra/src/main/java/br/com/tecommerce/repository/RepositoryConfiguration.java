package br.com.tecommerce.repository;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@ComponentScan(basePackageClasses = RepositoryConfiguration.class)
@EntityScan("br.com.tcommerce.domain")
@EnableJpaRepositories
public class RepositoryConfiguration {
}

package co.programacionmaster.hambrecero.webservice;

import co.programacionmaster.hambrecero.iam.persistence.model.UserJpa;
import co.programacionmaster.hambrecero.iam.persistence.repository.UserJpaRepository;
import co.programacionmaster.hambrecero.iam.repository.UserRepositorySpringImpl;
import co.programacionmaster.hambrecero.iam.service.UserQueriesSpringImpl;
import co.programacionmaster.hambrecero.webservice.config.UserDetailsServiceImpl;
import co.programacionmaster.hambrecero.webservice.config.WebSecurityConfig;
import co.programacionmaster.hambrecero.webservice.web.rest.UserRestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackageClasses = {WebSecurityConfig.class})
@ComponentScan(basePackageClasses = {
    UserDetailsServiceImpl.class,
    UserQueriesSpringImpl.class,
    UserRepositorySpringImpl.class,
    UserRestController.class
})
@EntityScan(basePackageClasses = {
    UserJpa.class
})
@EnableJpaRepositories(basePackageClasses = {
    UserJpaRepository.class
})
public class HambreCeroWebServiceApp {

  public static void main(String[] args) {
    SpringApplication.run(HambreCeroWebServiceApp.class, args);
  }

  @Bean
  public BCryptPasswordEncoder getBcryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
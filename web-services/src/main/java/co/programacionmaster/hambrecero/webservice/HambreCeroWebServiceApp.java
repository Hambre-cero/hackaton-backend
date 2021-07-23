package co.programacionmaster.hambrecero.webservice;

import co.programacionmaster.hambrecero.business.persistence.model.OrganizationJpa;
import co.programacionmaster.hambrecero.business.persistence.repository.OrganizationJpaRepository;
import co.programacionmaster.hambrecero.business.repository.OrganizationRepositorySpringImpl;
import co.programacionmaster.hambrecero.business.service.OrganizationQueriesSpringImpl;
import co.programacionmaster.hambrecero.iam.persistence.model.UserJpa;
import co.programacionmaster.hambrecero.iam.persistence.repository.UserJpaRepository;
import co.programacionmaster.hambrecero.iam.repository.UserRepositorySpringImpl;
import co.programacionmaster.hambrecero.iam.service.UserQueriesSpringImpl;
import co.programacionmaster.hambrecero.webservice.config.UserDetailsServiceImpl;
import co.programacionmaster.hambrecero.webservice.config.WebSecurityConfig;
import co.programacionmaster.hambrecero.webservice.web.rest.UserRestController;
import io.vavr.jackson.datatype.VavrModule;
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
    UserRestController.class,
    OrganizationQueriesSpringImpl.class,
    OrganizationRepositorySpringImpl.class
})
@EntityScan(basePackageClasses = {
    UserJpa.class,
    OrganizationJpa.class
})
@EnableJpaRepositories(basePackageClasses = {
    UserJpaRepository.class,
    OrganizationJpaRepository.class
})
public class HambreCeroWebServiceApp {

  public static void main(String[] args) {
    SpringApplication.run(HambreCeroWebServiceApp.class, args);
  }

  /**
   * Vavr spring bean for configure jackson.
   *
   * @return A new {@link VavrModule} instance.
   */
  @Bean
  VavrModule vavrModule() {
    return new VavrModule();
  }

  @Bean
  public BCryptPasswordEncoder getBcryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
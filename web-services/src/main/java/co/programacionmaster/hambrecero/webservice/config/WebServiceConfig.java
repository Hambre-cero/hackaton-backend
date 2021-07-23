package co.programacionmaster.hambrecero.webservice.config;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * Web service configurations.
 */
@Configuration
public class WebServiceConfig implements WebMvcConfigurer {

  /**
   * Set default settings for application localization.
   *
   * @return A new {@link LocaleResolver}instance
   */
  @Bean
  public LocaleResolver localeResolver() {
    var slr = new SessionLocaleResolver();
    slr.setDefaultLocale(Locale.US);
    return slr;
  }

  /**
   * Interceptor to set the application language.
   *
   * @return A new {@link LocaleChangeInterceptor} instance
   */
  @Bean
  public LocaleChangeInterceptor localeChangeInterceptor() {
    var lci = new LocaleChangeInterceptor();
    lci.setParamName("lang");
    return lci;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(localeChangeInterceptor());
  }

  /**
   * Set message resource settings.
   *
   * @return A new {@link ResourceBundleMessageSource} instance
   */
  @Bean
  public ResourceBundleMessageSource messageSource() {
    var source = new ResourceBundleMessageSource();
    source.addBasenames("messages-business", "messages-web-services", "messages-iam");
    source.setUseCodeAsDefaultMessage(true);
    source.setDefaultEncoding("UTF-8");
    return source;
  }
}

package co.programacionmaster.hambrecero.commons.utils;

import javax.annotation.Nonnull;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

public final class MessageUtils {

  private MessageUtils() {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }

  public static String getMessage(
      @Nonnull MessageSource messageSource,
      @Nonnull String key,
      String... parameters
  ) {
    return messageSource.getMessage(key, parameters, LocaleContextHolder.getLocale());
  }
}

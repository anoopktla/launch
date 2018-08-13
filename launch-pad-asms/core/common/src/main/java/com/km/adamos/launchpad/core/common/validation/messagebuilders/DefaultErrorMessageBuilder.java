package com.km.adamos.launchpad.core.common.validation.messagebuilders;

import com.km.adamos.launchpad.core.common.validation.ErrorMessageBuilder;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;
import java.util.TreeSet;

public class DefaultErrorMessageBuilder implements ErrorMessageBuilder {

  final static String defaultMessage = "Missing Values: %s";
  final static String defaultSeparator = ", ";

  private String message = defaultMessage;
  private String separator = defaultSeparator;

  public DefaultErrorMessageBuilder() {
  }

  public DefaultErrorMessageBuilder(String message, String separator) {
    this.message = message;
    this.separator = separator;
  }

  @Override
  public String fromInvalidProperties(Set<String> invalidProperties) {
    return String.format(message, createInvalidPropsMessage(invalidProperties));
  }

  private String createInvalidPropsMessage(Set<String> invalidProperties) {
    TreeSet<String> propsSorted = new TreeSet<>(invalidProperties);
    return StringUtils.join(propsSorted, separator);
  }
}

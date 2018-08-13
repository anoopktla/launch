package com.km.adamos.launchpad.core.common.validation.messagebuilders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DefaultErrorMessageBuilderTest {

  Set<String> invalidProperties;
  DefaultErrorMessageBuilder messageBuilder;

  @BeforeEach
  public void setup() {
    messageBuilder = new DefaultErrorMessageBuilder();
    invalidProperties = new HashSet<>();
    invalidProperties.add("test1");
    invalidProperties.add("test2");
  }

  @Test
  @DisplayName("fromInvalidProperties - builds error message from invalid properties")
  public void fromInvalidProperties() {

    String propsMessageExpected = "test1" + DefaultErrorMessageBuilder.defaultSeparator + "test2";
    String errorMessageExpected = String.format(DefaultErrorMessageBuilder.defaultMessage, propsMessageExpected);

    String errorMessageReturned = messageBuilder.fromInvalidProperties(invalidProperties);

    assertThat(errorMessageReturned, equalTo(errorMessageExpected));

  }

  @Test
  @DisplayName("fromInvalidProperties - returns just message in case there are no invalid properties")
  public void fromInvalidPropertiesNoInvalidProperties() {

    String errorMessageExpected = String.format(DefaultErrorMessageBuilder.defaultMessage, "");

    String errorMessageReturned = messageBuilder.fromInvalidProperties(Collections.emptySet());

    assertThat(errorMessageReturned, equalTo(errorMessageExpected));

  }

  @Test
  @DisplayName("fromInvalidProperties - uses custom message and separator")
  public void fromInvalidPropertiesCustomMessageAndSeparator() {

    String customMessage = "CustomMessage: ";
    String customSeparator = "--> ";

    messageBuilder = new DefaultErrorMessageBuilder(customMessage, customSeparator);

    String propsMessageExpected = "test1" + customSeparator + "test2";
    String errorMessageExpected = String.format(customMessage, propsMessageExpected);

    String errorMessageReturned = messageBuilder.fromInvalidProperties(Collections.emptySet());

    assertThat(errorMessageReturned, equalTo(errorMessageExpected));

  }

}

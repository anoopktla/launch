package com.km.adamos.launchpad.core.common.error.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ServiceErrorTest {

  @Test
  @DisplayName("message - contains formatted string for error")
  public void messageContentSet() {
    ServiceError.ErrorContent errorContent = new ServiceError.ErrorContent<>("Testing");
    ServiceError serviceError = new ServiceError(ServiceError.ErrorCode.invalidSystemConfiguration, errorContent);

    assertThat(serviceError.getMessage(), equalTo(String.format(ServiceError.errorMessage, serviceError.errorCode, serviceError.errorContent.content)));

  }

  @Test
  @DisplayName("message - contains formatted string in case error content is not set")
  public void messageErrorContentNotSet() {
    ServiceError serviceError = new ServiceError(ServiceError.ErrorCode.invalidSystemConfiguration);

    assertThat(serviceError.getMessage(), equalTo(String.format(ServiceError.errorMessage, serviceError.errorCode, "")));
  }

}

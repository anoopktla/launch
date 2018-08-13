package com.km.adamos.launchpad.server.exceptions;

import com.km.adamos.launchpad.core.system.domain.exceptions.InvalidSystemConfiguration;
import com.km.adamos.launchpad.core.common.error.model.ServiceError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

public class RestExceptionHandlerTest {

  private RestExceptionHandler restExceptionHandler = new RestExceptionHandler();

  @Test
  @DisplayName("processInvalidSystemConfiguration - returns ServiceErrorList")
  public void processInvalidSystemConfiguration() {

    InvalidSystemConfiguration invalidSystemConfiguration = new InvalidSystemConfiguration("test");

    List<ServiceError> serviceErrors = restExceptionHandler.processInvalidSystemConfiguration(invalidSystemConfiguration);

    assertAndExtractSingleError(serviceErrors, ServiceError.ErrorCode.invalidSystemConfiguration, true);

  }


  private ServiceError assertAndExtractSingleError(List<ServiceError> serviceErrors, ServiceError.ErrorCode errorCode, boolean withContent) {
    assertThat(serviceErrors, notNullValue());
    assertThat(serviceErrors.size(), equalTo(1));

    ServiceError serviceError = serviceErrors.get(0);
    assertThat(serviceError.getErrorCode(), equalTo(errorCode));

    if(withContent) {
      assertThat(serviceError.getErrorContent(), notNullValue());
    }
    return serviceError;
  }

}

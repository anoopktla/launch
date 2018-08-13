package com.km.adamos.launchpad.server.exceptions;

import com.km.adamos.launchpad.core.common.error.model.NotImplementedException;
import com.km.adamos.launchpad.core.system.domain.exceptions.InvalidSystemConfiguration;
import com.km.adamos.launchpad.core.common.error.model.ServiceError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandler {

  private Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

  @ExceptionHandler(InvalidSystemConfiguration.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public List<ServiceError> processInvalidSystemConfiguration(InvalidSystemConfiguration invalidSystemConfiguration) {
    logger.error("service error exception");
    return Collections.singletonList(
      new ServiceError(ServiceError.ErrorCode.invalidSystemConfiguration, new ServiceError.ErrorContent<String>(invalidSystemConfiguration.getMessage()))
    );
  }

  @ExceptionHandler(NotImplementedException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public List<ServiceError> processNotImplemented(NotImplementedException notImplementedException) {
    logger.error("not implemented exception");
    return Collections.singletonList(
      new ServiceError(ServiceError.ErrorCode.invalidSystemConfiguration)
    );
  }


}

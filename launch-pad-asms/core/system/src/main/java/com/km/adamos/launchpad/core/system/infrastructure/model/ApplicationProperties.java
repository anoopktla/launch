package com.km.adamos.launchpad.core.system.infrastructure.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {

  @Value("${PORT:}")
  public String port;

  @Value("${C8Y_HOST:}")
  public String c8yHost;

  @Value("${C8Y_USERNAME:}")
  public String c8yUsername;

  @Value("${C8Y_PASSWORD:}")
  public String c8yPassword;

  @Value("${C8Y_TENANT:}")
  public String c8yTenant;

  @Value("${C8Y_MODE:}")
  public String cy8Mode;

}

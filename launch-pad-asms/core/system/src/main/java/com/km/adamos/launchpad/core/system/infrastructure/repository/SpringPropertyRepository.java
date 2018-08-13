package com.km.adamos.launchpad.core.system.infrastructure.repository;

import com.km.adamos.launchpad.core.system.infrastructure.model.ApplicationProperties;
import com.km.adamos.launchpad.core.system.domain.interfaces.PropertyRepository;
import com.km.adamos.launchpad.core.system.domain.model.System;
import org.springframework.stereotype.Component;

@Component
public class SpringPropertyRepository implements PropertyRepository {

  private ApplicationProperties applicationProperties;

  public SpringPropertyRepository(ApplicationProperties applicationProperties) {
    this.applicationProperties = applicationProperties;
  }

  @Override
  public System.SystemProperties getSystemProperties() {
    return new System.SystemProperties(
      applicationProperties.port,
      mapC8YMode(applicationProperties.cy8Mode)
    );
  }

  private System.C8YMode mapC8YMode(String c8yMode) {
    try {
      return c8yMode != null ?
        System.C8YMode.valueOf(c8yMode) :
        System.C8YMode.development;
    } catch (IllegalArgumentException e) {
      return System.C8YMode.development;
    }
  }

  @Override
  public System.C8YProperties getC8YProperties() {
    return new System.C8YProperties(
      applicationProperties.c8yHost,
      applicationProperties.c8yTenant,
      applicationProperties.c8yUsername,
      applicationProperties.c8yPassword
    );
  }
}

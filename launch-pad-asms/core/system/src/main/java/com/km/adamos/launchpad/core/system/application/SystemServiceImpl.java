package com.km.adamos.launchpad.core.system.application;

import com.km.adamos.launchpad.core.common.application.system.dto.SystemConfigurationDto;
import com.km.adamos.launchpad.core.system.application.interfaces.SystemRegistry;
import com.km.adamos.launchpad.core.system.domain.model.System;

public class SystemServiceImpl {

  private SystemRegistry systemRegistry;

  public SystemServiceImpl(SystemRegistry systemRegistry) {
    this.systemRegistry = systemRegistry;
  }

  public SystemConfigurationDto systemConfiguration() {
    System.SystemConfiguration systemConfiguration = new System(systemRegistry.propertyRepository()).systemConfiguration();
    return new SystemConfigurationDto(
      new SystemConfigurationDto.SystemPropertiesDto(
        systemConfiguration.systemProperties.port,
        SystemConfigurationDto.C8YMode.valueOf(systemConfiguration.systemProperties.c8yMode.toString())
      ),
      new SystemConfigurationDto.C8YPropertiesDto(
        systemConfiguration.c8YProperties.host,
        systemConfiguration.c8YProperties.tenant,
        systemConfiguration.c8YProperties.user,
        systemConfiguration.c8YProperties.password,
        systemConfiguration.c8YProperties.applicationKey
      )
    );
  }

  public boolean isSystemConfigurationValid() {
    return new System(systemRegistry.propertyRepository()).isSystemConfigurationValid();
  }

  public void assertSystemConfiguration() {
    new System(systemRegistry.propertyRepository()).assertSystemConfiguration();
  }


}

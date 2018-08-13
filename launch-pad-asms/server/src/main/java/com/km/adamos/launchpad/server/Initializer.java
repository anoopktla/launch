package com.km.adamos.launchpad.server;

import com.km.adamos.launchpad.core.common.application.system.dto.SystemConfigurationDto;
import com.km.adamos.launchpad.core.device.application.DeviceService;
import com.km.adamos.launchpad.core.device.infrastructure.registry.ProductionDeviceRegistry;
import com.km.adamos.launchpad.core.device.infrastructure.registry.TestDeviceRegistry;
import com.km.adamos.launchpad.core.system.application.SystemServiceImpl;
import com.km.adamos.launchpad.core.system.application.SystemServices;
import com.km.adamos.launchpad.core.system.infrastructure.model.ApplicationProperties;
import com.km.adamos.launchpad.core.system.infrastructure.registry.ProductionSystemRegistry;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class Initializer {

  private SystemServices systemServices;
  private Services services;

  public Initializer(ApplicationProperties applicationProperties) {
    this.systemServices = bootStrapSystemServices(applicationProperties);
  }

  private SystemServices bootStrapSystemServices(ApplicationProperties applicationProperties) {
    return new SystemServices(
      new SystemServiceImpl(
        new ProductionSystemRegistry(applicationProperties)
      )
    );
  }

  private void assertSystemConfiguration() {
    systemServices.systemService.assertSystemConfiguration();
  }

  public Services getOrBootstrapServices() {
    if (services == null) {
      assertSystemConfiguration();
      services = bootStrapServices();
    }
    return services;
  }

  private Services bootStrapServices() {
    return new Services(
      systemServices,
      bootStrapDeviceService()
    );
  }

  private DeviceService bootStrapDeviceService() {
    return isProduction() ?
      new DeviceService(
        new ProductionDeviceRegistry(
          systemServices.systemService.systemConfiguration()
        )
      ):
      new DeviceService(
        new TestDeviceRegistry()
      );
  }

  private boolean isProduction() {
    return systemServices.systemService.systemConfiguration().systemPropertiesDto.c8yMode == SystemConfigurationDto.C8YMode.production;
  }



}

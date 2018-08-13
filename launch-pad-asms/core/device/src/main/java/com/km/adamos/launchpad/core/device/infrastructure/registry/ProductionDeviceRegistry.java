package com.km.adamos.launchpad.core.device.infrastructure.registry;

import com.cumulocity.model.authentication.CumulocityCredentials;
import com.cumulocity.sdk.client.PlatformImpl;
import com.km.adamos.launchpad.core.common.application.system.dto.SystemConfigurationDto;
import com.km.adamos.launchpad.core.device.application.interfaces.DeviceRegistry;
import com.km.adamos.launchpad.core.device.domain.interfaces.DeviceAdapter;
import com.km.adamos.launchpad.core.device.infrastructure.adapter.C8YDeviceAdapter;

public class ProductionDeviceRegistry implements DeviceRegistry {


  private DeviceAdapter deviceAdapter;

  public ProductionDeviceRegistry(SystemConfigurationDto systemConfiguration) {
    this.deviceAdapter = bootstrapDeviceAdapter(systemConfiguration.c8YPropertiesDto);
  }

  @Override
  public DeviceAdapter getDeviceAdapter() {
    return deviceAdapter;
  }

  private DeviceAdapter bootstrapDeviceAdapter(SystemConfigurationDto.C8YPropertiesDto c8YProperties) {
    return new C8YDeviceAdapter(
      new PlatformImpl(
        c8YProperties.host,
        new CumulocityCredentials(
          c8YProperties.tenant,
          c8YProperties.user,
          c8YProperties.password,
          null
        )
      )
    );
  }
}

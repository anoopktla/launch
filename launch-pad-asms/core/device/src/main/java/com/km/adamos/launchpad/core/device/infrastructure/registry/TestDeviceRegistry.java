package com.km.adamos.launchpad.core.device.infrastructure.registry;

import com.km.adamos.launchpad.core.device.application.interfaces.DeviceRegistry;
import com.km.adamos.launchpad.core.device.domain.interfaces.DeviceAdapter;
import com.km.adamos.launchpad.core.device.infrastructure.adapter.StubDeviceAdapter;

public class TestDeviceRegistry implements DeviceRegistry {

  @Override
  public DeviceAdapter getDeviceAdapter() {
    return new StubDeviceAdapter();
  }
}

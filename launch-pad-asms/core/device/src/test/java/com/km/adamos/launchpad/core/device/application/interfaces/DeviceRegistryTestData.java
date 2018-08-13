package com.km.adamos.launchpad.core.device.application.interfaces;

import com.km.adamos.launchpad.core.device.domain.interfaces.DeviceAdapter;
import com.km.adamos.launchpad.core.device.domain.interfaces.DeviceAdapterTestData;

public class DeviceRegistryTestData {

  public static class TestDeviceRegistry implements DeviceRegistry {
    public DeviceAdapter deviceAdapter = DeviceAdapterTestData.createDeviceAdapterMock();

    public TestDeviceRegistry() {
    }

    public TestDeviceRegistry(DeviceAdapter deviceAdapter) {
      this.deviceAdapter = deviceAdapter;
    }

    @Override
    public DeviceAdapter getDeviceAdapter() {
      return deviceAdapter;
    }
  }

  public static TestDeviceRegistry createTestDeviceRegistry() {
    return new TestDeviceRegistry();
  }

}

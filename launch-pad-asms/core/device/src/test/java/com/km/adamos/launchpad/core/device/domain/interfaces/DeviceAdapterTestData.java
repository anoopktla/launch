package com.km.adamos.launchpad.core.device.domain.interfaces;

import com.km.adamos.launchpad.core.device.domain.model.testdata.DeviceTestData;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeviceAdapterTestData {

  public static DeviceAdapter createDeviceAdapterMock() {
    DeviceAdapter deviceAdapter = mock(DeviceAdapter.class);
    when(deviceAdapter.loadDevices()).thenReturn(DeviceTestData.createTestDevices());
    return deviceAdapter;
  }

}

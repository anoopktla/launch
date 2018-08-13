package com.km.adamos.launchpad.core.device.application;

import com.km.adamos.launchpad.core.device.application.interfaces.DeviceRegistryTestData;
import com.km.adamos.launchpad.core.device.domain.model.Device;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.Mockito.verify;

public class DeviceServiceTest {

  private DeviceRegistryTestData.TestDeviceRegistry deviceRegistry = DeviceRegistryTestData.createTestDeviceRegistry();
  private DeviceService deviceService = new DeviceService(deviceRegistry);

  @Test
  @DisplayName("loadDevices - loads devices from device adapter")
  public void loadDevices() {

    List<Device> devicesReturned = deviceService.loadDevices();

    assertThat(devicesReturned, notNullValue());

    verify(deviceRegistry.deviceAdapter).loadDevices();

  }


}

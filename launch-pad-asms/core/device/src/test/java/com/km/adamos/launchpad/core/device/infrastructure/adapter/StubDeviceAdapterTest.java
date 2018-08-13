package com.km.adamos.launchpad.core.device.infrastructure.adapter;

import com.km.adamos.launchpad.core.device.domain.interfaces.DeviceAdapter;
import com.km.adamos.launchpad.core.device.domain.model.Device;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

public class StubDeviceAdapterTest {

  private DeviceAdapter testDeviceAdapter = new StubDeviceAdapter();

  @Test
  @DisplayName("loadDevices - returns example devices")
  public void loadDevices() {

    List<Device> devicesReturned = testDeviceAdapter.loadDevices();

    assertThat(devicesReturned, notNullValue());
    assertThat(devicesReturned.size(), equalTo(2));

    devicesReturned.forEach(device -> {
      assertThat(device.getName(), notNullValue());
    });

  }

}

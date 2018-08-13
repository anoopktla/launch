package com.km.adamos.launchpad.core.device.domain.model.testdata;

import com.km.adamos.launchpad.core.device.domain.model.Device;

import java.util.Arrays;
import java.util.List;

public class DeviceTestData {

  public static List<Device> createTestDevices() {
    return Arrays.asList(
      new Device("fist"),
      new Device("second")
    );
  }

}

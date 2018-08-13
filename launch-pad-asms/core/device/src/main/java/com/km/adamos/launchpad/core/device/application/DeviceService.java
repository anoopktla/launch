package com.km.adamos.launchpad.core.device.application;

import com.km.adamos.launchpad.core.device.application.interfaces.DeviceRegistry;
import com.km.adamos.launchpad.core.device.domain.model.Device;

import java.util.List;

public class DeviceService {

  private DeviceRegistry deviceRegistry;

  public DeviceService(DeviceRegistry deviceRegistry) {
    this.deviceRegistry = deviceRegistry;
  }

  public List<Device> loadDevices() {
    return deviceRegistry.getDeviceAdapter().loadDevices();
  }

}

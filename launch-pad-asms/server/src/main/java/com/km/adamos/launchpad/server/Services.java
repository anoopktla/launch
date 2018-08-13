package com.km.adamos.launchpad.server;

import com.km.adamos.launchpad.core.device.application.DeviceService;
import com.km.adamos.launchpad.core.system.application.SystemServices;

public class Services {

  public SystemServices systemServices;
  public DeviceService deviceService;

  public Services(SystemServices systemServices, DeviceService deviceService) {
    this.systemServices = systemServices;
    this.deviceService = deviceService;
  }
}

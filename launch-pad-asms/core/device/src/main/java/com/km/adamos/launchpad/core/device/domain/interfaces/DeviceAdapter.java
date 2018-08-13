package com.km.adamos.launchpad.core.device.domain.interfaces;

import com.km.adamos.launchpad.core.device.domain.model.Device;

import java.util.List;

public interface DeviceAdapter {

  List<Device> loadDevices();

}

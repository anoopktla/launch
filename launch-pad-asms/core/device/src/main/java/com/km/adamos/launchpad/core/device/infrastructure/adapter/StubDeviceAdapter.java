package com.km.adamos.launchpad.core.device.infrastructure.adapter;

import com.km.adamos.launchpad.core.device.domain.interfaces.DeviceAdapter;
import com.km.adamos.launchpad.core.device.domain.model.Device;
import com.km.adamos.launchpad.core.device.domain.model.Measurement;
import com.km.adamos.launchpad.core.device.domain.model.enums.Unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StubDeviceAdapter implements DeviceAdapter {

  @Override
  public List<Device> loadDevices() {
    List<Device> devices = new ArrayList<>();
    Device device = new Device(01L,"device 1", "device type", "device owner","serial number",null,null);
    devices.add(device);
    return  devices;
  }

  @Override
  public List<Device> loadDevicesPaginated(int page,int pageSize){
    return  null;
  }

}

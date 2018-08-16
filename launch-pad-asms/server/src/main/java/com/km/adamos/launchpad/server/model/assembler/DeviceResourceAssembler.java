package com.km.adamos.launchpad.server.model.assembler;

import com.km.adamos.launchpad.core.device.domain.model.Device;
import com.km.adamos.launchpad.core.device.domain.model.Measurement;
import com.km.adamos.launchpad.core.device.domain.model.enums.SupportedMeasurements;
import com.km.adamos.launchpad.core.device.domain.model.enums.Unit;
import com.km.adamos.launchpad.server.DevicesController;
import com.km.adamos.launchpad.server.model.DeviceResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


public class DeviceResourceAssembler extends ResourceAssemblerSupport<Device, DeviceResource> {
  public DeviceResourceAssembler() {
    super(DevicesController.class, DeviceResource.class);
  }

  @Override
  public DeviceResource toResource(Device device) {
    return createDeviceResource(device);
  }

  private DeviceResource createDeviceResource(Device device){
    Map<String,Measurement> performanceDataMap = new HashMap<>();
    performanceDataMap.put("maxSpeed", device.getDevicePerformanceData().getMaxSpeed());
    performanceDataMap.put("maxOutput", device.getDevicePerformanceData().getMaxOutput());
    Map<String,Measurement> settingsMap = new HashMap<>();
    settingsMap.put("targetSpeed", device.getDeviceSettings().getTargetSpeed());
    settingsMap.put("targetOutput", device.getDeviceSettings().getTargetOutput());
    settingsMap.put("minAvailability",device.getDeviceSettings().getMinimumAvailability());
    DeviceResource deviceResource = new DeviceResource(device.getName(),device.getDeviceType(),
      device.getDeviceCode(),device.getNumber(),performanceDataMap,settingsMap);
    deviceResource.add(linkTo(methodOn(DevicesController.class).getDevice(device.getId().toString())).withSelfRel());
    return deviceResource;
  }
}

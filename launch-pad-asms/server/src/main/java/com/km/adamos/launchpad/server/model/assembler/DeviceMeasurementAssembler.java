package com.km.adamos.launchpad.server.model.assembler;

import com.km.adamos.launchpad.core.device.domain.model.Measurement;
import com.km.adamos.launchpad.server.DevicesController;
import com.km.adamos.launchpad.server.model.DeviceMeasurementResource;
import com.km.adamos.launchpad.server.model.DeviceResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class DeviceMeasurementAssembler  extends ResourceAssemblerSupport<Measurement, DeviceMeasurementResource> {
  public DeviceMeasurementAssembler(Class<?> controllerClass, Class<DeviceMeasurementResource> resourceType) {
    super(DevicesController.class, DeviceMeasurementResource.class);
  }

  @Override
  public DeviceMeasurementResource toResource(Measurement measurement) {
    DeviceResource deviceResource = new DeviceResource();
    return null;
  }
}

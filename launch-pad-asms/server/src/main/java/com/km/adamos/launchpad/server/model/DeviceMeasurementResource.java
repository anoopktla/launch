package com.km.adamos.launchpad.server.model;

import com.km.adamos.launchpad.core.device.domain.model.enums.Unit;
import org.springframework.hateoas.ResourceSupport;

public class DeviceMeasurementResource  extends ResourceSupport {
  private String data;
  private Unit unit;

  public DeviceMeasurementResource(String data, Unit unit) {
    this.data = data;
    this.unit = unit;
  }

  public String getData() {
    return data;
  }

  public Unit getUnit() {
    return unit;
  }
}

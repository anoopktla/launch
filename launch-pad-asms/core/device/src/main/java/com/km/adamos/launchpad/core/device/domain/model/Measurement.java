package com.km.adamos.launchpad.core.device.domain.model;

import com.km.adamos.launchpad.core.device.domain.model.enums.Unit;

public class Measurement {
  public Measurement(String data, Unit unit) {
    this.data = data;
    this.unit = unit;
  }
  private String data;
  private Unit unit;

  public String getData() {
    return data;
  }

  public Unit getUnit() {
    return unit;
  }
}

package com.km.adamos.launchpad.core.device.domain.model.enums;

public enum Unit {
  RPM("RPM","Rotations per minute"),
  MH("MH","Meters per hour"),
  PERCENTAGE("PERCENTAGE","Percentage value");
  private String unit;
  private String description;


  private Unit(String unit, String description){
    this.unit = unit;
    this.description = description;

  }

}

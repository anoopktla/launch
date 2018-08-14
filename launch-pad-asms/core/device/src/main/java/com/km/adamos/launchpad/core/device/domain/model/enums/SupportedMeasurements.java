package com.km.adamos.launchpad.core.device.domain.model.enums;

public enum SupportedMeasurements {
  TARGET_SPEED("Target Speed","Target speed of the machine","km_speedSet"),
  MAX_SPEED("Max Speed","maximum speed the machine can operate","km_speedMax"),
  TARGET_OUTPUT("Target Output","Target set for the machine","km_outputSet"),
  MAX_OUTPUT("Max Output","maximum output","km_outputMax");

  private String measurmentName;
  private String description;
  private String measurementMapping;

  SupportedMeasurements(String measurmentName, String description,String measurementMapping) {
    this.measurmentName = measurmentName;
    this.description = description;
    this.measurementMapping = measurementMapping;
  }

  public String getType(){return this.measurementMapping;
  }
}

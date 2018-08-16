package com.km.adamos.launchpad.core.device.domain.model;


public class DeviceSettings {
  private  Measurement targetSpeed;
  private Measurement targetOutput;
  private Measurement minimumAvailability;

  public DeviceSettings(Measurement targetSpeed, Measurement targetOutput, Measurement minimumAvailability) {
    this.targetSpeed = targetSpeed;
    this.targetOutput = targetOutput;
    this.minimumAvailability = minimumAvailability;
  }

  public Measurement getTargetSpeed() {
    return targetSpeed;
  }

  public Measurement getTargetOutput() {
    return targetOutput;
  }

  public Measurement getMinimumAvailability() {
    return minimumAvailability;
  }
}

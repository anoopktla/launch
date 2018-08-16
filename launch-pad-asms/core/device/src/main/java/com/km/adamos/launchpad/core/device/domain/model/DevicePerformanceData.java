package com.km.adamos.launchpad.core.device.domain.model;



public class DevicePerformanceData {
  private Measurement  maxSpeed;
  private  Measurement maxOutput;

  public DevicePerformanceData(Measurement maxSpeed, Measurement maxOutput) {
    this.maxSpeed = maxSpeed;
    this.maxOutput = maxOutput;
  }

  public Measurement getMaxSpeed() {
    return maxSpeed;
  }

  public Measurement getMaxOutput() {
    return maxOutput;
  }
}

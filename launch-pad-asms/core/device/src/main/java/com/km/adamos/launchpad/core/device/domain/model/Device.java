package com.km.adamos.launchpad.core.device.domain.model;


import java.util.List;

public class Device {

  private Long id;
  private String name;
  private String deviceType;
  private String owner;
  private List<Measurement> performanceData;
  private List<Measurement> settings;


  public Device(Long id, String name, String deviceType, String owner, List<Measurement> performanceData,List<Measurement> settings) {
    this.id = id;
    this.name = name;
    this.deviceType = deviceType;
    this.owner = owner;
    this.performanceData = performanceData;
    this.settings = settings;
  }

  public Device(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public String getDeviceType() {
    return deviceType;
  }

  public Long getId() {
    return id;
  }

  public String getOwner() {
    return owner;
  }

  public List<Measurement> getPerformanceData() {
    return performanceData;
  }

  public List<Measurement> getSettings() {
    return settings;
  }
}

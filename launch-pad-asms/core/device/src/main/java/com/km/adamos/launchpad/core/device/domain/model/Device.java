package com.km.adamos.launchpad.core.device.domain.model;


import java.util.Map;

public class Device {

  private Long id;
  private String name;
  private String deviceType;
  private String deviceCode;
  private String number;
  private Map<String , Measurement> performanceData;
  private Map<String,Measurement> settings;



  public Device(Long id, String name, String deviceType, String deviceCode, String number, Map<String,Measurement> performanceData, Map<String,Measurement> settings) {
    this.id = id;
    this.name = name;
    this.deviceType = deviceType;
    this.deviceCode = deviceCode;
    this.performanceData = performanceData;
    this.settings = settings;
    this.number = number;

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

    public String getDeviceCode() {
      return deviceCode;
    }

    public String getNumber() {
      return number;
  }

  public Map<String,Measurement> getPerformanceData() {
    return performanceData;
  }

  public Map<String,Measurement> getSettings() {
    return settings;
  }
}

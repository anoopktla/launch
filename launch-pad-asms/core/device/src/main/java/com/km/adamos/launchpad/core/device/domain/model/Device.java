package com.km.adamos.launchpad.core.device.domain.model;


import java.util.Map;

public class Device {

  private Long id;
  private String name;
  private String deviceType;
  private String deviceCode;
  private String number;
  private  DevicePerformanceData devicePerformanceData;
  private DeviceSettings deviceSettings;



  public Device(Long id, String name, String deviceType, String deviceCode, String number,DevicePerformanceData devicePerformanceData,DeviceSettings deviceSettings) {
    this.id = id;
    this.name = name;
    this.deviceType = deviceType;
    this.deviceCode = deviceCode;
    this.number = number;
    this.devicePerformanceData = devicePerformanceData;
    this.deviceSettings = deviceSettings;

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

  public DevicePerformanceData getDevicePerformanceData() {
    return devicePerformanceData;
  }

  public DeviceSettings getDeviceSettings() {
    return deviceSettings;
  }
}

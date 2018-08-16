package com.km.adamos.launchpad.server.model;

import com.km.adamos.launchpad.core.device.domain.model.Measurement;
import org.springframework.hateoas.ResourceSupport;

import java.util.Map;

public class DeviceResource extends ResourceSupport {
  private String name;
  private String deviceType;
  private String deviceCode;
  private String number;
  private Map<String , Measurement> performanceData;
  private Map<String,Measurement> settings;





  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDeviceType() {
    return deviceType;
  }

  public void setDeviceType(String deviceType) {
    this.deviceType = deviceType;
  }

  public String getDeviceCode() {
    return deviceCode;
  }

  public void setDeviceCode(String deviceCode) {
    this.deviceCode = deviceCode;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Map<String, Measurement> getPerformanceData() {
    return performanceData;
  }

  public void setPerformanceData(Map<String, Measurement> performanceData) {
    this.performanceData = performanceData;
  }

  public Map<String, Measurement> getSettings() {
    return settings;
  }

  public void setSettings(Map<String, Measurement> settings) {
    this.settings = settings;
  }

  public DeviceResource(String name, String deviceType, String deviceCode, String number, Map<String, Measurement> performanceData, Map<String, Measurement> settings) {

    this.name = name;
    this.deviceType = deviceType;
    this.deviceCode = deviceCode;
    this.number = number;
    this.performanceData = performanceData;
    this.settings = settings;
  }
}

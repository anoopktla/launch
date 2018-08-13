package com.km.adamos.launchpad.core.device.domain.model.enums;

public enum SupportedDevices {

  KAMCOS1("KAMCOS1","karlmayer_KAMCOS1"),
  KAMCOS2("KAMCOS2","karlmayer_KAMCOS2");

  private String deviceName;
  private String deviceType;

  private SupportedDevices(String deviceName,String deviceType){
    this.deviceName = deviceName;
    this.deviceType = deviceType;

  }

  public static boolean isSupportedDevice(String machineType){
    for(SupportedDevices supportedDevice:SupportedDevices.values()){
      if (supportedDevice.deviceType.equals(machineType)){
        return true;
      }
    }
    return false;
  }
}

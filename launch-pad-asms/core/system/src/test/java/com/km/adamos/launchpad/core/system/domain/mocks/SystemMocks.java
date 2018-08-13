package com.km.adamos.launchpad.core.system.domain.mocks;

import com.km.adamos.launchpad.core.system.domain.model.System;

public class SystemMocks {

  public static System.SystemConfiguration createValidSystemConfiguration() {

    return new System.SystemConfiguration(
      createValidSystemProperties(),
      createValidC8YProperties()
    );

  }

  public static System.SystemProperties createValidSystemProperties() {
    return new System.SystemProperties(
      "8080",
      System.C8YMode.production
    );
  }

  public static System.C8YProperties createValidC8YProperties() {
    return new System.C8YProperties(
      "nordex",
      "testNordex",
      "superSecret",
      "randomKey"
    );
  }


  public static System.SystemConfiguration createInvalidSystemConfiguration() {
    return new System.SystemConfiguration(
      createInvalidSystemProperties(),
      createInValidC8YProperties()
    );
  }

  public static System.SystemProperties createInvalidSystemProperties() {
    return new System.SystemProperties(
      "",
      System.C8YMode.production
    );
  }


  public static System.C8YProperties createInValidC8YProperties() {
    return new System.C8YProperties(
      "",
      "",
      "",
      ""
    );
  }

}

package com.km.adamos.launchpad.core.system.domain.interfaces;

import com.km.adamos.launchpad.core.system.domain.model.System;

public interface PropertyRepository {

  System.SystemProperties getSystemProperties();
  System.C8YProperties getC8YProperties();

}

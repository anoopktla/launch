package com.km.adamos.launchpad.core.common.validation.testdata;

public class NotSetPropertyValidationTestData {

  public static class PropertyObject {

    public String propertySet = "test";
    public Object notaStringProperty = 2;
    public String propertyNotSet;


    public PropertyObject() {
    }

    public PropertyObject(String propertySet, Object notAStringProperty, String propertyNotSet) {
      this.propertySet = propertySet;
      this.propertyNotSet = propertyNotSet;
      this.notaStringProperty = notAStringProperty;
    }
  }


}

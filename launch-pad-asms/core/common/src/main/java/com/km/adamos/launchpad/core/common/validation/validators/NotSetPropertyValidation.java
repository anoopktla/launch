package com.km.adamos.launchpad.core.common.validation.validators;

import com.km.adamos.launchpad.core.common.validation.PropertyValidation;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class NotSetPropertyValidation implements PropertyValidation {

  private enum Mode {
    all, required
  }

  private Object propertyObject;
  private Set<String> requiredFields;
  private Mode mode;

  public NotSetPropertyValidation(Object propertyObject, Set<String> requiredFields) {
    this.propertyObject = propertyObject;
    this.requiredFields = requiredFields;
    this.mode = Mode.required;
  }

  public NotSetPropertyValidation(Object propertyObject) {
    this.propertyObject = propertyObject;
    this.mode = Mode.all;
  }

  public Set<String> checkAndReturnInvalidProperties() {
    return gatherInvalidProps();
  }

  private Set<String> gatherInvalidProps() {
    return Arrays.stream(propertyObject.getClass().getDeclaredFields())
      .filter(field -> shouldBeAdded(propertyObject, field))
      .map(Field::getName)
      .collect(Collectors.toSet());

  }

  private boolean shouldBeAdded(Object propertyObject, Field field) {
    if (!isRequired(field.getName())) {
      return false;
    }

    try {
      Object fieldToCheck = field.get(propertyObject);
      if (fieldToCheck instanceof String) {
        return StringUtils.isBlank((String) fieldToCheck);
      } else {
        return fieldToCheck == null;
      }
    } catch (Exception e) {
      return true;
    }
  }

  private boolean isRequired(String fieldName) {
    return mode == Mode.all || requiredFields.contains(fieldName);
  }


}

package com.km.adamos.launchpad.core.common.validation.validators;

import com.km.adamos.launchpad.core.common.validation.testdata.NotSetPropertyValidationTestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.IsNull.notNullValue;

public class NotSetPropertyValidationTest {

  NotSetPropertyValidationTestData.PropertyObject propertyObject;
  Set<String> requiredFields = new HashSet<>();

  @BeforeEach
  public void setup(){
    propertyObject = new NotSetPropertyValidationTestData.PropertyObject();
    requiredFields.add("propertySet");
    requiredFields.add("propertyNotSet");
    requiredFields.add("notaStringProperty");
  }

  @Test
  @DisplayName("checkAndReturnInvalidProperties - returns empty set in case all properties are valid")
  public void checkAndReturnInvalidProperties() {

    propertyObject = new NotSetPropertyValidationTestData.PropertyObject("test", 2,"test2");

    Set<String> notSetPropsReturned = new NotSetPropertyValidation(propertyObject, requiredFields).checkAndReturnInvalidProperties();

    assertThat(notSetPropsReturned, notNullValue());
    assertThat(notSetPropsReturned, empty());

  }

  @Test
  @DisplayName("checkAndReturnInvalidProperties - returns not set properties")
  public void checkAndReturnInvalidPropertiesNotSet() {

    Set<String> notSetPropsReturned = new NotSetPropertyValidation(propertyObject, requiredFields).checkAndReturnInvalidProperties();

    assertThat(notSetPropsReturned, notNullValue());
    assertThat(notSetPropsReturned.size(), equalTo(1));
    assertThat(notSetPropsReturned.contains("propertyNotSet"), equalTo(true));

  }

  @Test
  @DisplayName("checkAndReturnInvalidProperties - returns all not set properties")
  public void checkAndReturnInvalidPropertiesNotSetMultiple() {

    propertyObject = new NotSetPropertyValidationTestData.PropertyObject(null, null, null);

    Set<String> notSetPropsReturned = new NotSetPropertyValidation(propertyObject, requiredFields).checkAndReturnInvalidProperties();

    assertThat(notSetPropsReturned, notNullValue());
    assertThat(notSetPropsReturned.size(), equalTo(3));

  }

  @Test
  @DisplayName("checkAndReturnInvalidProperties - returns empty set in case properties are not set but not required")
  public void checkAndReturnInvalidPropertiesNotSetAndNotRequired() {

    propertyObject = new NotSetPropertyValidationTestData.PropertyObject(null, null, null);

    Set<String> notSetPropsReturned = new NotSetPropertyValidation(propertyObject, Collections.emptySet()).checkAndReturnInvalidProperties();

    assertThat(notSetPropsReturned, notNullValue());

  }

  @Test
  @DisplayName("checkAndReturnInvalidProperties - checks all fields in case no required fields are not provided")
  public void checkAndReturnInvalidPropertiesAllFields() {

    propertyObject = new NotSetPropertyValidationTestData.PropertyObject();

    Set<String> notSetPropsReturned = new NotSetPropertyValidation(propertyObject).checkAndReturnInvalidProperties();

    assertThat(notSetPropsReturned, notNullValue());
    assertThat(notSetPropsReturned.size(), equalTo(1));

  }


}

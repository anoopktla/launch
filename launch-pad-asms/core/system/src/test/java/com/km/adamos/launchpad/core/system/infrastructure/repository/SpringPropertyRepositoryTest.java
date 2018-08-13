package com.km.adamos.launchpad.core.system.infrastructure.repository;

import com.km.adamos.launchpad.core.system.domain.interfaces.PropertyRepository;
import com.km.adamos.launchpad.core.system.domain.model.System;
import com.km.adamos.launchpad.core.system.infrastructure.model.ApplicationProperties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SpringPropertyRepositoryTest {

  PropertyRepository propertyRepository;
  ApplicationProperties applicationProperties;

  @BeforeEach
  public void setup() {
    applicationProperties = new ApplicationProperties();
    applicationProperties.port = "8080";
    applicationProperties.c8yHost = "test";
    applicationProperties.c8yUsername = "testUser";
    applicationProperties.c8yPassword = "testPassword";
    applicationProperties.c8yTenant = "testTenant";
    applicationProperties.cy8Mode = "production";
    propertyRepository = new SpringPropertyRepository(applicationProperties);
  }

  @Test
  @DisplayName("getSystemProperties - Returns system properties")
  public void getSystemProperties() {

    System.SystemProperties systemPropertiesExpected = new System.SystemProperties(
      "8080",
      System.C8YMode.production
    );

    System.SystemProperties systemPropertiesReturned = propertyRepository.getSystemProperties();

    assertThat(systemPropertiesExpected, equalTo(systemPropertiesReturned));

  }

  @Test
  @DisplayName("getSystemProperties - Returns system properties with c8y mode set to development in case value not set")
  public void getSystemPropertiesC8YIsNull() {

    applicationProperties.cy8Mode = null;

    System.SystemProperties systemPropertiesExpected = new System.SystemProperties(
      "8080",
      System.C8YMode.development
    );

    System.SystemProperties systemPropertiesReturned = propertyRepository.getSystemProperties();

    assertThat(systemPropertiesExpected, equalTo(systemPropertiesReturned));

  }

  @Test
  @DisplayName("getSystemProperties - Returns system properties with c8y mode set to development in case value is set to unknown")
  public void getSystemPropertiesC8YInvalid() {

    applicationProperties.cy8Mode = "random";

    System.SystemProperties systemPropertiesExpected = new System.SystemProperties(
      "8080",
      System.C8YMode.development
    );

    System.SystemProperties systemPropertiesReturned = propertyRepository.getSystemProperties();

    assertThat(systemPropertiesExpected, equalTo(systemPropertiesReturned));

  }

  @Test
  @DisplayName("getC8YProperties - Returns system properties")
  public void getC8YProperties() {

    System.C8YProperties c8YPropertiesExpected = new System.C8YProperties(
      "test",
      "testTenant",
      "testUser",
      "testPassword"
    );

    System.C8YProperties c8YPropertiesReturned = propertyRepository.getC8YProperties();

    assertThat(c8YPropertiesExpected, equalTo(c8YPropertiesReturned));

  }

}

package com.km.adamos.launchpad.core.system.domain.model;


import com.km.adamos.launchpad.core.system.domain.exceptions.InvalidSystemConfiguration;
import com.km.adamos.launchpad.core.system.domain.interfaces.PropertyRepository;
import com.km.adamos.launchpad.core.system.domain.mocks.SystemMocks;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class SystemTest {

  private System.SystemConfiguration validSystemConfiguration = SystemMocks.createValidSystemConfiguration();
  private PropertyRepository propertyRepositoryMock = mock(PropertyRepository.class);

  @BeforeEach
  public void beforeEach() {
    when(propertyRepositoryMock.getSystemProperties()).thenReturn(validSystemConfiguration.systemProperties);
    when(propertyRepositoryMock.getC8YProperties()).thenReturn(validSystemConfiguration.c8YProperties);
  }

  @AfterEach
  public void afterEach() {
    reset(propertyRepositoryMock);
  }


  @Test
  @DisplayName("systemConfiguration - Returns System Configuration")
  public void systemConfiguration() {


    System.SystemConfiguration systemConfigurationReturned = new System(propertyRepositoryMock).systemConfiguration();

    assertThat(systemConfigurationReturned, equalTo(validSystemConfiguration));
    verify(propertyRepositoryMock).getSystemProperties();
    verify(propertyRepositoryMock).getC8YProperties();

  }

  @Test
  @DisplayName("systemConfiguration - Returns service error in case prop repo throws")
  public void systemConfigurationthrowsServiceExceptionInCasePropRepoThrows() {

    when(propertyRepositoryMock.getSystemProperties()).thenThrow(new RuntimeException("Error"));

    assertThrows(RuntimeException.class, () -> {
      new System(propertyRepositoryMock).systemConfiguration();
    });
  }

  @Test
  @DisplayName("systemConfiguration - throws service error when loading system configuration when configuration is invalid")
  public void systemConfigurationInvalid() {

    System.C8YProperties invalidC8YProperties = new System.C8YProperties(
      "",
      "",
      "",
      ""
    );

    when(propertyRepositoryMock.getC8YProperties()).thenReturn(invalidC8YProperties);

    InvalidSystemConfiguration invalidSystemConfigurationReturned = assertThrows(InvalidSystemConfiguration.class, () -> {
      new System(propertyRepositoryMock).systemConfiguration();
    });

    assertThat(invalidSystemConfigurationReturned.getMessage(), notNullValue());

  }

  @Test
  @DisplayName("isSystemConfigurationValid - returns true in case system configuration is valid")
  public void isSystemConfigurationValid() {

    boolean systemConfigurationValidReturned = new System(propertyRepositoryMock).isSystemConfigurationValid();

    assertThat(systemConfigurationValidReturned, equalTo(true));

  }

  @Test
  @DisplayName("isSystemConfigurationValid - returns true in case c8y mode is development and c8y configuration is missing")
  public void isSystemConfigurationValidC8YModeDev() {

    System.C8YProperties invalidC8YProperties = new System.C8YProperties(
      "",
      "",
      "",
      ""
    );
    System.SystemProperties validSystemProperties = new System.SystemProperties(
      validSystemConfiguration.systemProperties.port,
      System.C8YMode.development
    );
    when(propertyRepositoryMock.getSystemProperties()).thenReturn(validSystemProperties);
    when(propertyRepositoryMock.getC8YProperties()).thenReturn(invalidC8YProperties);

    boolean systemConfigurationValidReturned = new System(propertyRepositoryMock).isSystemConfigurationValid();

    assertThat(systemConfigurationValidReturned, equalTo(true));

  }

  @Test
  @DisplayName("isSystemConfigurationValid - returns false in case system configuration is not valid")
  public void isSystemConfigurationInvalid() {


    when(propertyRepositoryMock.getSystemProperties()).thenReturn(SystemMocks.createInvalidSystemProperties());

    boolean systemConfigurationValidReturned = new System(propertyRepositoryMock).isSystemConfigurationValid();

    assertThat(systemConfigurationValidReturned, equalTo(false));

  }

  @Test
  @DisplayName("isSystemConfigurationValid - returns false in case c8y configuration is not valid")
  public void isSystemConfigurationInvalidC8Y() {

    when(propertyRepositoryMock.getC8YProperties()).thenReturn(SystemMocks.createInValidC8YProperties());

    boolean systemConfigurationValidReturned = new System(propertyRepositoryMock).isSystemConfigurationValid();

    assertThat(systemConfigurationValidReturned, equalTo(false));

  }

  @Test
  @DisplayName("assertSystemConfiguration - throws error in case system configuration is not valid")
  public void assertSystemConfigurationInvalidSystem() {
    System.SystemProperties validSystemProperties = SystemMocks.createInvalidSystemProperties();

    when(propertyRepositoryMock.getSystemProperties()).thenReturn(validSystemProperties);

    InvalidSystemConfiguration invalidSystemConfiguration = assertThrows(InvalidSystemConfiguration.class, () -> {
      new System(propertyRepositoryMock).assertSystemConfiguration();
    });

    assertThat(invalidSystemConfiguration.getMessage(), notNullValue());
  }

  @Test
  @DisplayName("assertSystemConfiguration - throws error in case c8y configuration is not valid")
  public void assertSystemConfigurationInvalidC8Y() {
    System.C8YProperties c8YProperties = SystemMocks.createInValidC8YProperties();

    when(propertyRepositoryMock.getC8YProperties()).thenReturn(c8YProperties);

    InvalidSystemConfiguration invalidSystemConfiguration = assertThrows(InvalidSystemConfiguration.class, () -> {
      new System(propertyRepositoryMock).assertSystemConfiguration();
    });

    assertThat(invalidSystemConfiguration.getMessage(), notNullValue());
  }

  @Test
  @DisplayName("assertSystemConfiguration - does not throw in case system configuration is valid")
  public void assertSystemConfigurationValid() {

    try {
      new System(propertyRepositoryMock).assertSystemConfiguration();
    } catch (Exception e) {
      fail("Should not throw");
    }

  }



}

package com.km.adamos.launchpad.core.system.domain.model;

import com.km.adamos.launchpad.core.system.domain.exceptions.InvalidSystemConfiguration;
import com.km.adamos.launchpad.core.system.domain.interfaces.PropertyRepository;
import com.km.adamos.launchpad.core.common.validation.ErrorMessageBuilder;
import com.km.adamos.launchpad.core.common.validation.messagebuilders.DefaultErrorMessageBuilder;
import com.km.adamos.launchpad.core.common.validation.validators.NotSetPropertyValidation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class System {

  public enum C8YMode {

    development, production, testing

  }


  public static class SystemConfiguration {


    public SystemProperties systemProperties;
    public C8YProperties c8YProperties;


    public SystemConfiguration(SystemProperties systemProperties, C8YProperties c8YProperties) {
      this.systemProperties = systemProperties;
      this.c8YProperties = c8YProperties;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      SystemConfiguration that = (SystemConfiguration) o;
      return Objects.equals(systemProperties, that.systemProperties) &&
        Objects.equals(c8YProperties, that.c8YProperties);
    }

    @Override
    public int hashCode() {

      return Objects.hash(systemProperties, c8YProperties);
    }
  }

  public static class SystemProperties {

    public String port;
    public C8YMode c8yMode;

    public SystemProperties(String port, C8YMode c8yMode) {
      this.port = port;
      this.c8yMode = c8yMode;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      SystemProperties that = (SystemProperties) o;
      return Objects.equals(port, that.port) &&
        c8yMode == that.c8yMode;
    }

    @Override
    public int hashCode() {

      return Objects.hash(port, c8yMode);
    }
  }

  public static  class C8YProperties {

    public String host;
    public String tenant;
    public String user;
    public String password;
    public String applicationKey;


    public C8YProperties(String host, String tenant, String user, String password) {
      this.host = host;
      this.tenant = tenant;
      this.user = user;
      this.password = password;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      C8YProperties that = (C8YProperties) o;
      return Objects.equals(host, that.host) &&
        Objects.equals(tenant, that.tenant) &&
        Objects.equals(user, that.user) &&
        Objects.equals(password, that.password) &&
        Objects.equals(applicationKey, that.applicationKey);
    }

    @Override
    public int hashCode() {

      return Objects.hash(host, tenant, user, password, applicationKey);
    }
  }

  private SystemConfiguration systemConfiguration;
  private Logger logger = LoggerFactory.getLogger(System.class);
  private ErrorMessageBuilder errorMessageBuilder;

  public System(PropertyRepository propertyRepository) {
    this.systemConfiguration = loadSystemConfiguration(propertyRepository);
    errorMessageBuilder = new DefaultErrorMessageBuilder();
  }

  private SystemConfiguration loadSystemConfiguration(PropertyRepository propertyRepository) {
    SystemProperties systemProperties = propertyRepository.getSystemProperties();
    C8YProperties c8YProperties = propertyRepository.getC8YProperties();
    return new SystemConfiguration(
      systemProperties,
      c8YProperties
    );
  }

  public SystemConfiguration systemConfiguration() {
    if (isSystemConfigurationValid()) {
      return systemConfiguration;
    } else {
      throw createInvalidSystemConfigurationError();
    }

  }

  private InvalidSystemConfiguration createInvalidSystemConfigurationError() {
    Set<String> missingSystemProperties = new NotSetPropertyValidation(systemConfiguration.systemProperties).checkAndReturnInvalidProperties();
    Set<String> missingC8YProperties = new NotSetPropertyValidation(systemConfiguration.c8YProperties).checkAndReturnInvalidProperties();
    String errorMessage = errorMessageBuilder
      .fromInvalidProperties(
        Stream.concat(missingSystemProperties.stream(), missingC8YProperties.stream()).collect(Collectors.toSet())
      );
    return new InvalidSystemConfiguration(errorMessage);


  }

  public boolean isSystemConfigurationValid() {
    return areSystemPropertiesValid() && areC8YPropertiesValid();
  }

  private boolean areSystemPropertiesValid() {
    Set<String> notSetProperties = new NotSetPropertyValidation(systemConfiguration.systemProperties).checkAndReturnInvalidProperties();
    return notSetProperties.isEmpty();
  }

  private boolean areC8YPropertiesValid() {
    return systemConfiguration.systemProperties.c8yMode == C8YMode.development ||
      StringUtils.isNotBlank(systemConfiguration.c8YProperties.host) &&
      StringUtils.isNotBlank(systemConfiguration.c8YProperties.user) &&
      StringUtils.isNotBlank(systemConfiguration.c8YProperties.password) &&
      StringUtils.isNotBlank(systemConfiguration.c8YProperties.tenant);
  }

  public void assertSystemConfiguration() {
    if (!isSystemConfigurationValid()) {
      logger.error("System configuration invalid");
      throw createInvalidSystemConfigurationError();
    }
  }


}

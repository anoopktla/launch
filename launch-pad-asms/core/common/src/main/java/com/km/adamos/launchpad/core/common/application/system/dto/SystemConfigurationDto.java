package com.km.adamos.launchpad.core.common.application.system.dto;

import java.util.Objects;

public class SystemConfigurationDto {

  public enum C8YMode {

    development, production, testing

  }

  public static class SystemPropertiesDto {

    public String port;
    public C8YMode c8yMode;

    public SystemPropertiesDto(String port, C8YMode c8yMode) {
      this.port = port;
      this.c8yMode = c8yMode;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      SystemPropertiesDto that = (SystemPropertiesDto) o;
      return Objects.equals(port, that.port) &&
        c8yMode == that.c8yMode;
    }

    @Override
    public int hashCode() {

      return Objects.hash(port, c8yMode);
    }
  }

  public static  class C8YPropertiesDto {

    public String host;
    public String tenant;
    public String user;
    public String password;
    public String applicationKey;


    public C8YPropertiesDto(String host, String tenant, String user, String password, String applicationKey) {
      this.host = host;
      this.tenant = tenant;
      this.user = user;
      this.password = password;
      this.applicationKey = applicationKey;
    }

    public C8YPropertiesDto(String host, String tenant, String user, String password) {
      this.host = host;
      this.tenant = tenant;
      this.user = user;
      this.password = password;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      C8YPropertiesDto that = (C8YPropertiesDto) o;
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

  public static class AgentPropertiesDto {

    public String agentName;

    public AgentPropertiesDto(String agentName) {
      this.agentName = agentName;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      AgentPropertiesDto that = (AgentPropertiesDto) o;
      return Objects.equals(agentName, that.agentName);
    }

    @Override
    public int hashCode() {

      return Objects.hash(agentName);
    }
  }

  public SystemPropertiesDto systemPropertiesDto;
  public C8YPropertiesDto c8YPropertiesDto;

  public SystemConfigurationDto(SystemPropertiesDto systemPropertiesDto, C8YPropertiesDto c8YPropertiesDto) {
    this.systemPropertiesDto = systemPropertiesDto;
    this.c8YPropertiesDto = c8YPropertiesDto;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SystemConfigurationDto that = (SystemConfigurationDto) o;
    return Objects.equals(systemPropertiesDto, that.systemPropertiesDto) &&
      Objects.equals(c8YPropertiesDto, that.c8YPropertiesDto);
  }

  @Override
  public int hashCode() {

    return Objects.hash(systemPropertiesDto, c8YPropertiesDto);
  }
}

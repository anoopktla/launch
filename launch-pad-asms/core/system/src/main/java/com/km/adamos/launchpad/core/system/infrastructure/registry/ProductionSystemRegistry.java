package com.km.adamos.launchpad.core.system.infrastructure.registry;

import com.km.adamos.launchpad.core.system.infrastructure.model.ApplicationProperties;
import com.km.adamos.launchpad.core.system.application.interfaces.SystemRegistry;
import com.km.adamos.launchpad.core.system.domain.interfaces.PropertyRepository;
import com.km.adamos.launchpad.core.system.infrastructure.repository.SpringPropertyRepository;

public class ProductionSystemRegistry implements SystemRegistry {

  private ApplicationProperties applicationProperties;

  public ProductionSystemRegistry(ApplicationProperties applicationProperties) {
    this.applicationProperties = applicationProperties;
  }

  @Override
  public PropertyRepository propertyRepository() {
    return new SpringPropertyRepository(applicationProperties);
  }
}

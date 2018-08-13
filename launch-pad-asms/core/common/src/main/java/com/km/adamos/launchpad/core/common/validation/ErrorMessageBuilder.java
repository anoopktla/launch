package com.km.adamos.launchpad.core.common.validation;

import java.util.Set;

public interface ErrorMessageBuilder {

  String fromInvalidProperties(Set<String> invalidProperties);

}

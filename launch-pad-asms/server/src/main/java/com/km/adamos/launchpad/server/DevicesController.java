package com.km.adamos.launchpad.server;


import com.km.adamos.launchpad.core.device.domain.model.Device;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/devices")
public class DevicesController {

  private Services services;

  public DevicesController(Initializer initializer) {
    this.services = initializer.getOrBootstrapServices();
  }

  @RequestMapping(method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public List<Device> getDevices() {

    return services.deviceService.loadDevices();
  }

}

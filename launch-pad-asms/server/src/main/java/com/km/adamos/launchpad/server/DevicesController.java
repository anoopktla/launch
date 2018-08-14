package com.km.adamos.launchpad.server;


import com.km.adamos.launchpad.core.device.domain.model.Device;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
  public ResponseEntity<Map<String,List<Device>>> getDevices() {
    Map<String,List<Device>> responseMap = new HashMap<>();
    responseMap.put("data",services.deviceService.loadDevices());

    ResponseEntity<Map<String,List<Device>>> responseEntity = new ResponseEntity<>(responseMap,getHttpHeaders(),HttpStatus.OK);
   return responseEntity;
  }

  private HttpHeaders getHttpHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
    headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET, POST");
    headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, HttpHeaders.CONTENT_TYPE);
    headers.add(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
    headers.add(HttpHeaders.PRAGMA, "no-cache");
    headers.add(HttpHeaders.EXPIRES, "0");
    return headers;

  }

}

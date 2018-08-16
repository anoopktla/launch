package com.km.adamos.launchpad.server;



import com.km.adamos.launchpad.core.common.error.model.NotImplementedException;
import com.km.adamos.launchpad.server.config.PaginatedResultsRetrievedEvent;
import com.km.adamos.launchpad.server.model.DeviceResource;
import com.km.adamos.launchpad.server.model.assembler.DeviceResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.*;
import com.km.adamos.launchpad.core.device.domain.model.Device;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/devices")
public class DevicesController {
  private static final int DEFAULT_PAGE_SIZE = 5;
  private static final int DEFAULT_PAGE = 0;

  private Services services;

  @Autowired
  private ApplicationEventPublisher eventPublisher;

  public DevicesController(Initializer initializer) {
    this.services = initializer.getOrBootstrapServices();
  }

  @RequestMapping(method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public ResponseEntity<Page<DeviceResource>> getDevices(@RequestParam( "page") int page,
                                                         @RequestParam( "pageSize" ) int size,
                                                         UriComponentsBuilder uriBuilder, HttpServletResponse response) {
    List<Device> devices  = services.deviceService.loadDevices();
    DeviceResourceAssembler deviceAssembler = new DeviceResourceAssembler();

    List<DeviceResource> deviceResources = deviceAssembler.toResources(devices);
    Page<DeviceResource> pagedDevice = new PageImpl<>(deviceResources);

    eventPublisher.publishEvent( new PaginatedResultsRetrievedEvent< DeviceResource >
      ( DeviceResource.class, uriBuilder, response, page, pagedDevice.getTotalPages(), size ) );

    ResponseEntity<Page<DeviceResource>> responseEntity = new ResponseEntity<>(pagedDevice,getHttpHeaders(),HttpStatus.OK);
   return responseEntity;
  }


  @RequestMapping(value = "/{id}",method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public ResponseEntity<DeviceResource> getDevice(@PathVariable(value = "id") String id) {

    throw new NotImplementedException();
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

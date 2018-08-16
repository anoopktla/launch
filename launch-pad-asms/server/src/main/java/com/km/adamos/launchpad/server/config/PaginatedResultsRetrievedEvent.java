package com.km.adamos.launchpad.server.config;

import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationEvent;
import org.springframework.web.util.UriComponentsBuilder;

public class PaginatedResultsRetrievedEvent<DeviceResource> extends ApplicationEvent {
  private Class clazz ;
  private UriComponentsBuilder uriComponentsBuilder;
  private HttpServletResponse httpResponse;
  private int page;
  private int totalPages;
  private int size;
  public PaginatedResultsRetrievedEvent(Object source) {
    super(source);

  }


  public PaginatedResultsRetrievedEvent(Class clazz, UriComponentsBuilder uriComponentsBuilder,HttpServletResponse response,
                                        int page, int totalPages,int size){
    super(clazz);
this.clazz = clazz;
this.uriComponentsBuilder = uriComponentsBuilder;
this.httpResponse = response;
this.page = page;
this.totalPages = totalPages;
this.size = size;

  }

  public Class getClazz() {
    return clazz;
  }

  public UriComponentsBuilder getUriComponentsBuilder() {
    return uriComponentsBuilder;
  }

  public HttpServletResponse getHttpResponse() {
    return httpResponse;
  }

  public int getPage() {
    return page;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public int getSize() {
    return size;
  }
}

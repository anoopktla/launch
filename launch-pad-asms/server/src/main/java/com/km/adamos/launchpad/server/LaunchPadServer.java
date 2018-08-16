package com.km.adamos.launchpad.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication(scanBasePackages = "com.km.adamos")
@EnableHypermediaSupport(type= {EnableHypermediaSupport.HypermediaType.HAL})
public class LaunchPadServer {

  public static void main(String[] args) {
    SpringApplication.run(LaunchPadServer.class, args);
  }

}

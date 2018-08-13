package com.km.adamos.launchpad.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.km.adamos")
public class LaunchPadServer {

  public static void main(String[] args) {
    SpringApplication.run(LaunchPadServer.class, args);
  }

}

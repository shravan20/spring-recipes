package com.moodle.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class IntegrationApplication {

  public static void main(String[] args) {
    SpringApplication.run(IntegrationApplication.class, args);
  }
}

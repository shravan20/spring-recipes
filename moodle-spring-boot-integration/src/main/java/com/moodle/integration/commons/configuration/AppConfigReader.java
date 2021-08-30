package com.moodle.integration.commons.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PropertySource(
    ignoreResourceNotFound = true,
    value = {"classpath:application.properties"})
public class AppConfigReader {

  @Value("${port}")
  private Long port;
}

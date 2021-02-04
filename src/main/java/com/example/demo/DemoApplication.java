package com.example.demo;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.logging.LoggingMeterRegistry;
import io.micrometer.core.instrument.logging.LoggingRegistryConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

@SpringBootApplication
public class DemoApplication {
//	@Value("${Pod_Name}")
//	private String PodName;
//	@Bean
//	MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
//		return registry -> registry.config().commonTags("Pod", PodName);
//	}
//	@Bean
//	LoggingMeterRegistry loggingMeterRegistry() {
//
//
//		return new LoggingMeterRegistry(new LoggingRegistryConfig() {
//			@Override
//			public Duration step() {
//				return Duration.ofSeconds(5); // log every 10 seconds
//			}
//
//			@Override
//			public String get(String key) {
//				return null;
//			}
//		}, Clock.SYSTEM);
//	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}


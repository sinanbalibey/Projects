package com.sibacode.monitoring.example.grafanaprometheus;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;


@SpringBootApplication
public class GrafanaPrometheusApplication {



	public static void main(String[] args) {
		SpringApplication.run(GrafanaPrometheusApplication.class, args);
	}



}

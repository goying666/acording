package com.renchaigao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan("com.renchaigao.dao")
public class AcordingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcordingApplication.class, args);
	}
}

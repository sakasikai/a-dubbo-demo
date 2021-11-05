package org.apache.dubbo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("spring/dubbo-provider.xml")
public class DubboProvider1Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DubboProvider1Application.class, args);
	}
}

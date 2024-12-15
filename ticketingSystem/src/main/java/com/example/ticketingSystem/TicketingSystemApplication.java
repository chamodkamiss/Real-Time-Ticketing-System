package com.example.ticketingSystem;

import com.example.ticketingSystem.controller.config.Config;
//import com.example.ticketingSystem.controller.entity.Vendor;
import com.example.ticketingSystem.controller.util.CustomerRunnable;
import com.example.ticketingSystem.controller.util.TicketPool;
import com.example.ticketingSystem.controller.util.VendorRunnable;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;

@SpringBootApplication
public class TicketingSystemApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(TicketingSystemApplication.class, args);


	}



	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Configuration
	public class WebConfig implements WebMvcConfigurer {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**").allowedOrigins("http://localhost:4200");
		}
	}

}

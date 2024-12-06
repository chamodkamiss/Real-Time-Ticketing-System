package com.example.ticketingSystem;

import com.example.ticketingSystem.controller.config.Config;
import com.example.ticketingSystem.controller.config.ConfigLoader;
import com.example.ticketingSystem.controller.util.CustomerRunnable;
import com.example.ticketingSystem.controller.util.TicketPool;
import com.example.ticketingSystem.controller.util.VendorRunnable;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TicketingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketingSystemApplication.class, args);
		Config Config = new Config();

		TicketPool ticketPool = new TicketPool(Config);

		Thread vendor1 = new Thread(new VendorRunnable(ticketPool,5));


//		Thread customer1 = new Thread(new CustomerRunnable(ticketPool,con));

		vendor1.start();
//		customer1.start();

	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}



}

package com.example.ticketingSystem;

import com.example.ticketingSystem.controller.config.Config;
import com.example.ticketingSystem.controller.config.ConfigLoader;
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

@SpringBootApplication
public class TicketingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketingSystemApplication.class, args);

//		TicketPool ticketPool = new TicketPool(ConfigLoader.getCliconfig());
//		Thread vendor1 = new Thread(new VendorRunnable(ticketPool, 10, "Vendor1", ConfigLoader.getCliconfig().getReleaseRate()));
//		Thread vendor2 = new Thread(new VendorRunnable(ticketPool, 6, "Vendor2", ConfigLoader.getCliconfig().getReleaseRate()));
//
//		Thread customer1 = new Thread(new CustomerRunnable(ticketPool, 5, "Customer1", ConfigLoader.getCliconfig().getRetrievalRate()));
//		Thread customer2 = new Thread(new CustomerRunnable(ticketPool, 4, "Customer2", ConfigLoader.getCliconfig().getRetrievalRate()));
//
//		vendor1.start();
//		vendor2.start();
//		customer1.start();
//		customer2.start();
//
//		new Thread(() -> {
//			while (vendor1.isAlive() || vendor2.isAlive() || customer1.isAlive() || customer2.isAlive()) {
//				System.out.println("Current pool size: " + ticketPool.getTickets().size());
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//			System.out.println("All threads finished.");
//			System.out.println("Final pool size: " + ticketPool.getTickets().size());
//		}).start();
//		try {
//			vendor1.join();
//
//		} catch (InterruptedException e) {
//			System.out.println("Main thread interrupted while waiting for vendor.");
//		}
//		Thread customer2 = new Thread(new CustomerRunnable(ticketPool, 5, "Customer2", ConfigLoader.getCliconfig().getRetrievalRate()));
//		customer2.start();
//		try {
//			customer2.join();
//
//		} catch (InterruptedException e) {
//			System.out.println("Main thread interrupted while waiting for customer.");
//		}

//		Thread vendor2 = new Thread(new VendorRunnable(ticketPool, 5, "Vendor2", ConfigLoader.getCliconfig().getReleaseRate()));
//		Thread vendorThread2 = new Thread(vendor2);
//		vendorThread2.start();
//		try {
//			vendorThread2.join();
//
//		} catch (InterruptedException e) {
//			System.out.println("Main thread interrupted while waiting for vendor.");
//		}
//
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

package com.elisha.foodcatalogue;

import com.elisha.foodcatalogue.dto.FoodItemDTO;
import com.elisha.foodcatalogue.entity.FoodItem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class FoodCatalogueMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodCatalogueMicroserviceApplication.class, args);

		FoodItem foodItem = new FoodItem();
		foodItem.setItemName("VEG KURMA");
		System.out.println("ITEM NAME:"+foodItem.getItemName());
		//FoodItemDTO foodItemDTO = new FoodItemDTO();

	}



	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}

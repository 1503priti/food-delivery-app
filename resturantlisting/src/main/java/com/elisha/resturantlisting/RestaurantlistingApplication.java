package com.elisha.resturantlisting;

import com.elisha.resturantlisting.dto.RestaurantDTO;
import com.elisha.resturantlisting.entity.Restaurant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableDiscoveryClient
@Configuration

public class RestaurantlistingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantlistingApplication.class, args);
		RestaurantDTO restaurantDTO = new RestaurantDTO();
		restaurantDTO.setId(1);
		restaurantDTO.setCity("bbb");
		restaurantDTO.setAddress("xxx");
		System.out.println(restaurantDTO.getId());
		System.out.println(restaurantDTO.getAddress());
		Restaurant restaurant = new Restaurant();
		//restaurant.getCity();
	}

}

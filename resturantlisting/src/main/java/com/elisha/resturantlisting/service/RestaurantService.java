package com.elisha.resturantlisting.service;

import com.elisha.resturantlisting.dto.RestaurantDTO;
import com.elisha.resturantlisting.entity.Restaurant;
import com.elisha.resturantlisting.mapper.RestaurantMapper;
import com.elisha.resturantlisting.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepo restaurantRepo;

    public List<RestaurantDTO> findAllRestaurant() {
        List<Restaurant>  restaurants = restaurantRepo.findAll();
        // map it to list of DTOs
        /*List<RestaurantDTO>  restaurantDTOList =  restaurants.stream()
                                                         .map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant))
                                                         .collect(Collectors.toList()
        return restaurantDTOList;*/
        return restaurants.stream().map(RestaurantMapper.INSTANCE::mapRestaurantToRestaurantDTO).collect(Collectors.toList());


    }
}

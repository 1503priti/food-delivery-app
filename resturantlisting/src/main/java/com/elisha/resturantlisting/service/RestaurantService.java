package com.elisha.resturantlisting.service;

import com.elisha.resturantlisting.dto.RestaurantDTO;
import com.elisha.resturantlisting.entity.Restaurant;
import com.elisha.resturantlisting.mapper.RestaurantMapper;
import com.elisha.resturantlisting.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
       // restaurantRepo.findAll().stream().map(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(Restaurant restaurant));
        return restaurants.stream().map(RestaurantMapper.INSTANCE::mapRestaurantToRestaurantDTO).collect(Collectors.toList());


    }

    public RestaurantDTO addRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant saveRestaurant = restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO));
     return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(saveRestaurant);
    }

    public ResponseEntity<RestaurantDTO> fetchRestaurantById(Integer id) {
        Optional<Restaurant> restaurant =restaurantRepo.findById(id);
        return restaurant.map(value -> new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
        /*return restaurant
                .map(value -> new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant.get()), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));*/
    }
}

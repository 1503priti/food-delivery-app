package com.elisha.resturantlisting.controller;

import com.elisha.resturantlisting.dto.RestaurantDTO;
import com.elisha.resturantlisting.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurant(){
        List<RestaurantDTO> allRestaurants = restaurantService.
                findAllRestaurant();
        return new ResponseEntity<>(allRestaurants,HttpStatus.OK);

    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDTO> saveRestaurant(@RequestBody RestaurantDTO restaurantDTO){
        RestaurantDTO restaurantAdd = restaurantService.
                addRestaurant(restaurantDTO);
        return new ResponseEntity<>(restaurantAdd,HttpStatus.CREATED);

    }


    @GetMapping("/fetchById/{id}")
    public ResponseEntity<RestaurantDTO> findRestaurantById(@PathVariable Integer id){
        return restaurantService.fetchRestaurantById(id);
    }


}

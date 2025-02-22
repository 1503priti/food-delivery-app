package com.elisha.resturantlisting.controller;

import com.elisha.resturantlisting.dto.RestaurantDTO;
import com.elisha.resturantlisting.service.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
//what u want to call become inject mock and what u do not call become mock

public class RestaurantControllerTest {

      @InjectMocks
      RestaurantController restaurantController;
       @Mock
       RestaurantService restaurantService;

       @BeforeEach
       public void setUp(){
           MockitoAnnotations.openMocks(this);
       }
    @Test
    public void testfetchAllRestaurants(){
        // create the test data
        // call the test data - rstaurantcontorller need to call become inject data
        //assert and varify the tests
        // mock service behaviour
        List<RestaurantDTO> mockRestaurants = Arrays.asList(
                new RestaurantDTO(1, "Restaurant 1", "Address 1", "City 1", "Desc 1"),
                new RestaurantDTO(2, "Restaurant 2", "Address 2", "City 2", "Desc 2")
        );
        when(restaurantService.findAllRestaurant()).thenReturn(mockRestaurants);
        // call the controller method
        ResponseEntity<List<RestaurantDTO>> response = restaurantController.fetchAllRestaurant();
        // verify response
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(mockRestaurants, response.getBody());
        // verify that the service method was called
        verify(restaurantService, times(1)).findAllRestaurant();

    }
    @Test
    public void testSaveRestaurant(){
           // create a mock restaurant to be saved
        RestaurantDTO mockRestaurant =  new RestaurantDTO(1, "Restaurant 1", "Address 1", "City 1", "Desc 1");
        // Mock the service behaviour
        when(restaurantService.addRestaurant(mockRestaurant)).thenReturn(mockRestaurant);
        // call the controller method
        ResponseEntity<RestaurantDTO> response = restaurantController.saveRestaurant(mockRestaurant);
        //verify the response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockRestaurant, response.getBody());
        // verify that the service method was called
        verify(restaurantService, times(1)).addRestaurant(mockRestaurant);
    }
    @Test
    public void testFindRestaurantById(){
           // Create a mock restaurant ID
        Integer mockRestaurantId = 1;
        // create a mock restaurant to be returned by the service
        RestaurantDTO mockRestaurant =  new RestaurantDTO(1, "Restaurant 1", "Address 1", "City 1", "Desc 1");
        // Mock the service behaviour
        when(restaurantService.fetchRestaurantById(mockRestaurantId)).thenReturn(new ResponseEntity<>(mockRestaurant, HttpStatus.OK));
         // Call the controller method
        ResponseEntity<RestaurantDTO> response = restaurantController.findRestaurantById(mockRestaurantId);

        // verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockRestaurant, response.getBody());

        //verify that the service method was called
        verify(restaurantService, times(1)).fetchRestaurantById(mockRestaurantId);
    }
}

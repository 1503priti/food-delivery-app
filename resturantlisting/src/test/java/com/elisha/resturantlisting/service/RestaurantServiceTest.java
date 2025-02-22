package com.elisha.resturantlisting.service;

import com.elisha.resturantlisting.dto.RestaurantDTO;
import com.elisha.resturantlisting.entity.Restaurant;
import com.elisha.resturantlisting.mapper.RestaurantMapper;
import com.elisha.resturantlisting.repo.RestaurantRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class RestaurantServiceTest {


    @Mock
    RestaurantRepo restaurantRepo;

    @InjectMocks
    RestaurantService restaurantService;

    @BeforeEach
    public void setUp(){

        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testFindAllRestaurant(){
        // Create mock restaurants
        List<Restaurant> mockRestaurants = Arrays.asList(
                new Restaurant(1, "Restaurant 1", "Address 1", "City 1", "Desc 1"),
                new Restaurant(2, "Restaurant 2", "Address 2", "City 2", "Desc 2")
        );
        when(restaurantRepo.findAll()).thenReturn(mockRestaurants);
        // call the service method
        List<RestaurantDTO> restaurantDTOList = restaurantService.findAllRestaurant();

        // verify the result
        assertEquals(mockRestaurants.size(), restaurantDTOList.size());
        for(int i = 0 ; i<mockRestaurants.size();i++){
            RestaurantDTO expectedDTO = RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(mockRestaurants.get(i));
            assertEquals(expectedDTO, restaurantDTOList.get(i));
        }
        // Verify that the repository method was called
        verify(restaurantRepo, times(1)).findAll();

    }
    @Test
    public void testAddRestaurant(){
     // Create a mock restaurant to be saved
        RestaurantDTO mockRestaurantDTO = new RestaurantDTO(1, "Restaurant 1", "Address 1", "City 1", "Desc 1");
        Restaurant mockRestaurant = RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(mockRestaurantDTO);
        // mock the repository behaviour
        when(restaurantRepo.save(mockRestaurant)).thenReturn(mockRestaurant);

        // call the service method
        RestaurantDTO savedRestaurantDTO = restaurantService.addRestaurant(mockRestaurantDTO);

        // verify the result
        assertEquals(mockRestaurantDTO, savedRestaurantDTO);

        // verify that the repository method was called
        verify(restaurantRepo, times(1)).save(mockRestaurant);

    }
    @Test
    public void testFetchRestaurantById_ExistingId(){
        // create a mock restaurantId
        Integer mockRestaurantId = 1;

        // create a mock restaurant to be return by the repository
         Restaurant mockRestaurant = new Restaurant(1, "Restaurant 1", "Address 1", "City 1", "Desc 1");

         // Mock the repository behaviour
        when(restaurantRepo.findById(mockRestaurantId)).thenReturn(Optional.of(mockRestaurant));

        // call the service method
        ResponseEntity<RestaurantDTO> response = restaurantService.fetchRestaurantById(mockRestaurantId);

        // verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockRestaurantId, Objects.requireNonNull(response.getBody()).getId());

        // verify that the repository method was called
        verify(restaurantRepo, times(1)).findById(mockRestaurantId);

    }
    @Test
    public void testFetchRestaurantById_NonExistingId(){

        // create a mock restaurantId
        Integer mockRestaurantId = 1;


        // Mock the repository behaviour
        when(restaurantRepo.findById(mockRestaurantId)).thenReturn(Optional.empty());

        // call the service method
        ResponseEntity<RestaurantDTO> response = restaurantService.fetchRestaurantById(mockRestaurantId);

        // verify the response
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody()); //assertEquals(null, response.getBody());

        // verify that the repository method was called
        verify(restaurantRepo, times(1)).findById(mockRestaurantId);

    }
}

package com.elisha.foodcatalogue.service;

import com.elisha.foodcatalogue.dto.FoodCataloguePage;
import com.elisha.foodcatalogue.dto.FoodItemDTO;
import com.elisha.foodcatalogue.dto.Restaurant;
import com.elisha.foodcatalogue.entity.FoodItem;
import com.elisha.foodcatalogue.mapper.FoodItemMapper;
import com.elisha.foodcatalogue.repo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodCatalogueService {

    @Autowired
    FoodItemRepo foodItemRepo;

    @Autowired
    RestTemplate restTemplate;

    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem foodItemSavedInDB  = foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
         return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(foodItemSavedInDB);
    }

    public FoodCataloguePage CataloguePageDetails(Integer restaurantId) {
        // FOOD ITEM LIST
        //RESTAURANTDETAILS
        List<FoodItem> foodItemList = fetchFoodItemList(restaurantId);
        Restaurant restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
      return   createFoodCataloguePage(foodItemList,restaurant);
    }

    private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
       FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItemsList(foodItemList);
        foodCataloguePage.setRestaurant(restaurant);
        return foodCataloguePage;
    }

    private Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
      return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/"+restaurantId,Restaurant.class);

    }

    private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
        return foodItemRepo.findByRestaurantId(restaurantId);
    }
}

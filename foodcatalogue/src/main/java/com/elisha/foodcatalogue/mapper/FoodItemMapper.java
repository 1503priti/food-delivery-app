package com.elisha.foodcatalogue.mapper;

import com.elisha.foodcatalogue.dto.FoodItemDTO;
import com.elisha.foodcatalogue.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {
    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

    FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);

    FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem);

}

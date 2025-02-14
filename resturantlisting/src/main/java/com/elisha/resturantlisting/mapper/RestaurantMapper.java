package com.elisha.resturantlisting.mapper;

import com.elisha.resturantlisting.dto.RestaurantDTO;
import com.elisha.resturantlisting.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
//https://ethan26.medium.com/mapper-mapping-in-spring-boot-dca8a2633bfe -resolve @Mapper

@Mapper
public interface RestaurantMapper {
    RestaurantMapper INSTANCE =  Mappers.getMapper(RestaurantMapper.class);

    Restaurant mapRestaurantDTOToRestaurant(RestaurantDTO restaurantDTO);

    RestaurantDTO mapRestaurantToRestaurantDTO(Restaurant restaurant);

}

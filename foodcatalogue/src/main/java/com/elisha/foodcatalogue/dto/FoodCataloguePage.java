package com.elisha.foodcatalogue.dto;

import com.elisha.foodcatalogue.entity.FoodItem;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCataloguePage {
    private List<FoodItem> foodItemsList;
    private Restaurant restaurant;
}

package com.elisha.foodcatalogue.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String itemName;

    private String itemDescription;

    private boolean isVeg;

    private Number price;

    private Integer restaurantId;

    @Column(nullable = false, columnDefinition = "INT Default 0")
    private Integer quantity;


}

package com.elisha.order.entity;

import com.elisha.order.dto.FoodItemsDTO;
import com.elisha.order.dto.Restaurant;
import com.elisha.order.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {


    /*@Transient
    public static final String SEQUENCE_NAME = "order_sequence";
*/
    private Integer orderId;
    private List<FoodItemsDTO> foodItemsDTOList;
    private Restaurant restaurant;
    private UserDTO userDTO;


}

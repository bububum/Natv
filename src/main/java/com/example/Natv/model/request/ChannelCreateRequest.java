package com.example.Natv.model.request;

import com.example.Natv.model.DTO.DiscountDTO;
import com.example.Natv.model.DTO.OrderBookDTO;
import com.example.Natv.model.DTO.OrderDTO;
import com.example.Natv.model.entity.Discount;
import com.example.Natv.model.entity.Order;
import com.example.Natv.model.enums.Status;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChannelCreateRequest {

    String name;
    Integer price;
    Integer rating;
    MultipartFile logo;

}
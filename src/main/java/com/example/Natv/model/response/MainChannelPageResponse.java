package com.example.Natv.model.response;

import com.example.Natv.model.DTO.DiscountDTO;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class MainChannelPageResponse {

    Long channelId;
    String channelName;
    Integer price;
    List<DiscountDTO> discounts;
}

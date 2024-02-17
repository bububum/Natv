package com.example.Natv.model.response;

import com.example.Natv.model.DTO.DiscountDTO;

import java.util.Set;

public class MainChannelPageResponse {

    Long channelId;
    String channelName;
    Integer price;
    Set<DiscountDTO> discounts;
}

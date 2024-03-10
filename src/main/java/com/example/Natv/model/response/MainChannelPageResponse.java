package com.example.Natv.model.response;

import com.example.Natv.model.DTO.DiscountDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
public class MainChannelPageResponse {

    Long channelId;
    String channelName;
    BigDecimal price;
    List<DiscountResponse> discounts;
}

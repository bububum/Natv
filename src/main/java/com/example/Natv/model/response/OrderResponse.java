package com.example.Natv.model.response;

import com.example.Natv.model.DTO.ChannelDTO;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class OrderResponse {

    BigDecimal totalPrice;
    BigDecimal totalPriceWithDisc;
    List<ChannelResponse> channels;
}

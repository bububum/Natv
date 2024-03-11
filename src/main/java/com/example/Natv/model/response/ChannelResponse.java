package com.example.Natv.model.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ChannelResponse {

    String name;
    BigDecimal price;
    BigDecimal priceWithDisc;
}

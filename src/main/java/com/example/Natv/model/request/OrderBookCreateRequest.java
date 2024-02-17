package com.example.Natv.model.request;

import com.example.Natv.model.DTO.ChannelDTO;
import com.example.Natv.model.DTO.OrderDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderBookCreateRequest {

    LocalDate bookDate;
    Integer price;

    OrderDTO order;

    ChannelDTO channel;
}

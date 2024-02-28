package com.example.Natv.model.DTO;

import com.example.Natv.base.BaseDto;
import com.example.Natv.model.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
@ToString
public class ChannelDTO extends BaseDto {

    String name;
    Integer price;
    Integer rating;
    Status status;
    List<DiscountDTO> discounts;
    List<OrderDTO> orders;
}

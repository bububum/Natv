package com.example.Natv.model.DTO;

import com.example.Natv.base.BaseDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@ToString
public class ChannelDiscountDTO extends BaseDto {
    DiscountDTO discount;
    ChannelDTO channel;
}
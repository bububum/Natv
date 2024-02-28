package com.example.Natv.model.DTO;

import com.example.Natv.base.BaseDto;
import com.example.Natv.model.entity.User;
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
public class OrderDTO extends BaseDto {

    String text;
    Integer totalPrice;
    UserDTO user;
    List<ChannelDTO> channels;
}

package com.example.Natv.model.DTO;

import com.example.Natv.base.BaseDto;
import com.example.Natv.model.entity.User;
import com.example.Natv.model.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.net.StandardSocketOptions;
import java.util.List;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@ToString
public class OrderDTO extends BaseDto {

    String text;
    Integer totalPrice;
    UserDTO user;
    Status status;

}

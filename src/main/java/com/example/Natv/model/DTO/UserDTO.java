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
public class UserDTO extends BaseDto {

    String name;
    String lastname;
    String middleName;
    String email;
    String phone_num;
}
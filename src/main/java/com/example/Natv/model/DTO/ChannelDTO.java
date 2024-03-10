package com.example.Natv.model.DTO;

import com.example.Natv.base.BaseDto;
import com.example.Natv.model.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class ChannelDTO extends BaseDto {

    String name;
    Integer price;
    Integer rating;
    Status status;
    String logo;

    public ChannelDTO(Long id) {
        super(id);
    }
}
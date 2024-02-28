package com.example.Natv.model.DTO;

import com.example.Natv.base.BaseDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
@ToString
public class DiscountDTO extends BaseDto {

    Integer percent;
    Integer days;
    String definition;
    LocalDate startDate;
    LocalDate endDate;
    List<ChannelDTO> channels;
}

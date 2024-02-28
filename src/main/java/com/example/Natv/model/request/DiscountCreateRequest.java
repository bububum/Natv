package com.example.Natv.model.request;

import com.example.Natv.model.DTO.ChannelDTO;
import com.example.Natv.model.entity.Channel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscountCreateRequest {

    Integer percent;
    Integer days;
    String definition;
    LocalDate startDate;
    LocalDate endDate;
    List<Long> channelsId;
}

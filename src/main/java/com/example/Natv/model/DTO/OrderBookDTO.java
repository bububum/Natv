package com.example.Natv.model.DTO;

import com.example.Natv.base.BaseDto;
import com.example.Natv.model.entity.Channel;
import com.example.Natv.model.entity.Order;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@ToString
public class OrderBookDTO extends BaseDto {

    List<LocalDate> bookDate;
    Integer price;

    OrderDTO order;

    ChannelDTO channel;
}


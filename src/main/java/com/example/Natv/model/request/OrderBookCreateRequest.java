package com.example.Natv.model.request;

import com.example.Natv.model.DTO.ChannelDTO;
import com.example.Natv.model.DTO.OrderDTO;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderBookCreateRequest {
}

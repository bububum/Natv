package com.example.Natv.model.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ChannelOrderRequest {
    Long id;
    List<LocalDate> days;
}

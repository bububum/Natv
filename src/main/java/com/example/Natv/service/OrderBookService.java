package com.example.Natv.service;

import com.example.Natv.base.BaseService;
import com.example.Natv.model.DTO.OrderBookDTO;
import com.example.Natv.model.DTO.UserDTO;
import com.example.Natv.model.entity.OrderBook;
import com.example.Natv.model.request.OrderBookCreateRequest;

import java.util.List;

public interface OrderBookService extends BaseService<OrderBookDTO> {

    void create(OrderBookCreateRequest request);

    void saveAll(List<OrderBookDTO> orderBooks);
}

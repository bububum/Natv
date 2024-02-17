package com.example.Natv.service;

import com.example.Natv.base.BaseService;
import com.example.Natv.model.DTO.OrderBookDTO;
import com.example.Natv.model.DTO.UserDTO;
import com.example.Natv.model.request.OrderBookCreateRequest;

public interface OrderBookService extends BaseService<OrderBookDTO> {

    void create(OrderBookCreateRequest request);
}

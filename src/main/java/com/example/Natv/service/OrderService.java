package com.example.Natv.service;

import com.example.Natv.base.BaseService;
import com.example.Natv.model.DTO.OrderDTO;
import com.example.Natv.model.DTO.UserDTO;
import com.example.Natv.model.request.OrderBookCreateRequest;
import com.example.Natv.model.request.OrderCreateRequest;
import com.example.Natv.model.response.OrderResponse;

public interface OrderService extends BaseService<OrderDTO> {

    OrderResponse create(OrderCreateRequest request);
}

package com.example.Natv.service;

import com.example.Natv.base.BaseService;
import com.example.Natv.model.DTO.OrderDTO;
import com.example.Natv.model.DTO.UserDTO;
import com.example.Natv.model.request.OrderBookCreateRequest;
import com.example.Natv.model.request.OrderCreateRequest;

public interface OrderService extends BaseService<OrderDTO> {

    String create(OrderCreateRequest request);
}

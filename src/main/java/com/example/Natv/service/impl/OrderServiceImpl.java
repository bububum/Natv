package com.example.Natv.service.impl;

import com.example.Natv.base.BaseServiceImpl;
import com.example.Natv.dao.OrderRepository;
import com.example.Natv.dao.UserRepository;
import com.example.Natv.mapper.OrderMapper;
import com.example.Natv.mapper.UserMapper;
import com.example.Natv.model.DTO.OrderDTO;
import com.example.Natv.model.DTO.UserDTO;
import com.example.Natv.model.entity.Order;
import com.example.Natv.model.entity.User;
import com.example.Natv.model.request.OrderCreateRequest;
import com.example.Natv.service.OrderService;
import com.example.Natv.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order, OrderRepository, OrderDTO, OrderMapper> implements OrderService {
    public OrderServiceImpl(OrderRepository rep, OrderMapper mapper) {
        super(rep, mapper);
    }

    @Override
    public void create(OrderCreateRequest request) {
        OrderDTO order = OrderDTO.builder()
                .user(request.getUserDTO())
                .channels(request.getChannels())
                .totalPrice(request.getTotalPrice())
                .text(request.getText())
                .build();

        save(order);
    }
}

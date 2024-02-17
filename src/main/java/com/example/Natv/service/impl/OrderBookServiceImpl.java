package com.example.Natv.service.impl;

import com.example.Natv.base.BaseServiceImpl;
import com.example.Natv.dao.OrderBookRepository;
import com.example.Natv.dao.UserRepository;
import com.example.Natv.mapper.OrderBookMapper;
import com.example.Natv.mapper.UserMapper;
import com.example.Natv.model.DTO.OrderBookDTO;
import com.example.Natv.model.DTO.UserDTO;
import com.example.Natv.model.entity.OrderBook;
import com.example.Natv.model.entity.User;
import com.example.Natv.model.request.OrderBookCreateRequest;
import com.example.Natv.service.OrderBookService;
import com.example.Natv.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class OrderBookServiceImpl extends BaseServiceImpl<OrderBook, OrderBookRepository, OrderBookDTO, OrderBookMapper> implements OrderBookService {
    public OrderBookServiceImpl(OrderBookRepository rep, OrderBookMapper mapper) {
        super(rep, mapper);
    }

    @Override
    public void create(OrderBookCreateRequest request) {
        OrderBook orderBook = OrderBook.builder()
                .bookDate(request.getBookDate())
                .order(mapper.toEntity(request.getOrder(), context))
                .channel(mapper.toEntity(request.getChannel(), context))
                .price(request.getPrice())
                .build();

        save(mapper.toDto(orderBook, context));
    }
}

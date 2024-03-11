package com.example.Natv.service.impl;

import com.example.Natv.base.BaseServiceImpl;
import com.example.Natv.dao.OrderRepository;
import com.example.Natv.mapper.OrderBookMapper;
import com.example.Natv.mapper.OrderMapper;
import com.example.Natv.model.DTO.ChannelDTO;
import com.example.Natv.model.DTO.OrderBookDTO;
import com.example.Natv.model.DTO.OrderDTO;
import com.example.Natv.model.DTO.UserDTO;
import com.example.Natv.model.entity.Order;
import com.example.Natv.model.enums.Status;
import com.example.Natv.model.request.OrderCreateRequest;
import com.example.Natv.model.request.ChannelOrderRequest;
import com.example.Natv.service.ChannelService;
import com.example.Natv.service.OrderBookService;
import com.example.Natv.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order, OrderRepository, OrderDTO, OrderMapper> implements OrderService {
    public OrderServiceImpl(OrderRepository rep, OrderMapper mapper, ChannelService channelService, OrderBookService orderBookService) {
        super(rep, mapper);
        this.channelService = channelService;
        this.orderBookService = orderBookService;
    }

    private final ChannelService channelService;
    private final OrderBookService orderBookService;

    @Override
    public String create(OrderCreateRequest request) {

        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(request.getEmail());
        userDTO.setName(request.getName());
        userDTO.setStatus(Status.ACTIVE);
        userDTO.setPhone_num(request.getPhone());
        userDTO.setCreatedDate(LocalDateTime.now());
        userDTO.setUpdatedDate(LocalDateTime.now());


        OrderDTO order = new OrderDTO();
        order.setText(request.getText());
        order.setUser(userDTO);
        order.setStatus(Status.ACTIVE);


        ChannelDTO channelDTO = new ChannelDTO();
        Integer totalPrice = 0;
        List<OrderBookDTO> orderBookDTOS = new ArrayList<>();

        for(ChannelOrderRequest item: request.getChannels()) {

            channelDTO = channelService.findById(item.getId());
            List<LocalDate> bookingDates = new ArrayList<>();

            for (LocalDate book : item.getDays()) {
                bookingDates.add(book);
            }

            OrderBookDTO orderBookDTO = new OrderBookDTO();
            orderBookDTO.setOrder(order);
            orderBookDTO.setBookDate(bookingDates);
            orderBookDTO.setChannel(channelDTO);
            orderBookDTO.setPrice(channelDTO.getPrice()*order.getText().replaceAll("\\s", "").length());

            totalPrice +=orderBookDTO.getPrice();
            orderBookDTOS.add(orderBookDTO);
        }

        order.setTotalPrice(totalPrice);

        save(order);
        orderBookService.saveAll(orderBookDTOS);



        return "Success";

    }
}
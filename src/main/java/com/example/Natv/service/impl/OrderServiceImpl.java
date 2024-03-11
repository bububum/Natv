package com.example.Natv.service.impl;

import com.example.Natv.base.BaseServiceImpl;
import com.example.Natv.dao.OrderRepository;
import com.example.Natv.mapper.OrderMapper;
import com.example.Natv.model.DTO.*;
import com.example.Natv.model.entity.Channel;
import com.example.Natv.model.entity.Order;
import com.example.Natv.model.enums.Status;
import com.example.Natv.model.request.OrderCreateRequest;
import com.example.Natv.model.request.ChannelOrderRequest;
import com.example.Natv.model.response.ChannelResponse;
import com.example.Natv.model.response.OrderResponse;
import com.example.Natv.service.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order, OrderRepository, OrderDTO, OrderMapper> implements OrderService {
    public OrderServiceImpl(OrderRepository rep, OrderMapper mapper, ChannelService channelService, OrderBookService orderBookService, DiscountService discountService) {
        super(rep, mapper);
        this.channelService = channelService;
        this.orderBookService = orderBookService;
        this.discountService = discountService;
    }

    private final ChannelService channelService;
    private final OrderBookService orderBookService;
    private final DiscountService discountService;

    @Override
    public OrderResponse create(OrderCreateRequest request) {

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
        Integer priceWithoutDisc = 0;
        List<OrderBookDTO> orderBookDTOS = new ArrayList<>();
        List<ChannelResponse> channelResponses = new ArrayList<>();

        for(ChannelOrderRequest item: request.getChannels()) {

            channelDTO = channelService.findById(item.getId());
            List<LocalDate> bookingDates = new ArrayList<>();

            for (LocalDate book : item.getDays()) {
                bookingDates.add(book);
            }

            DiscountDTO discountDTO = discountService.findByChannelIdAndCountOfDays(item.getId(), bookingDates.size());
            int price = channelDTO.getPrice()*order.getText().replaceAll("\\s", "").length()*bookingDates.size();
            int onePercent = price/100;

            OrderBookDTO orderBookDTO = new OrderBookDTO();
            orderBookDTO.setOrder(order);
            orderBookDTO.setBookDate(bookingDates);
            orderBookDTO.setChannel(channelDTO);
            orderBookDTO.setPrice(price-(onePercent*discountDTO.getPercent()));

            for(ChannelResponse i: channelResponses) {
                ChannelResponse channelResponse = new ChannelResponse();
                channelResponse.setName(channelDTO.getName());
                channelResponse.setPrice(BigDecimal.valueOf(price));
                channelResponse.setPriceWithDisc(BigDecimal.valueOf(orderBookDTO.getPrice()));

                channelResponses.add(channelResponse);
            }

            totalPrice +=orderBookDTO.getPrice();
            priceWithoutDisc +=price;
            orderBookDTOS.add(orderBookDTO);
        }

        order.setTotalPrice(totalPrice);

        save(order);
        orderBookService.saveAll(orderBookDTOS);


        OrderResponse orderResponse = OrderResponse.builder()
                .totalPrice(BigDecimal.valueOf(priceWithoutDisc))
                .totalPriceWithDisc(BigDecimal.valueOf(totalPrice))
                .channels(channelResponses)
                .build();


        return orderResponse;

    }
}
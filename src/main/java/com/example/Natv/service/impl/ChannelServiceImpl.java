package com.example.Natv.service.impl;

import com.example.Natv.base.BaseServiceImpl;
import com.example.Natv.dao.ChannelRepository;
import com.example.Natv.mapper.ChannelMapper;
import com.example.Natv.mapper.DiscountMapper;
import com.example.Natv.mapper.OrderMapper;
import com.example.Natv.model.DTO.ChannelDTO;
import com.example.Natv.model.entity.Channel;
import com.example.Natv.model.entity.Discount;
import com.example.Natv.model.entity.Order;
import com.example.Natv.model.enums.Status;
import com.example.Natv.model.request.ChannelCreateRequest;
import com.example.Natv.model.response.MainChannelPageResponse;
import com.example.Natv.service.ChannelService;
import com.example.Natv.service.DiscountService;
import com.example.Natv.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChannelServiceImpl extends BaseServiceImpl<Channel, ChannelRepository, ChannelDTO, ChannelMapper> implements ChannelService {
    public ChannelServiceImpl(ChannelRepository rep, ChannelMapper mapper, DiscountService discountService, DiscountMapper discountMapper, OrderService orderService, OrderMapper orderMapper){
        super(rep, mapper);
        this.discountService = discountService;
        this.discountMapper = discountMapper;
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    private final DiscountService discountService;
    private final DiscountMapper discountMapper;
    private final OrderService orderService;
    private final OrderMapper orderMapper;


    @Override
    public void create(ChannelCreateRequest request) {

        List<Discount> discountList = new ArrayList<>();
        List<Order> orderList = new ArrayList<>();


        for(Long id: request.getDiscountsId()) {
            Discount discount = new Discount();
            discount = discountMapper.toEntity(discountService.findById(id), context);
            discountList.add(discount);
        }

        for(Long id: request.getOrdersId()) {
            Order order = new Order();
            order = orderMapper.toEntity(orderService.findById(id), context);
            orderList.add(order);
        }


        Channel channel = Channel.builder()
                .discounts(discountList)
                .price(request.getPrice())
                .name(request.getName())
                .orders(orderList)
                .rating(request.getRating())
                .status(Status.ACTIVE)
                .build();

        save(mapper.toDto(channel, context));
    }

    @Override
    public MainChannelPageResponse mainPage() {
        return (MainChannelPageResponse) rep.getMainPage();
    }
}

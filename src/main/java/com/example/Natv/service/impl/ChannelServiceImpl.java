package com.example.Natv.service.impl;

import com.example.Natv.base.BaseServiceImpl;
import com.example.Natv.dao.ChannelRepository;
import com.example.Natv.dao.UserRepository;
import com.example.Natv.mapper.ChannelMapper;
import com.example.Natv.mapper.UserMapper;
import com.example.Natv.model.DTO.ChannelDTO;
import com.example.Natv.model.DTO.UserDTO;
import com.example.Natv.model.entity.Channel;
import com.example.Natv.model.entity.User;
import com.example.Natv.model.enums.Status;
import com.example.Natv.model.request.ChannelCreateRequest;
import com.example.Natv.model.response.MainChannelPageResponse;
import com.example.Natv.service.ChannelService;
import com.example.Natv.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class ChannelServiceImpl extends BaseServiceImpl<Channel, ChannelRepository, ChannelDTO, ChannelMapper> implements ChannelService {
    public ChannelServiceImpl(ChannelRepository rep, ChannelMapper mapper) {
        super(rep, mapper);
    }

    @Override
    public void create(ChannelCreateRequest request) {
        Channel channel = Channel.builder()
                .discounts(mapper.toEntities(request.getDiscounts(), context))
                .price(request.getPrice())
                .name(request.getName())
                .orders(mapper.toEntities(request.getOrders(), context))
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

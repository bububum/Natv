package com.example.Natv.service.impl;

import com.example.Natv.base.BaseServiceImpl;
import com.example.Natv.dao.DiscountRepository;
import com.example.Natv.mapper.ChannelMapper;
import com.example.Natv.mapper.DiscountMapper;
import com.example.Natv.model.DTO.DiscountDTO;
import com.example.Natv.model.entity.Channel;
import com.example.Natv.model.entity.Discount;
import com.example.Natv.model.request.DiscountCreateRequest;
import com.example.Natv.service.ChannelService;
import com.example.Natv.service.DiscountService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscountServiceImpl extends BaseServiceImpl<Discount, DiscountRepository, DiscountDTO, DiscountMapper> implements DiscountService {

    public DiscountServiceImpl(DiscountRepository rep, DiscountMapper mapper, ChannelService channelService, ChannelMapper channelMapper) {
        super(rep, mapper);
        this.channelService = channelService;
        this.channelMapper = channelMapper;
    }

    private final ChannelService channelService;
    private final ChannelMapper channelMapper;

    @Override
    public void create(DiscountCreateRequest request) {

        List<Channel> channelList = new ArrayList<>();

        for (Long id: request.getChannelsId()) {
            Channel channel = new Channel();
            channel = channelMapper.toEntity(channelService.findById(id), context);
            channelList.add(channel);
        }

        Discount discount = Discount.builder()
                .channels(channelList)
                .days(request.getDays())
                .definition(request.getDefinition())
                .endDate(request.getEndDate())
                .startDate(request.getStartDate())
                .percent(request.getPercent())
                .build();

        save(mapper.toDto(discount, context));
    }
}

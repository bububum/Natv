package com.example.Natv.service.impl;

import com.example.Natv.base.BaseServiceImpl;
import com.example.Natv.dao.ChannelDiscountRepository;
import com.example.Natv.mapper.ChannelDiscountMapper;
import com.example.Natv.model.DTO.ChannelDTO;
import com.example.Natv.model.DTO.ChannelDiscountDTO;
import com.example.Natv.model.DTO.DiscountDTO;
import com.example.Natv.model.entity.ChannelDiscount;
import com.example.Natv.model.response.Response;
import com.example.Natv.service.ChannelDiscountService;
import com.example.Natv.service.ChannelService;
import com.example.Natv.service.DiscountService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChannelDiscountServiceImpl extends BaseServiceImpl<ChannelDiscount,
        ChannelDiscountRepository, ChannelDiscountDTO, ChannelDiscountMapper> implements ChannelDiscountService {

    public ChannelDiscountServiceImpl(ChannelDiscountRepository rep, ChannelDiscountMapper mapper, DiscountService discountService, ChannelService channelService) {
        super(rep, mapper);
        this.discountService = discountService;
        this.channelService = channelService;
    }

    private final DiscountService discountService;
    private final ChannelService channelService;

    @Override
    public void saveList(List<ChannelDiscountDTO> discountDtoList) {
        rep.saveAll(mapper.toEntities(discountDtoList, context));
    }

    @Override
    public Response create(List<Long> discountId, Long channelId) {

        List<ChannelDiscountDTO> result = new ArrayList<>();

        List<DiscountDTO> discountDTOS = discountService.findAllByIds(discountId);
        for (DiscountDTO item: discountDTOS) {
            ChannelDiscountDTO DTO = new ChannelDiscountDTO();
            DTO.setDiscount(item);
            DTO.setChannel(channelService.findById(channelId));
            result.add(DTO);
            update(DTO);
        }

//        saveList(result);
        return Response.builder()
                .message("Success")
                .build();
    }

}

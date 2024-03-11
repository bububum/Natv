package com.example.Natv.service;

import com.example.Natv.base.BaseService;
import com.example.Natv.model.DTO.ChannelDiscountDTO;
import com.example.Natv.model.DTO.DiscountDTO;
import com.example.Natv.model.response.Response;

import java.util.List;

public interface ChannelDiscountService extends BaseService<ChannelDiscountDTO> {

    void saveList(List<ChannelDiscountDTO> discountDtoList);
    Response create(List<Long> discountId, Long channelId);

}


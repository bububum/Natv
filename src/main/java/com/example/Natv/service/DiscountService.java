package com.example.Natv.service;

import com.example.Natv.base.BaseService;
import com.example.Natv.model.DTO.DiscountDTO;
import com.example.Natv.model.request.DiscountCreateRequest;
import com.example.Natv.model.response.DiscountResponse;

import java.util.List;

public interface DiscountService extends BaseService<DiscountDTO> {

    String create(DiscountCreateRequest request);
    List<DiscountDTO> findAllByIds(List<Long> ids);

    List<DiscountResponse> getAllActiveDiscount();

    List<DiscountResponse> getAllDiscByChannelId(Long id);

    DiscountDTO findByChannelIdAndCountOfDays(Long id, int size);
}


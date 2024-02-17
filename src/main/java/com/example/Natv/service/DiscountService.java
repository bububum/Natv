package com.example.Natv.service;

import com.example.Natv.base.BaseService;
import com.example.Natv.model.DTO.DiscountDTO;
import com.example.Natv.model.DTO.UserDTO;
import com.example.Natv.model.request.DiscountCreateRequest;

public interface DiscountService extends BaseService<DiscountDTO> {

    void create(DiscountCreateRequest request);
}

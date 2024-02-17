package com.example.Natv.service.impl;

import com.example.Natv.base.BaseServiceImpl;
import com.example.Natv.dao.DiscountRepository;
import com.example.Natv.dao.UserRepository;
import com.example.Natv.mapper.DiscountMapper;
import com.example.Natv.mapper.UserMapper;
import com.example.Natv.model.DTO.DiscountDTO;
import com.example.Natv.model.DTO.UserDTO;
import com.example.Natv.model.entity.Discount;
import com.example.Natv.model.entity.User;
import com.example.Natv.model.request.DiscountCreateRequest;
import com.example.Natv.service.DiscountService;
import com.example.Natv.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class DiscountServiceImpl extends BaseServiceImpl<Discount, DiscountRepository, DiscountDTO, DiscountMapper> implements DiscountService {

    public DiscountServiceImpl(DiscountRepository rep, DiscountMapper mapper) {
        super(rep, mapper);
    }

    @Override
    public void create(DiscountCreateRequest request) {
        Discount discount = Discount.builder()
                .channels(mapper.toEntities(request.getChannels(), context))
                .days(request.getDays())
                .definition(request.getDefinition())
                .endDate(request.getEndDate())
                .startDate(request.getStartDate())
                .percent(request.getPercent())
                .build();

        save(mapper.toDto(discount, context));
    }
}

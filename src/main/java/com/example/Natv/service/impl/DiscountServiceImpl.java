package com.example.Natv.service.impl;

import com.example.Natv.base.BaseServiceImpl;
import com.example.Natv.dao.DiscountRepository;
import com.example.Natv.mapper.DiscountMapper;
import com.example.Natv.model.DTO.DiscountDTO;
import com.example.Natv.model.entity.Discount;
import com.example.Natv.model.request.DiscountCreateRequest;
import com.example.Natv.model.response.DiscountResponse;
import com.example.Natv.service.DiscountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl extends BaseServiceImpl<Discount, DiscountRepository, DiscountDTO, DiscountMapper> implements DiscountService {

    public DiscountServiceImpl(DiscountRepository rep, DiscountMapper mapper) {
        super(rep, mapper);
    }



    @Override
    public String create(DiscountCreateRequest request) {
        DiscountDTO discount = new DiscountDTO();
        discount.setDays(request.getDays());
        discount.setDefinition(request.getDefinition());
        discount.setEndDate(request.getEndDate());
        discount.setStartDate(request.getStartDate());
        discount.setPercent(request.getPercent());

        save(discount);

        return "Success";
    }

    @Override
    public List<DiscountDTO> findAllByIds(List<Long> ids) {

        return mapper.toDtos(rep.findAllByIds(ids),context);
    }

    @Override
    public List<DiscountResponse> getAllActiveDiscount() {
        return rep.getAllActiveDiscount();
    }

    @Override
    public List<DiscountResponse> getAllDiscByChannelId(Long id) {
        return rep.getAllDiscByChannelId(id);
    }
}

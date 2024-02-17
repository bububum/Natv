package com.example.Natv.mapper;

import com.example.Natv.base.BaseMapper;
import com.example.Natv.model.DTO.DiscountDTO;
import com.example.Natv.model.entity.Discount;
import org.mapstruct.Mapper;

@Mapper
public interface DiscountMapper extends BaseMapper<Discount, DiscountDTO> {
}

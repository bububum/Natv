package com.example.Natv.mapper;

import com.example.Natv.base.BaseMapper;
import com.example.Natv.model.DTO.ChannelDiscountDTO;
import com.example.Natv.model.entity.ChannelDiscount;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR,componentModel = "spring")

public interface ChannelDiscountMapper extends BaseMapper<ChannelDiscount, ChannelDiscountDTO> {
}

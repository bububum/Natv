package com.example.Natv.mapper;

import com.example.Natv.base.BaseMapper;
import com.example.Natv.model.DTO.ChannelDTO;
import com.example.Natv.model.DTO.DiscountDTO;
import com.example.Natv.model.entity.Channel;
import com.example.Natv.model.entity.Discount;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR,componentModel = "spring")
public interface ChannelMapper extends BaseMapper<Channel, ChannelDTO> {
}

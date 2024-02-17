package com.example.Natv.mapper;

import com.example.Natv.base.BaseMapper;
import com.example.Natv.model.DTO.DiscountDTO;
import com.example.Natv.model.DTO.OrderDTO;
import com.example.Natv.model.entity.Discount;
import com.example.Natv.model.entity.Order;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order, OrderDTO> {
}

package com.example.Natv.mapper;

import com.example.Natv.base.BaseMapper;
import com.example.Natv.model.DTO.DiscountDTO;
import com.example.Natv.model.DTO.OrderBookDTO;
import com.example.Natv.model.entity.Discount;
import com.example.Natv.model.entity.OrderBook;
import org.mapstruct.Mapper;

@Mapper
public interface OrderBookMapper extends BaseMapper<OrderBook, OrderBookDTO> {
}

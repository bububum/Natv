package com.example.Natv.mapper;

import com.example.Natv.base.BaseMapper;
import com.example.Natv.model.DTO.DiscountDTO;
import com.example.Natv.model.DTO.UserDTO;
import com.example.Natv.model.entity.Discount;
import com.example.Natv.model.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR,componentModel = "spring")

public interface UserMapper extends BaseMapper<User, UserDTO> {
}

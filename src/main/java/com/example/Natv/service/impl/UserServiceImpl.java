package com.example.Natv.service.impl;

import com.example.Natv.base.BaseService;
import com.example.Natv.base.BaseServiceImpl;
import com.example.Natv.dao.UserRepository;
import com.example.Natv.mapper.UserMapper;
import com.example.Natv.model.DTO.UserDTO;
import com.example.Natv.model.entity.User;
import com.example.Natv.model.request.UserCreateRequest;
import com.example.Natv.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserRepository, UserDTO, UserMapper> implements UserService {
    public UserServiceImpl(UserRepository rep, UserMapper mapper) {
        super(rep, mapper);
    }

    @Override
    public void create(UserCreateRequest request) {
//        User user = User.builder()
//                .name(request.getName())
//                .email(request.getEmail())
//                .lastname(request.getLastname())
//                .middleName(request.getMiddleName())
//                .phone_num(request.getPhone_num())
//                .build();
//        save(mapper.toDto(user, context));
    }
}

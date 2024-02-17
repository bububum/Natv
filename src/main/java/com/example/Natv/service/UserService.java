package com.example.Natv.service;

import com.example.Natv.base.BaseService;
import com.example.Natv.model.DTO.UserDTO;
import com.example.Natv.model.request.UserCreateRequest;

public interface UserService extends BaseService<UserDTO> {

    void create(UserCreateRequest request);
}

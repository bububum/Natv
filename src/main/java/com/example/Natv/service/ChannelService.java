package com.example.Natv.service;

import com.example.Natv.base.BaseService;
import com.example.Natv.model.DTO.ChannelDTO;
import com.example.Natv.model.DTO.UserDTO;
import com.example.Natv.model.request.ChannelCreateRequest;
import com.example.Natv.model.response.MainChannelPageResponse;

public interface ChannelService extends BaseService<ChannelDTO> {

    void create (ChannelCreateRequest request);
    MainChannelPageResponse mainPage();
}

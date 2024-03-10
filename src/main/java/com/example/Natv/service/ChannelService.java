package com.example.Natv.service;

import com.example.Natv.base.BaseService;
import com.example.Natv.model.DTO.ChannelDTO;
import com.example.Natv.model.request.ChannelCreateRequest;
import com.example.Natv.model.response.MainChannelPageResponse;

import java.util.List;

public interface ChannelService extends BaseService<ChannelDTO> {

    String create (ChannelCreateRequest request);
    MainChannelPageResponse mainPage();

    List<MainChannelPageResponse> getList(Integer pageNum, Integer limit);
}

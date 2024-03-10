package com.example.Natv.service.impl;

import com.example.Natv.base.BaseServiceImpl;
import com.example.Natv.dao.ChannelRepository;
import com.example.Natv.mapper.ChannelMapper;
import com.example.Natv.microservices.FileService;
import com.example.Natv.model.DTO.ChannelDTO;
import com.example.Natv.model.entity.Channel;
import com.example.Natv.model.request.ChannelCreateRequest;
import com.example.Natv.model.response.ChannelListResponse;
import com.example.Natv.model.response.DiscountResponse;
import com.example.Natv.model.response.FileServiceUploadResponse;
import com.example.Natv.model.response.MainChannelPageResponse;
import com.example.Natv.service.ChannelService;
import com.example.Natv.service.DiscountService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChannelServiceImpl extends BaseServiceImpl<Channel, ChannelRepository, ChannelDTO, ChannelMapper> implements ChannelService {
    public ChannelServiceImpl(ChannelRepository rep,
                              ChannelMapper mapper,
                              FileService fileService, DiscountService discountService){
        super(rep, mapper);


        this.fileService = fileService;
        this.discountService = discountService;
    }

    private final FileService fileService;
    private final DiscountService discountService;




    @Override
    public String create(ChannelCreateRequest request) {


        FileServiceUploadResponse response=fileService.upload(request.getLogo());


        ChannelDTO channel = new ChannelDTO();
        channel.setPrice(request.getPrice());
        channel.setLogo(response.getDownloadUri());
        channel.setName(request.getName());
        channel.setRating(request.getRating());

        save(channel);


        return "Успешно";
    }

    @Override
    public MainChannelPageResponse mainPage() {
        return (MainChannelPageResponse) rep.getMainPage();
    }

    @Override
    public List<MainChannelPageResponse> getList(Integer pageNum, Integer limit) {

        List<ChannelListResponse> response=rep.getList(PageRequest.of(pageNum,limit));

        List<MainChannelPageResponse> result=new ArrayList<>();

        for (ChannelListResponse item:response){
            MainChannelPageResponse mainChannelPageResponse=new MainChannelPageResponse();
            mainChannelPageResponse.setChannelId(item.getId());
            mainChannelPageResponse.setChannelName(item.getName());
            mainChannelPageResponse.setPrice(item.getPrice());

            List<DiscountResponse> discountDTOS=discountService.getAllDiscByChannelId(item.getId());

            mainChannelPageResponse.setDiscounts(discountDTOS);

            result.add(mainChannelPageResponse);
        }

        return result;
    }
}


package com.example.Natv.dao;

import com.example.Natv.model.DTO.ChannelDTO;
import com.example.Natv.model.DTO.DiscountDTO;
import com.example.Natv.model.response.MainChannelPageResponse;
import jakarta.transaction.Transactional;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = SpringBootApplication.class)
public class ChannelRepositoryTest {

    @Mock
    private ChannelRepository repository;

//    @Test
//    void MainPageTest() {
//
//        List<ChannelDTO> channelDTOS = new ArrayList<>();
//
//        DiscountDTO discountDTO = DiscountDTO.builder()
//                .days(1)
//                .endDate(LocalDate.now())
//                .startDate(LocalDate.now())
//                .percent(10)
//                .channels(channelDTOS)
//                .build();
//
//        List<DiscountDTO> discountDTOS = new ArrayList<>();
//        discountDTOS.add(discountDTO);
//
//        MainChannelPageResponse mainPage = new MainChannelPageResponse();
//        mainPage.setChannelId(1L);
//        mainPage.setChannelName("name");
//        mainPage.setDiscounts(discountDTOS);
//
//        List<MainChannelPageResponse> mainChannelPageResponseList = new ArrayList<>();
//        mainChannelPageResponseList.add(mainPage);
//
//        when(repository.getMainPage()).thenReturn(mainChannelPageResponseList);
//
//        List<MainChannelPageResponse> result = repository.getMainPage();
//
//        assertEquals(mainChannelPageResponseList.size(),result.size());
//        for (MainChannelPageResponse expectedResponse : mainChannelPageResponseList) {
//            assertThat(result, Matchers.contains(expectedResponse));
//        }
//
//
//
//
//    }

}

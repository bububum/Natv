package com.example.Natv.controller;

import com.example.Natv.model.response.Response;
import com.example.Natv.service.ChannelDiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/channel_discount")
public class ChannelDiscountController {

    private final ChannelDiscountService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestParam List<Long> discountId,
                                    @RequestParam Long channelId) {
        return ResponseEntity.ok(service.create(discountId, channelId));
    }
}

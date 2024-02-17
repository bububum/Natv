package com.example.Natv.controller;

import com.example.Natv.service.ChannelService;
import com.example.Natv.service.impl.ChannelServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChannelController {

    private final ChannelService service;

    @GetMapping("/getMainPage")
    public ResponseEntity<?> getMainPage() {
        return ResponseEntity.ok(service.mainPage());
    }
}

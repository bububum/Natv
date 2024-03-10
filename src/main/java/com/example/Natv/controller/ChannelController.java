package com.example.Natv.controller;

import com.example.Natv.model.request.ChannelCreateRequest;
import com.example.Natv.service.ChannelService;
import com.example.Natv.service.impl.ChannelServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/channel")
public class ChannelController {

    private final ChannelService service;

    @GetMapping("/getMainPage")
    public ResponseEntity<?> getMainPage() {
        return ResponseEntity.ok(service.mainPage());
    }

    @PostMapping
    public ResponseEntity<?> create(@ModelAttribute ChannelCreateRequest request){
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getList(@RequestParam Integer pageNum,
                                     @RequestParam Integer limit){
        return ResponseEntity.ok(service.getList(pageNum,limit));
    }

}

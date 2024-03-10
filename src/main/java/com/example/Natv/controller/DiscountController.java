package com.example.Natv.controller;

import com.example.Natv.model.request.DiscountCreateRequest;
import com.example.Natv.service.DiscountService;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/discounts")
public class DiscountController {

    private final DiscountService service;

    public DiscountController(DiscountService service) {
        this.service = service;
    }


    @PostMapping
    ResponseEntity create(@RequestBody DiscountCreateRequest request){
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/list")
    ResponseEntity getList(){
        return ResponseEntity.ok(service.getAllActiveDiscount());
    }



}

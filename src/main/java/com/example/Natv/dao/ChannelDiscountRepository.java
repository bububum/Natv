package com.example.Natv.dao;

import com.example.Natv.base.BaseRep;
import com.example.Natv.model.DTO.DiscountDTO;
import com.example.Natv.model.entity.ChannelDiscount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelDiscountRepository extends BaseRep<ChannelDiscount> {
}


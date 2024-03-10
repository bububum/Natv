package com.example.Natv.dao;

import com.example.Natv.base.BaseRep;
import com.example.Natv.model.entity.Channel;
import com.example.Natv.model.response.ChannelListResponse;
import com.example.Natv.model.response.MainChannelPageResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepository extends BaseRep<Channel> {

    @Query(value = "SELECT c.id AS channelId, c.name AS channelName, c.price " +
            "FROM tb_channel c " +
            "LEFT JOIN discount_channel dc ON c.id = dc.channel_id " +
            "LEFT JOIN tb_discount d ON dc.discount_id = d.id " +
            "ORDER BY c.rating DESC " +
            "LIMIT 10 OFFSET 0", nativeQuery = true)
    List<MainChannelPageResponse> getMainPage();


    @Query("""
            select c.id as id,c.name as name ,c.price as price from Channel c 
            """)
    List<ChannelListResponse> getList(Pageable pageable);
}

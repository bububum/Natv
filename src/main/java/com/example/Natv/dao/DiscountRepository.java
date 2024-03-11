package com.example.Natv.dao;

import com.example.Natv.base.BaseRep;
import com.example.Natv.model.DTO.DiscountDTO;
import com.example.Natv.model.entity.Channel;
import com.example.Natv.model.entity.Discount;
import com.example.Natv.model.response.DiscountResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountRepository extends BaseRep<Discount> {
    @Query(value = """
            select d.* from tb_discount d where d.id in (:ids)
            """, nativeQuery = true)
    List<Discount> findAllByIds(List<Long> ids);

    @Query(value = """
select d.id, d.definition as def, d.percent from tb_discount d where d.status="ACTIVE"
""",nativeQuery = true)
    List<DiscountResponse> getAllActiveDiscount();


    @Query(value = """

            select d.id, d.definition as def, d.percent
         from tb_discount d
         inner join tb_discount_channel dc on d.id = dc.discount_id
         where d.status='ACTIVE' and dc.channel_id = :id
            """, nativeQuery = true)
    List<DiscountResponse> getAllDiscByChannelId(Long id);

    @Query(value = "SELECT * FROM tb_discount d JOIN discount_channel dc ON d.id = dc.discount_id WHERE dc.channel_id = :id AND d.days >= :size",
    nativeQuery = true)
    DiscountDTO findByChannelIdAndCountOfDays(Long id, int size);
}
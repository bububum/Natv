package com.example.Natv.model.entity;

import com.example.Natv.base.BaseEntity;
import com.example.Natv.model.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Builder
@Table(name = "tb_channel")
public class Channel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String name;
    Integer price;
    Integer rating;
    Status status;


    @ManyToMany(mappedBy = "channels")
    List<Order> orders;

    @ManyToMany(mappedBy = "channels")
    List<Discount> discounts;
}

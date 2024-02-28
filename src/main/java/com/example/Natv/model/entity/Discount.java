package com.example.Natv.model.entity;

import com.example.Natv.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Builder
@Table(name = "tb_discount")
public class Discount extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    Integer percent;
    Integer days;
    String definition;
    LocalDate startDate;
    LocalDate endDate;

    @ManyToMany
    @JoinTable(
            name = "discount_channel",
            joinColumns = @JoinColumn(name = "discount_id"),
            inverseJoinColumns = @JoinColumn(name = "channel_id")
    )
    List<Channel> channels;
}

package com.example.Natv.base;


import com.example.Natv.model.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    protected LocalDateTime createdDate;
    protected LocalDateTime updatedDate;
    @Enumerated(EnumType.STRING)
    protected Status status;

    @PrePersist
    protected void onCreate(){
        createdDate = LocalDateTime.now();
        updatedDate = LocalDateTime.now();
        status = Status.ACTIVE;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }
}

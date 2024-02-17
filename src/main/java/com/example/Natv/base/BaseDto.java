package com.example.Natv.base;

import com.example.Natv.model.enums.Status;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
@MappedSuperclass
@Setter
@Getter
public abstract class BaseDto {
    protected Long id;
    protected LocalDateTime createdDate;
    protected LocalDateTime updatedDate;
    protected Status status;
}

package com.example.Natv.base;

import com.example.Natv.model.enums.Status;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
@MappedSuperclass
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseDto {
    protected Long id;
    protected LocalDateTime createdDate;
    protected LocalDateTime updatedDate;
    protected Status status;

    public BaseDto(Long id) {
        this.id = id;
    }
}

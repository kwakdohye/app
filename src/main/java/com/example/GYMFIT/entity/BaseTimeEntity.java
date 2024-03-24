package com.example.GYMFIT.entity;

import jakarta.persistence.Column;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

public class BaseTimeEntity {
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regTime;
}

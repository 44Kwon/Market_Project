package com.gamemarket.item.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gamemarket.item.entity.Item;
import lombok.Builder;

import java.time.LocalDateTime;

//아이템 상세조회
public class ItemResponseDto {
    private Long id;
    private String name;
    private String description;
    private Item.Rarity rarity;
    private Boolean tradeable;
    private Integer basePrice;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    //등록시간
    private LocalDateTime createdAt;

    @Builder
    private ItemResponseDto(Long id, String name, String description, Item.Rarity rarity, Boolean tradeable, Integer basePrice, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rarity = rarity;
        this.tradeable = tradeable;
        this.basePrice = basePrice;
        this.createdAt = createdAt;
    }
}

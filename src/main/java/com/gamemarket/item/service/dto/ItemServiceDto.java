package com.gamemarket.item.service.dto;

import com.gamemarket.item.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class ItemServiceDto {
    @Getter
    @AllArgsConstructor
    public static class Create {
        private String name;
        private String description;
        private Item.Rarity rarity;
        private Boolean tradeable;
        private Integer basePrice;
//        private String imageUrl;
    }

    @Getter
    @AllArgsConstructor
    public static class Update {
        private String name;
        private String description;
        private Item.Rarity rarity;
        private Boolean tradeable;
        private Integer basePrice;
    }
}

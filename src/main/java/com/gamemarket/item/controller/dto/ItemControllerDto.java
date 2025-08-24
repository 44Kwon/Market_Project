package com.gamemarket.item.controller.dto;

import com.gamemarket.item.entity.Item;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class ItemControllerDto {

    @Getter
    @AllArgsConstructor
    public static class Create {
        @NotBlank(message = "아이템 이름을 입력해주세요.")
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

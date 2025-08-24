package com.gamemarket.item.entity;

import com.gamemarket.audit.BaseEntity;
import com.gamemarket.game.entity.Game;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Table(name = "items")
public class Item extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
    @SequenceGenerator(name = "item_seq", sequenceName = "item_seq", allocationSize = 50)
    @Column(name = "item_id")
    private Long id;

    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private Rarity rarity;

    private boolean tradable; // 아이템 거래 가능 여부
    private Integer basePrice; // 아이템 기본 가격 // null 가능(무료아이템)
//    private String imageUrl; // 아이템 이미지 URL

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private Game game;


    public enum Rarity {
        COMMON, RARE, EPIC, LEGENDARY
    }

    @Builder
    private Item(String name, String description, Rarity rarity, Boolean tradable, Integer basePrice, Game game) {
        this.name = name;
        this.description = description;
        this.rarity = rarity == null ? Rarity.COMMON : rarity;
        // tradable이 null이거나 true면 true, false면 false
        this.tradable = tradable == null || tradable;
        this.basePrice = basePrice;
        this.game = game;
    }
}

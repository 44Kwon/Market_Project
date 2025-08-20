package com.gamemarket.salePost.entity;


import com.gamemarket.audit.BaseEntity;
import com.gamemarket.item.entity.Item;
import com.gamemarket.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SalePost extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "sale_post_id")
    private Long id;

    private int quantity;
    private int price;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User seller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public enum Status {
        ON_SALE, SOLD, CANCELED
    }

    @Builder
    private SalePost(int quantity, int price, Status status, User seller, Item item) {
        this.quantity = quantity;
        this.price = price;
        this.status = status == null ? Status.ON_SALE : status;
        this.seller = seller;
        this.item = item;
    }
}

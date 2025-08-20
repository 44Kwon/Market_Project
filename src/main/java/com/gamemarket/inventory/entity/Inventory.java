package com.gamemarket.inventory.entity;

import com.gamemarket.audit.BaseEntity;
import com.gamemarket.item.entity.Item;
import com.gamemarket.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
// user_id, item_id가 이미 존재하는 경우에는 update로 수량 증가 등 처리 필요
@Table(name = "inventories",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "item_id"}))
public class Inventory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory_seq")
    @SequenceGenerator(name = "inventory_seq", sequenceName = "inventory_seq", allocationSize = 50)
    @Column(name = "inventory_id")
    private Long id;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Builder
    private Inventory(int quantity, User user, Item item) {
        this.quantity = quantity;
        this.user = user;
        this.item = item;
    }
}

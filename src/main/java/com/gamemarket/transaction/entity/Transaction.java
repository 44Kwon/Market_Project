package com.gamemarket.transaction.entity;

import com.gamemarket.item.entity.Item;
import com.gamemarket.salepost.entity.SalePost;
import com.gamemarket.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "transaction_id")
    private Long id;

    private int quantity;
    private int price;

    @CreationTimestamp
    private LocalDateTime transactionAt;

    @ManyToOne
    @JoinColumn(name = "sale_post_id")
    private SalePost salePost;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Builder
    private Transaction(int quantity, int price, LocalDateTime transactionAt, SalePost salePost, User buyer, User seller, Item item) {
        this.quantity = quantity;
        this.price = price;
        this.transactionAt = transactionAt;
        this.salePost = salePost;
        this.buyer = buyer;
        this.seller = seller;
        this.item = item;
    }
}

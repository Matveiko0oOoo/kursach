package com.example.buysell.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Уникальный идентификатор для элемента корзины

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product; // Продукт в корзине

    @Column(name = "quantity", nullable = false)
    private int quantity; // Количество продукта в корзине

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Пользователь, которому принадлежит товар в корзине

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery; // Связь с доставкой (или заказом)

    // Конструктор для создания CartItem с продуктом, количеством и пользователем
    public CartItem(Product product, int quantity, User user) {
        this.product = product;
        this.quantity = quantity;
        this.user = user;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", product=" + (product != null ? product.getTitle() : "null") +
                ", quantity=" + quantity +
                '}';
    }
}


package com.caseStudy.eCart.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class cart implements Serializable
{
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
@ManyToOne
    private Products products;
@ManyToOne
    private users user;
@Column(name="quantity")
    private int quantity;
public cart()
{

}

    public cart(Products products, users user, int quantity) {
        this.products = products;
        this.user = user;
        this.quantity = quantity;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public users getUser() {
        return user;
    }

    public void setUser(users user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

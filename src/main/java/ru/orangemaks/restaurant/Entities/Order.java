package ru.orangemaks.restaurant.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String address;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "order")
    private List<OrderProducts> orderProducts;

    public Order(String date, String address, User user, List<OrderProducts> orderProducts) {
        this.date = date;
        this.address = address;
        this.user = user;
        this.orderProducts = orderProducts;
    }

    public Order() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderProducts> getProducts() {
        return orderProducts;
    }

    public void setProducts(List<OrderProducts> orderProducts) {
        this.orderProducts = orderProducts;
    }
}

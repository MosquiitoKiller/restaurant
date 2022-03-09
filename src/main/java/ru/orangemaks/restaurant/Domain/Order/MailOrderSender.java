package ru.orangemaks.restaurant.Domain.Order;

public interface MailOrderSender {
    void sendOrderInfo(String mail, String message);
}

package ru.orangemaks.restaurant.domain.order;

import ru.orangemaks.restaurant.entities.Order;
import ru.orangemaks.restaurant.entities.OrderProducts;
import ru.orangemaks.restaurant.entities.Product;
import ru.orangemaks.restaurant.entities.User;
import ru.orangemaks.restaurant.models.ProductCategories;
import ru.orangemaks.restaurant.models.ProductDtoModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderInteractor implements OrderInputBoundary{

    private final OrderOutputBoundary orderOutputBoundary;
    private final OrderDataAccess orderDataAccess;
    private final MenuDataAccess menuDataAccess;
    private final OrderUserDataAccess orderUserDataAccess;
    private final OrderProductDataAccess orderProductDataAccess;

    public OrderInteractor(OrderOutputBoundary orderOutputBoundary,
                           OrderDataAccess orderDataAccess,
                           MenuDataAccess menuDataAccess,
                           OrderUserDataAccess orderUserDataAccess,
                           OrderProductDataAccess orderProductDataAccess) {
        this.orderOutputBoundary = orderOutputBoundary;
        this.orderDataAccess = orderDataAccess;
        this.menuDataAccess = menuDataAccess;
        this.orderUserDataAccess = orderUserDataAccess;
        this.orderProductDataAccess = orderProductDataAccess;
    }

    @Override
    public MenuResponseModel getAll() {
        List<Product> products = menuDataAccess.getAll();
        return orderOutputBoundary.prepareAllProductView(ProductDtoModel.listProductMapper(products), ProductCategories.values());
    }

    @Override
    public BasketResponseModel getProductsById(BasketRequestModel basketRequestModel) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < basketRequestModel.productsId.size(); i++) {
            products.add(menuDataAccess.findById(basketRequestModel.productsId.get(i)));
        }
        return orderOutputBoundary.prepareBasket(ProductDtoModel.listProductMapper(products));
    }

    @Override
    public boolean formOrder(OrderRequestModel orderRequestModel) {

        User currentUser = orderUserDataAccess.getCurrentUser();
        if (orderRequestModel.basket.isEmpty()||orderRequestModel.address.equals("")||currentUser==null)
            return orderOutputBoundary.prepareFailedFormOrder();

        Order order = new Order(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")),
                orderRequestModel.address,
                currentUser,
                null);
        orderDataAccess.save(order);
        List<OrderProducts> orderProducts = new ArrayList<>();
        for (Long key : orderRequestModel.basket.keySet()) {
            OrderProducts o = new OrderProducts(order,menuDataAccess.findById(key),orderRequestModel.basket.get(key));
            orderProductDataAccess.save(o);
            orderProducts.add(o);
        }
        order.setProducts(orderProducts);
        orderDataAccess.save(order);
        return orderOutputBoundary.prepareSuccessFormOrder();
    }
}

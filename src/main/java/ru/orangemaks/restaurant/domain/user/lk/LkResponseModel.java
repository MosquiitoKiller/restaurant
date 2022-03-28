package ru.orangemaks.restaurant.domain.user.lk;

import ru.orangemaks.restaurant.models.OrderDtoModel;
import ru.orangemaks.restaurant.models.UserDtoModel;

import java.util.List;

public class LkResponseModel {
    UserDtoModel user;
    List<OrderDtoModel> ordersList;

    public LkResponseModel(UserDtoModel user, List<OrderDtoModel> ordersList) {
        this.user = user;
        this.ordersList = ordersList;
    }

    public UserDtoModel getUser() {
        return user;
    }

    public void setUser(UserDtoModel userDtoModel) {
        this.user = userDtoModel;
    }

    public List<OrderDtoModel> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<OrderDtoModel> ordersList) {
        this.ordersList = ordersList;
    }
}

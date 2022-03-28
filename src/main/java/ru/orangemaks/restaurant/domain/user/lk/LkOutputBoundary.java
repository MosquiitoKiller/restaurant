package ru.orangemaks.restaurant.domain.user.lk;

import ru.orangemaks.restaurant.models.OrderDtoModel;
import ru.orangemaks.restaurant.models.OrderProductsDtoModel;
import ru.orangemaks.restaurant.models.UserDtoModel;

import java.util.List;

public interface LkOutputBoundary {
    LkResponseModel prepareSuccessLkInfoView(UserDtoModel userDtoModel, List<OrderDtoModel> ordersList);
    LkResponseModel prepareFailLkInfoView();
}

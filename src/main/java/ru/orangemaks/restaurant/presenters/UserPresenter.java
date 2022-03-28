package ru.orangemaks.restaurant.presenters;

import ru.orangemaks.restaurant.domain.user.lk.LkOutputBoundary;
import ru.orangemaks.restaurant.domain.user.lk.LkResponseModel;
import ru.orangemaks.restaurant.models.OrderDtoModel;
import ru.orangemaks.restaurant.models.OrderProductsDtoModel;
import ru.orangemaks.restaurant.models.ProductDtoModel;
import ru.orangemaks.restaurant.models.UserDtoModel;

import java.util.List;
import java.util.Map;

public class UserPresenter implements LkOutputBoundary {

    @Override
    public LkResponseModel prepareSuccessLkInfoView(UserDtoModel userDtoModel, List<OrderDtoModel> ordersList) {
        return new LkResponseModel(userDtoModel,ordersList);
    }

    @Override
    public LkResponseModel prepareFailLkInfoView() {
        return new LkResponseModel(null,null);
    }
}

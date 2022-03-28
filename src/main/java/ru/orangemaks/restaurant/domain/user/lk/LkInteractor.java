package ru.orangemaks.restaurant.domain.user.lk;

import ru.orangemaks.restaurant.entities.User;
import ru.orangemaks.restaurant.models.OrderDtoModel;
import ru.orangemaks.restaurant.models.UserDtoModel;

public class LkInteractor implements LkInputBoundary{
    LkOutputBoundary lkOutputBoundary;
    LkUserDataAccess lkUserDataAccess;


    public LkInteractor(LkOutputBoundary lkOutputBoundary, LkUserDataAccess lkUserDataAccess) {
        this.lkOutputBoundary = lkOutputBoundary;
        this.lkUserDataAccess = lkUserDataAccess;
    }

    @Override
    public LkResponseModel getInfo() {
        User currentUser = lkUserDataAccess.getCurrentUser();
        if (currentUser==null) return lkOutputBoundary.prepareFailLkInfoView();

        UserDtoModel userResponse = UserDtoModel.userMapper(lkUserDataAccess.getCurrentUser());
        return lkOutputBoundary.prepareSuccessLkInfoView(userResponse, OrderDtoModel.listOrderMapper(currentUser.getOrders()));
    }
}

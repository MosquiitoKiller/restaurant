package ru.orangemaks.restaurant.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.orangemaks.restaurant.domain.user.lk.LkInputBoundary;
import ru.orangemaks.restaurant.domain.user.lk.LkResponseModel;

/**
 * Controller for response by endpoint /lkInfo
 */
@RestController
public class UsersController {
    /**
     * LkInteractor
     */
    LkInputBoundary lkInputBoundary;

    public UsersController(LkInputBoundary lkInputBoundary) {
        this.lkInputBoundary = lkInputBoundary;
    }

    /**
     * get user info
     * @return user info
     */
    @GetMapping("/lkInfo")
    public LkResponseModel getInfo(){
        return lkInputBoundary.getInfo();
    }
}

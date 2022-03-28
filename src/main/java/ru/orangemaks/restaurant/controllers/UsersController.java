package ru.orangemaks.restaurant.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.orangemaks.restaurant.domain.user.lk.LkInputBoundary;
import ru.orangemaks.restaurant.domain.user.lk.LkResponseModel;

@RestController
public class UsersController {
    LkInputBoundary lkInputBoundary;

    public UsersController(LkInputBoundary lkInputBoundary) {
        this.lkInputBoundary = lkInputBoundary;
    }

    @GetMapping("/lkInfo")
    public LkResponseModel getInfo(){
        return lkInputBoundary.getInfo();
    }
}

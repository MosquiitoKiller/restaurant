package ru.orangemaks.restaurant.domain.user.lk;

import org.springframework.stereotype.Component;

@Component
public interface LkInputBoundary {
    LkResponseModel getInfo();
}

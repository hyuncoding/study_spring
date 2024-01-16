package com.app.dependency.di.task;


import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Data
@Primary
public class Outback implements Restaurant {

    private int steak = Restaurant.steak + 10000;
    @Override
    public boolean isSaladBar() {
        return false;
    }
}

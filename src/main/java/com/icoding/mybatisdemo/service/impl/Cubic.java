package com.icoding.mybatisdemo.service.impl;

import com.icoding.mybatisdemo.service.Shape;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(1)
@Component
public class Cubic implements Shape {
    @Override
    public String draw() {
        return "正方体";
    }
}

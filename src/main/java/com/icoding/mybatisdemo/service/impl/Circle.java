package com.icoding.mybatisdemo.service.impl;

import com.icoding.mybatisdemo.service.Shape;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class Circle implements Shape {
    @Override
    public String draw() {
        return "圆形";
    }
}

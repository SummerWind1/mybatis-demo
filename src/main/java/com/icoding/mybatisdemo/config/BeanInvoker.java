package com.icoding.mybatisdemo.config;

import com.icoding.mybatisdemo.service.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BeanInvoker {

    @Autowired
    private List<Shape> shapeList;

    public String doDistribute() {

        shapeList.forEach(shape -> {
            System.out.println(shape.draw());
        });

        return "自动注入测试";
    }

}

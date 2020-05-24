package com.icoding.mybatisdemo.controller;

import com.icoding.mybatisdemo.config.BeanInvoker;
import com.icoding.mybatisdemo.pojo.Department;
import com.icoding.mybatisdemo.service.DepartmentService;
import com.icoding.mybatisdemo.service.Shape;
import com.icoding.radishspringbootautoconfigure.service.RadishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.*;

@RestController
public class MybatisDemoController {

    @Autowired
    private RadishService radishService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BeanInvoker beanInvoker;

    @RequestMapping("/hello")
    public String hello(){

        beanInvoker.doDistribute();

        return radishService.getRadish();
    }

    @RequestMapping("/add")
    public String addDepartment() {

        Department department = new Department();
        departmentService.add(department);
        return "ok";
    }

    @RequestMapping("/list")
    public List<Department> getDepartmentList() {
        // 不注入Druid 数据源时,默认使用的harika 管理数据源
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getClass());

        return departmentService.getDepartmentList();
    }

    public static void main(String[] args) {

        Integer [] a = new Integer[]{1,2,3,4};

        List<Integer> integers = Arrays.asList(a);
        Set<Integer> set = new HashSet<Integer>(integers);
        List<Integer> list = new ArrayList<>(set);
        Collections.reverse(list);
        System.out.println(list);
    }

}

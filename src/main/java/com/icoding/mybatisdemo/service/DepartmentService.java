package com.icoding.mybatisdemo.service;

import com.icoding.mybatisdemo.pojo.Department;

import java.util.List;

public interface DepartmentService {

    void add(Department department);

    List<Department> getDepartmentList();
}

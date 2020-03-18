package com.icoding.mybatisdemo.service.impl;

import com.icoding.mybatisdemo.mapper.DepartmentMapper;
import com.icoding.mybatisdemo.pojo.Department;
import com.icoding.mybatisdemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public void add(Department department) {
        departmentMapper.add(department);
    }

    @Override
    public List<Department> getDepartmentList() {
//        return Collections.emptyList();
        return departmentMapper.getDepartmentList();
    }
}

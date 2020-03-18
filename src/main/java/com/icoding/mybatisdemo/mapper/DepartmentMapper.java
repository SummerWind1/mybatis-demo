package com.icoding.mybatisdemo.mapper;

import com.icoding.mybatisdemo.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

// 标识mapper
@Mapper
// mapper 注解
@Repository
public interface DepartmentMapper {

    void add(Department department);

    List<Department> getDepartmentList();
}

package com.study.mybatis.mapper;

import com.study.mybatis.pojo.Emp;

import java.util.List;

/**
 * @author RenAshbell
 * @create 2022-05-18-15:58
 */
public interface EmpMapper {
    /**
     * 查询所有员工信息
     */
    List<Emp> getAllEmp();
}

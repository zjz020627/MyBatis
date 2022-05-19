package com.study.mybatis.mapper;

import com.study.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @author RenAshbell
 * @create 2022-05-18-15:58
 */
public interface DeptMapper {
    /**
     * 通过分布查询查询员工所对应的部门信息
     * 第二步：通过did查询员工所对应的部门
     */
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

    /**
     * 部门以及部门中所有员工信息
     */
    Dept getDeptAndEmp(@Param("did") Integer did);

    /**
     * 通过分布查询查询部门以及部门中所有的员工信息
     * 第一步：查询部门信息
     */
    Dept getDeptAndEmpByStepOne(@Param("did") Integer did);
}

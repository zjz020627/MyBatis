package com.study.mybatis.mapper;

import com.study.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 查询员工所对应的部门信息
     */
    Emp getEmpAndDept(@Param("eid") Integer eid);

    /**
     * 通过分布查询查询员工所对应的部门信息
     * 第一步：查询员工信息
     */

    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);

    /**
     * 通过分布查询查询部门以及部门中所有的员工信息
     * 第二步：根据did查询员工信息
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);
}

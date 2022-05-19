package com.study.mybatis.mapper;

import com.study.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author RenAshbell
 * @create 2022-05-19-16:57
 */
public interface CacheMapper {
    Emp getEmpByEid(@Param("eid") Integer eid);
}

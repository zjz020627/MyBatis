package com.study.mybatis.test;

import com.study.mybatis.mapper.EmpMapper;
import com.study.mybatis.pojo.Emp;
import com.study.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author RenAshbell
 * @create 2022-05-20-11:08
 */
public class MBGTest {
    @Test
    public void testMBG(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            // 查询所有数据
            /*List<Emp> list = mapper.selectByExample(null);
            list.forEach(emp -> System.out.println(emp));*/
            // 根据条件查询
            /*EmpExample example = new EmpExample();
            example.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(20);
            List<Emp> list = mapper.selectByExample(example);
            list.forEach(emp -> System.out.println(emp));*/
            mapper.updateByPrimaryKeySelective(new Emp(1,"admin",22,null,"456@qq.com",3));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

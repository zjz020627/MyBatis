package com.study.mybatis.test;

import com.study.mybatis.mapper.CacheMapper;
import com.study.mybatis.pojo.Emp;
import com.study.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author RenAshbell
 * @create 2022-05-19-16:59
 */
public class CacheMapperTest {

    /**
     * 一级缓存范围：同一个SqlSession
     */
    @Test
    public void testOneCache(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpByEid(1);
        System.out.println(emp1);
        // 清空一级缓存
        sqlSession.clearCache();
        Emp emp2 = mapper.getEmpByEid(1);
        System.out.println(emp2);
    }

    /**
     * 二级缓存范围：同一个SqlSessionFactory
     * 步骤一：在对应的Mapper.xml中设置标签<cache />
     * 步骤二：所查询的类类型必须实现序列化接口 implements Serializable
     * 步骤三：必须在关闭或提交之后才有效
     */
    @Test
    public void testTwoCache(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(is);
            SqlSession sqlSession1 = sessionFactory.openSession(true);
            CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            System.out.println(mapper1.getEmpByEid(1));
            sqlSession1.close();
            SqlSession sqlSession2 = sessionFactory.openSession(true);
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            System.out.println(mapper2.getEmpByEid(1));
            sqlSession2.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

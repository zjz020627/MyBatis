import com.study.mybatis.mapper.EmpMapper;
import com.study.mybatis.pojo.Emp;
import com.study.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author RenAshbell
 * @create 2022-05-18-15:59
 */
public class ResultMapTest {
    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getAllEmp();
        list.forEach(emp -> System.out.println(emp));
    }
}

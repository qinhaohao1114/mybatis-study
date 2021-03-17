package com.my.mybatisstudy;

import com.my.mybatisstudy.dao.StudentMapper;
import com.my.mybatisstudy.pojo.Student;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisStudyApplicationTests {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
   public void contextLoads() {
        List<Student> list = studentMapper.selectByNameAndId(null, "王同学");
        list.forEach(System.out::println);
    }

    @Test
    public void testMybatis(){
        Configuration configuration = sqlSessionFactory.getConfiguration();
        TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
        TypeHandler<Object> unknownTypeHandler = typeHandlerRegistry.getUnknownTypeHandler();
        System.out.println(unknownTypeHandler);

    }

    @Test
    public void test(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        int insert = sqlSession.insert("com.my.mybatisstudy.dao.StudentMapper.insert");
        System.out.println(insert);

    }
}

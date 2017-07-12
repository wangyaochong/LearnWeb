package test.mybatis;

import entity.TestEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import test.mybatis.interfaces.TestEntityMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by【王耀冲】on 【2017/7/7】 at 【7:48】.
 */
public class Basic {
    @Test
    public void test(){
        String resource = "mybatis/mybatis.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        System.out.println(sqlSessionFactory);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestEntityMapper mapper = sqlSession.getMapper(TestEntityMapper.class);
        TestEntity testEntity = mapper.selectById("1");
        System.out.println(testEntity);
    }
}

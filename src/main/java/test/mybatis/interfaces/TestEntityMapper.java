package test.mybatis.interfaces;

import entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by【王耀冲】on 【2017/7/7】 at 【8:01】.
 */
//@Mapper
public interface TestEntityMapper {
//    @Select("select * from testentity where id =#{id}")
    TestEntity selectById(String id);
}

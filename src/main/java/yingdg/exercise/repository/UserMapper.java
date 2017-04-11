package yingdg.exercise.repository;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import yingdg.exercise.model.User;

/**
 * Created by yingdg on 2017/4/10.
 */
@Repository
public interface UserMapper {

    /*
    只使用Mybatis注解
     */
    @Select("SELECT * FROM USER WHERE ID = #{id}")
    @Results(value = {
            @Result(column = "id", property = "id", id = true)
    })
    User findUserById(@Param("id") int id);

}

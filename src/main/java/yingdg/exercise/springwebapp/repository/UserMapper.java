package yingdg.exercise.springwebapp.repository;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import yingdg.exercise.springwebapp.model.User;

/**
 * Created by yingdg on 2017/4/10.
 */
@Repository
@Transactional // 临时添加
public interface UserMapper {

    /*
    只使用Mybatis注解
     */

    @Select("SELECT * FROM USER WHERE ID = #{id}")
    @Results(value = {
            @Result(column = "id", property = "id", id = true)
    })
    User findUserById(@Param("id") int id);

    @Select("SELECT * FROM USER WHERE USERNAME = #{username}")
    @Results(value = {
            @Result(column = "id", property = "id", id = true)
    })
    User findUserByUsername(@Param("username") String username);

    @Insert("INSERT INTO USER(username,age) VALUES(#{username},#{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int createUser(User user);

    @Delete("DELETE FROM USER WHERE ID = #{id}")
    int deleteUser(int id);

}

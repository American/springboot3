package com.lsh.mapper;

import com.lsh.entity.UserEntity;
import com.lsh.enums.UserSexEnum;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by houbank on 2018/3/27.
 */
public interface UserMapper {

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    UserEntity getOne(Long id);

    @Select("select * from users")
    @Results({
            @Result(property = "userSex",column = "user_sex",javaType = UserSexEnum.class),
            @Result(property = "nickName",column = "nick_name")
            })
    List<UserEntity> searchAll();

    @Insert("insert into users(userName,passWord,user_sex,nick_name) values(#{userName},#{passWord},#{userSex},#{nickName})")
    public void insert(UserEntity userEntity);

    @Update("update users set userName=#{userName},password=#{passWord},user_sex=#{userSex},nick_name=#{nickName} where id=#{id}")
    public void update(UserEntity userEntity);

    @Delete("delete from users where id=#{id}")
    public void delete(long id);
}

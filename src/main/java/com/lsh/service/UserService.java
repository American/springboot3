package com.lsh.service;

import com.lsh.entity.UserEntity;
import com.lsh.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 请求本地数据库增删改查
 * Created by houbank on 2018/3/27.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public UserEntity getOne(Long id){
       return userMapper.getOne(id);
    }

    public List<UserEntity> searchAll(){
        return userMapper.searchAll();
    }

    public void update(UserEntity userEntity){
         userMapper.update(userEntity);
    }

    public void insert(UserEntity userEntity){
        userMapper.insert(userEntity);
    }

    public void delete(long id){
        userMapper.delete(id);
    }
}


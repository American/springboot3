package com.lsh.Controller;

import com.lsh.entity.UserEntity;
import com.lsh.enums.UserSexEnum;
import com.lsh.mapper.UserMapper;
import com.lsh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by houbank on 2018/3/20.
 * 必须放到启动类同一个目录或者子目录下才可以扫描到
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public UserEntity getUser(){
        return userService.getOne(1L);
    }

    @RequestMapping("/searchAll")
    public List<UserEntity> searchAll(){
        return userService.searchAll();
    }

    @RequestMapping("/insert")
    public void insert(@RequestParam("userName") String userName,@RequestParam("passWord") String passWord,@RequestParam("userSex") String userSex,@RequestParam("nickName") String nickName){
        UserEntity userEntity = new UserEntity();
        userEntity.setNickName(nickName);
        userEntity.setPassWord(passWord);
        userEntity.setUserName(userName);
        userEntity.setUserSex(UserSexEnum.valueOf(userSex));
        userService.insert(userEntity);
    }

    @RequestMapping("/update")
    public void update(@RequestParam("userName") String userName,@RequestParam("id") long id){
        UserEntity userEntity = userService.getOne(id);
        userEntity.setUserName(userName);
        userService.update(userEntity);
    }

    @RequestMapping("/delete")
    public void delete(long id){
        userService.delete(id);
    }
}

package com.example.joininghands.service;

import com.example.joininghands.db.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;

/**
* @author Good Boy
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2022-08-08 16:17:56
*/
public interface UserService extends IService<User> {
    public HashMap login(String code);

    public int registerUser(String code, String nickname, String photo);
}

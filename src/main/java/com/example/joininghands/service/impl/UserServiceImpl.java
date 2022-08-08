package com.example.joininghands.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.joininghands.db.domain.User;
import com.example.joininghands.service.UserService;
import com.example.joininghands.db.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Good Boy
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2022-08-08 16:17:56
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}





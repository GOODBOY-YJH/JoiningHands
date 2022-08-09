package com.example.joininghands.db.mapper;

import com.example.joininghands.db.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

/**
* @author Good Boy
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2022-08-08 16:17:56
* @Entity com.example.joininghands.db.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    public int insert(HashMap param);

    public Integer searchIdByOpenId(String openId);
}





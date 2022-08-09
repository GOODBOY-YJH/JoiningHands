package com.example.joininghands.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.joininghands.db.domain.User;
import com.example.joininghands.service.UserService;
import com.example.joininghands.db.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

/**
* @author Good Boy
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2022-08-08 16:17:56
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Value("${wx.app-id}")
    private String appId;
    @Value("${wx.app-secret}")
    private String appSecret;
    @Autowired
    private UserMapper userMapper;

    private String getOpenId(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        HashMap map = new HashMap<>();
        map.put("appid", appId);
        map.put("secret", appSecret);
        map.put("js_code", code);
        map.put("grant_type", "authorization_code");
        String response = HttpUtil.post(url, map);
        JSONObject json = JSONUtil.parseObj(response);
        String openId = json.getStr("openid");
        if(openId == null || openId.length() == 0){
            throw new RuntimeException("临时登陆凭证错误");
        }
        return openId;
    }

    @Override
    public HashMap login(String code) {
        HashMap map = new HashMap();
        boolean result = false;
        if (StrUtil.isNotBlank(code)) {
            String openId = getOpenId(code);
            Integer userId = userMapper.searchIdByOpenId(openId);
            if (userId != null){
                map.put("userId", userId);
                result = true;
            }
        }
        map.put("result", result);
        return map;
    }

    @Override
    public int registerUser(String code, String nickname, String photo) {
        String openId = getOpenId(code);
        HashMap param = new HashMap();
        param.put("openId", openId);
        param.put("nickname", nickname);
        param.put("photo", photo);
        param.put("status", 1);
        param.put("createTime", new Date());
        userMapper.insert(param);
        int userId = userMapper.searchIdByOpenId(openId);
        return userId;
    }

}





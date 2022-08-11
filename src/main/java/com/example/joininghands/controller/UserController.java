package com.example.joininghands.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.example.joininghands.common.util.R;
import com.example.joininghands.controller.form.RegisterForm;
import com.example.joininghands.controller.form.LoginForm;
import com.example.joininghands.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("/user")
@Tag(name = "UserController", description = "用户Web接口")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    @Operation(summary = "注册用户")
    public R register(@Valid @RequestBody RegisterForm form){
        int userId = userService.registerUser(form.getCode(), form.getNickname(), form.getPhoto());
        StpUtil.login(userId);
        String token=StpUtil.getTokenInfo().getTokenValue();
        return R.ok("用户注册成功").put("token", token);
    }

    @PostMapping("/login")
    @Operation(summary = "微信小程序登陆")
    public R login(@Valid @RequestBody LoginForm form) {
        // 把登陆token返回
        String token=StpUtil.getTokenInfo().getTokenValue();
        // 检查是否登陆
        if (StpUtil.isLogin()) {
            return R.ok().put("result", true).put("token", token);
        }else {
            HashMap map = userService.login(form.getCode());
            boolean result = (boolean) map.get("result");
            if (result) {
                int userId = (int) map.get("userId");
                StpUtil.login(userId);
                map.put("token", token);
            }else {
                map.put("msg", "请先注册");
            }
            return R.ok(map);
        }
    }
}

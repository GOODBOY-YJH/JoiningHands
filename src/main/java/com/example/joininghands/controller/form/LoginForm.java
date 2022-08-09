package com.example.joininghands.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Schema(name = "LoginForm", description = "微信小程序登陆手牵手Form类")
@Data
public class LoginForm {

    @NotBlank(message = "临时授权不能为空")
    private String code;

}

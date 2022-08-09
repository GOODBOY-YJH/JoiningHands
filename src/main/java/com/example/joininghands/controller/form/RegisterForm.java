package com.example.joininghands.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Schema(description = "注册Form类")
public class RegisterForm {

    @NotBlank(message = "微信临时授权不能为空")
    private String code;
    @NotBlank(message = "昵称不能为空")
    private String nickname;
    @NotBlank(message = "头像不能为空")
    private String photo;

}
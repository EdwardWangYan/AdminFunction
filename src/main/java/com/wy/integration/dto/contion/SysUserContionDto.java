package com.wy.integration.dto.contion;

import com.wy.integration.dto.contion.page.PaginationRequest;
import io.swagger.annotations.ApiModelProperty;

public class SysUserContionDto extends PaginationRequest {
    @ApiModelProperty(value = "登录名或者邮箱查询")
    private String loginNameOrEmail;

    public String getLoginNameOrEmail() {
        return loginNameOrEmail;
    }

    public void setLoginNameOrEmail(String loginNameOrEmail) {
        this.loginNameOrEmail = loginNameOrEmail;
    }
}

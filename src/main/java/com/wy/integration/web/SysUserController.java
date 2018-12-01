package com.wy.integration.web;
import com.wy.integration.annotation.SysLog;
import com.wy.integration.core.Result;
import com.wy.integration.core.ResultGenerator;
import com.wy.integration.dto.OperatorLoginDto;
import com.wy.integration.dto.SysUserAddDto;
import com.wy.integration.dto.contion.SysUserContionDto;
import com.wy.integration.dto.returnlist.SysUserLoginSucessDto;
import com.wy.integration.model.SysUser;
import com.wy.integration.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import com.wy.integration.utils.ResPonseUtils.RestfulApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
*
* Created by Edward on 2018/06/26.
*/
@RestController
@RequestMapping("sysuser")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;


    @ApiOperation("用户登录")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @SysLog("用户登录")
    public RestfulApiResponse<SysUserLoginSucessDto> login(@Valid @RequestBody OperatorLoginDto dto, HttpServletRequest req, HttpServletResponse res, Errors errors) {
        return RestfulApiResponse.success("登录成功", sysUserService.login(dto));
    }


    @ApiOperation("用户新增")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @SysLog("用户新增")
    public RestfulApiResponse<Integer> add(@RequestBody SysUserAddDto sysUser, Errors errors) {
        return RestfulApiResponse.success("新增成功",  sysUserService.add(sysUser));
    }

    @ApiOperation("删除用户")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    @SysLog("删除用户")
    public RestfulApiResponse<Integer> delete(@RequestParam String id) {
        return RestfulApiResponse.success("删除用户成功", sysUserService.deleteBy(id));
    }

    @ApiOperation("更新用户")
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @SysLog("更新用户")
    public RestfulApiResponse<Integer>  update(@RequestBody SysUserAddDto sysUser, Errors errors) {

            return RestfulApiResponse.success("更新用户成功", sysUserService.updateUser(sysUser));
    }

    @ApiOperation("获取用户细节")
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public RestfulApiResponse<SysUser> detail(@RequestParam String id) {
            return RestfulApiResponse.success("获取用户详情成功", sysUserService.findByIdDel(id));
    }

    @ApiOperation("根据条件 获取用户列表")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public RestfulApiResponse<PageInfo> list(@Valid @ModelAttribute SysUserContionDto dto,Errors errors) {
        return RestfulApiResponse.success("获取用户成功", sysUserService.findByContion(dto));
    }
}

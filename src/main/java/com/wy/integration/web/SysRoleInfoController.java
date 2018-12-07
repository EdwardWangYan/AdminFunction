package com.wy.integration.web;
import com.wy.integration.core.Result;
import com.wy.integration.core.ResultGenerator;
import com.wy.integration.dto.AddDeatilsUpdate.SysRoleAddUpdateDto;
import com.wy.integration.dto.AddDeatilsUpdate.SysUserAddUpdateDto;
import com.wy.integration.model.SysRoleInfo;
import com.wy.integration.service.SysRoleInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.wy.integration.utils.ResPonseUtils.RestfulApiResponse;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
*
* Created by Edward on 2018/12/04.
*/
@RestController
@RequestMapping("sysRoleinfo")
@Api(description = "角色管理")
public class SysRoleInfoController {
    @Resource
    private SysRoleInfoService sysRoleInfoService;

    @ApiOperation("新增角色，绑定资源，权限 后台使用")
    @RequestMapping(value = "addRole", method = RequestMethod.POST)
    public RestfulApiResponse<Integer> addRole(@RequestBody SysRoleAddUpdateDto roleDto, Errors errors) {
        return RestfulApiResponse.success("新增成功",  sysRoleInfoService.addRole(roleDto));
    }

    @ApiOperation("")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public RestfulApiResponse<Integer> delete(@RequestParam String id) {
        return RestfulApiResponse.success("", sysRoleInfoService.deleteById(id));
    }

    @ApiOperation("")
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public RestfulApiResponse<Integer>  update(SysRoleInfo sysRoleInfo) {

            return RestfulApiResponse.success("", sysRoleInfoService.update(sysRoleInfo));
    }

    @ApiOperation("")
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public RestfulApiResponse<SysRoleInfo> detail(@RequestParam String id) {
            return RestfulApiResponse.success("", sysRoleInfoService.findById(id));
    }
    @ApiOperation("")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public RestfulApiResponse<PageInfo> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysRoleInfo> list = sysRoleInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return RestfulApiResponse.success("", pageInfo);
    }
}

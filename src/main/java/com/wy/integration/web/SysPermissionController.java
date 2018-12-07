package com.wy.integration.web;
import com.wy.integration.core.Result;
import com.wy.integration.core.ResultGenerator;
import com.wy.integration.dto.AddDeatilsUpdate.SysPermissionAddUpdateDto;
import com.wy.integration.model.SysPermission;
import com.wy.integration.service.SysPermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.wy.integration.utils.ResPonseUtils.RestfulApiResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
*
* Created by Edward on 2018/12/04.
*/
@RestController
@RequestMapping("sysPermission")
@Api(description = "权限管理")
public class SysPermissionController {
    @Resource
    private SysPermissionService sysPermissionService;

    @ApiOperation("配置权限 后台使用")
    @RequestMapping(value = "addPermission", method = RequestMethod.POST)
    public RestfulApiResponse<Integer> addPermission(@RequestBody SysPermissionAddUpdateDto sysPermission) {
        return RestfulApiResponse.success("新增成功",  sysPermissionService.addPermission(sysPermission));
    }

    @ApiOperation("")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public RestfulApiResponse<Integer> delete(@RequestParam String id) {
        return RestfulApiResponse.success("", sysPermissionService.deleteById(id));
    }

    @ApiOperation("")
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public RestfulApiResponse<Integer>  update(SysPermission sysPermission) {

            return RestfulApiResponse.success("", sysPermissionService.update(sysPermission));
    }

    @ApiOperation("")
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public RestfulApiResponse<SysPermission> detail(@RequestParam String id) {
            return RestfulApiResponse.success("", sysPermissionService.findById(id));
    }
    @ApiOperation("")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public RestfulApiResponse<PageInfo> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysPermission> list = sysPermissionService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return RestfulApiResponse.success("", pageInfo);
    }
}

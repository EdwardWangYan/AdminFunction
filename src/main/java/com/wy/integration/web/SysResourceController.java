package com.wy.integration.web;
import com.wy.integration.constants.ConstantsFlag;
import com.wy.integration.dto.AddDeatilsUpdate.Resource.MenuCreateDto;
import com.wy.integration.dto.AddDeatilsUpdate.Resource.ModuleCreateDto;
import com.wy.integration.dto.AddDeatilsUpdate.Resource.OperationCreateDto;
import com.wy.integration.dto.AddDeatilsUpdate.Resource.PageCreateDto;
import com.wy.integration.model.SysResource;
import com.wy.integration.service.SysResourceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.wy.integration.utils.ResPonseUtils.RestfulApiResponse;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
*
* Created by Edward on 2018/12/04.
*/
@RestController
@RequestMapping("sysResource")
@Api(description = "资源管理")
public class SysResourceController {
    @Resource
    private SysResourceService sysResourceService;

    @ApiOperation("创建模块")
    @RequestMapping(value = "createModule", method = RequestMethod.POST)
    //@RequiresRoles("superAdmin")
    public RestfulApiResponse<String> createModule(@Valid @RequestBody ModuleCreateDto dto, Errors errors) {
        return RestfulApiResponse.success("创建模块成功", sysResourceService.createResource(dto, ConstantsFlag.ResourceLevel.MODULE));
    }

    @ApiOperation("创建菜单")
    @RequestMapping(value = "createMenu", method = RequestMethod.POST)
    //@RequiresRoles("superAdmin")
    public RestfulApiResponse<String> createMenu(@Valid @RequestBody MenuCreateDto dto, Errors errors) {
        return RestfulApiResponse.success("创建菜单成功", sysResourceService.createResource(dto, ConstantsFlag.ResourceLevel.MENU));
    }

    @ApiOperation("创建页面")
    @RequestMapping(value = "createPage", method = RequestMethod.POST)
    //@RequiresRoles("superAdmin")
    public RestfulApiResponse<String> createPage(@Valid @RequestBody PageCreateDto dto, Errors errors) {
        return RestfulApiResponse.success("创建页面成功", sysResourceService.createResource(dto, ConstantsFlag.ResourceLevel.PAGE));
    }

    @ApiOperation("创建操作")
    @RequestMapping(value = "createOperation", method = RequestMethod.POST)
    //@RequiresRoles("superAdmin")
    public RestfulApiResponse<String> createOperation(@Valid @RequestBody OperationCreateDto dto, Errors errors) {
        return RestfulApiResponse.success("创建操作成功", sysResourceService.createResource(dto, ConstantsFlag.ResourceLevel.OPERATION));
    }


    @ApiOperation("")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public RestfulApiResponse<Integer> delete(@RequestParam String id) {
        return RestfulApiResponse.success("", sysResourceService.deleteById(id));
    }

    @ApiOperation("")
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public RestfulApiResponse<Integer>  update(SysResource sysResource) {

            return RestfulApiResponse.success("", sysResourceService.update(sysResource));
    }

    @ApiOperation("")
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public RestfulApiResponse<SysResource> detail(@RequestParam String id) {
            return RestfulApiResponse.success("", sysResourceService.findById(id));
    }
    @ApiOperation("")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public RestfulApiResponse<PageInfo> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysResource> list = sysResourceService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return RestfulApiResponse.success("", pageInfo);
    }
}

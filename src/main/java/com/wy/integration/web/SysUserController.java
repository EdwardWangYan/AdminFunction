package com.wy.integration.web;
import javax.validation.Valid;
import com.wy.integration.dto.SysUserAddDto;
import com.wy.integration.model.SysUser;
import com.wy.integration.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.wy.integration.utils.ResPonseUtils.RestfulApiResponse;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
*
* Created by Edward on 2018/06/10.
*/
@RestController
@RequestMapping("sysuser")
@Api(description = "与用户相关的api")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

/*    @ApiOperation("")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public RestfulApiResponse<Integer> add(@Valid @RequestBody SysUserAddDto userAddDto,Errors errors) {
        return RestfulApiResponse.success("",  sysUserService.save(sysUser));
    }*/

    @ApiOperation("")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public RestfulApiResponse<Integer> delete(@RequestParam String id) {
        return RestfulApiResponse.success("", sysUserService.deleteById(id));
    }

    @ApiOperation("")
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public RestfulApiResponse<Integer>  update(SysUser sysUser) {

            return RestfulApiResponse.success("", sysUserService.update(sysUser));
    }

    @ApiOperation("")
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public RestfulApiResponse<SysUser> detail(@RequestParam Integer id) {
            return RestfulApiResponse.success("", sysUserService.findById(id));
    }
    @ApiOperation("")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public RestfulApiResponse<PageInfo> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysUser> list = sysUserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return RestfulApiResponse.success("", pageInfo);
    }
}

package com.wy.integration.web;
import com.wy.integration.annotation.SysLog;
import com.wy.integration.core.Result;
import com.wy.integration.core.ResultGenerator;
import com.wy.integration.model.SysOrgInfo;
import com.wy.integration.service.SysOrgInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.wy.integration.utils.ResPonseUtils.RestfulApiResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
*
* Created by Edward on 2018/12/04.
*/
@RestController
@RequestMapping("sysOrginfo")
@Api(description = "机构管理")
public class SysOrgInfoController {
    @Resource
    private SysOrgInfoService sysOrgInfoService;

    @ApiOperation("新增机构")
    @RequestMapping(value = "addOrg", method = RequestMethod.POST)
    @SysLog("新增机构")
    public RestfulApiResponse<Integer> addOrg(@RequestBody SysOrgInfo sysOrgInfo) {
        return RestfulApiResponse.success("",  sysOrgInfoService.addOrg(sysOrgInfo));
    }

    @ApiOperation("")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public RestfulApiResponse<Integer> delete(@RequestParam String id) {
        return RestfulApiResponse.success("", sysOrgInfoService.deleteById(id));
    }

    @ApiOperation("")
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public RestfulApiResponse<Integer>  update(SysOrgInfo sysOrgInfo) {

            return RestfulApiResponse.success("", sysOrgInfoService.update(sysOrgInfo));
    }

    @ApiOperation("")
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public RestfulApiResponse<SysOrgInfo> detail(@RequestParam String id) {
            return RestfulApiResponse.success("", sysOrgInfoService.findById(id));
    }
    @ApiOperation("")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public RestfulApiResponse<PageInfo> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysOrgInfo> list = sysOrgInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return RestfulApiResponse.success("", pageInfo);
    }
}

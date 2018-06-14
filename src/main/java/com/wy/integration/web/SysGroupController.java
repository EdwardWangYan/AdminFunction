package com.wy.integration.web;
import com.wy.integration.core.Result;
import com.wy.integration.core.ResultGenerator;
import com.wy.integration.model.SysGroup;
import com.wy.integration.service.SysGroupService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import com.wy.integration.utils.ResPonseUtils.RestfulApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
*
* Created by Edward on 2018/06/10.
*/
@RestController
@RequestMapping("sysgroup")
public class SysGroupController {
    @Resource
    private SysGroupService sysGroupService;

    @ApiOperation("")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public RestfulApiResponse<Integer> add(SysGroup sysGroup) {
        return RestfulApiResponse.success("",  sysGroupService.save(sysGroup));
    }

    @ApiOperation("")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public RestfulApiResponse<Integer> delete(@RequestParam String id) {
        return RestfulApiResponse.success("", sysGroupService.deleteById(id));
    }

    @ApiOperation("")
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public RestfulApiResponse<Integer>  update(SysGroup sysGroup) {

            return RestfulApiResponse.success("", sysGroupService.update(sysGroup));
    }

    @ApiOperation("")
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public RestfulApiResponse<SysGroup> detail(@RequestParam Integer id) {
            return RestfulApiResponse.success("", sysGroupService.findById(id));
    }
    @ApiOperation("")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public RestfulApiResponse<PageInfo> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysGroup> list = sysGroupService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return RestfulApiResponse.success("", pageInfo);
    }
}

package com.wy.integration.web;
import com.wy.integration.core.Result;
import com.wy.integration.core.ResultGenerator;
import com.wy.integration.model.SysLog;
import com.wy.integration.service.SysLogService;
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
@RequestMapping("syslog")
public class SysLogController {
    @Resource
    private SysLogService sysLogService;

    @ApiOperation("")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public RestfulApiResponse<Integer> add(SysLog sysLog) {
        return RestfulApiResponse.success("",  sysLogService.save(sysLog));
    }

    @ApiOperation("")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public RestfulApiResponse<Integer> delete(@RequestParam String id) {
        return RestfulApiResponse.success("", sysLogService.deleteById(id));
    }

    @ApiOperation("")
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public RestfulApiResponse<Integer>  update(SysLog sysLog) {

            return RestfulApiResponse.success("", sysLogService.update(sysLog));
    }

    @ApiOperation("")
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public RestfulApiResponse<SysLog> detail(@RequestParam Integer id) {
            return RestfulApiResponse.success("", sysLogService.findById(id));
    }
    @ApiOperation("")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public RestfulApiResponse<PageInfo> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysLog> list = sysLogService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return RestfulApiResponse.success("", pageInfo);
    }
}

package com.wy.integration.web;
import com.wy.integration.core.Result;
import com.wy.integration.core.ResultGenerator;
import com.wy.integration.model.SysResource;
import com.wy.integration.service.SysResourceService;
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
* Created by Edward on 2018/12/04.
*/
@RestController
@RequestMapping("sysresource")
public class SysResourceController {
    @Resource
    private SysResourceService sysResourceService;

    @ApiOperation("")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public RestfulApiResponse<Integer> add(SysResource sysResource) {
        return RestfulApiResponse.success("",  sysResourceService.save(sysResource));
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

package com.wy.integration.web;
import com.wy.integration.core.Result;
import com.wy.integration.core.ResultGenerator;
import com.wy.integration.model.TUser;
import com.wy.integration.service.TUserService;
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
* Created by Edward on 2018/05/23.
*/
@RestController
@RequestMapping("tuser")
public class TUserController {
    @Resource
    private TUserService tUserService;

    @ApiOperation("")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public RestfulApiResponse<Integer> add(TUser tUser) {
        return RestfulApiResponse.success("",  tUserService.save(tUser));
    }

    @ApiOperation("")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public RestfulApiResponse<Integer> delete(@RequestParam String id) {
        return RestfulApiResponse.success("", tUserService.deleteById(id));
    }

    @ApiOperation("")
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public RestfulApiResponse<Integer>  update(TUser tUser) {

            return RestfulApiResponse.success("", tUserService.update(tUser));
    }

    @ApiOperation("")
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public RestfulApiResponse<TUser> detail(@RequestParam Integer id) {
            return RestfulApiResponse.success("", tUserService.findById(id));
    }
    @ApiOperation("")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public RestfulApiResponse<PageInfo> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<TUser> list = tUserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return RestfulApiResponse.success("", pageInfo);
    }
}

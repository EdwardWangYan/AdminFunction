package com.wy.integration.web;
import com.wy.integration.core.Result;
import com.wy.integration.core.ResultGenerator;
import com.wy.integration.model.TUser;
import com.wy.integration.service.TUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
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
    public Result add(TUser tUser) {
        tUserService.save(tUser);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation("")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public Result delete(@RequestParam Integer id) {
        tUserService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation("")
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public Result update(TUser tUser) {
        tUserService.update(tUser);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation("")
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public Result detail(@RequestParam Integer id) {
        TUser tUser = tUserService.findById(id);
        return ResultGenerator.genSuccessResult(tUser);
    }
    @ApiOperation("")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<TUser> list = tUserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

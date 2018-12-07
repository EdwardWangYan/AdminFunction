package com.wy.integration.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wy.integration.constants.ConstantsFlag;
import com.wy.integration.core.MySysUser;
import com.wy.integration.dao.SysUserMapper;
import com.wy.integration.dto.OperatorLoginDto;
import com.wy.integration.dto.AddDeatilsUpdate.SysUserAddUpdateDto;
import com.wy.integration.dto.condition.SysUserContionDto;
import com.wy.integration.dto.returnlist.SysUserLoginSucessDto;
import com.wy.integration.exception.ErrCode.CMMErrorCode;
import com.wy.integration.exception.ResponseException;
import com.wy.integration.model.SysUser;
import com.wy.integration.service.SysUserRoleRelationService;
import com.wy.integration.service.SysUserService;
import com.wy.integration.core.AbstractService;
import com.wy.integration.utils.ToolUtil;
import com.wy.integration.utils.support.DaoSupports;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by Edward on 2018/06/10.
 */
@Service
@Transactional
public class SysUserServiceImpl extends AbstractService<SysUser> implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserRoleRelationService sysUserRoleRelationService;

    /**
     * 验证商品名称是否重复
     */

    /**
     * 验证用户登录名是否重复
     */
    public SysUser existTitle(String loginName) {
        return findBy("loginName",loginName);
    }
    //验证用户登录名是否重复
    protected void throwIfExistAccount(String title) {
        if (existTitle(title)!=null) {
            throw new ResponseException(CMMErrorCode.USER_TITLE_IS_EXISTS);
        }
    }



    //验证用户邮箱是否重复
    protected void throwIfExistEmail(String email) {
        if (existEmail(email)!=null) {
            throw new ResponseException(CMMErrorCode.USER_TITLE_IS_EXISTS);
        }
    }
    //验证用户邮箱是否重复
    public SysUser existEmail(String email) {
        return findBy("email",email);
    }
    //验证用户手机是否重复
    protected void throwIfExistTel(String tel) {
        if (existTel(tel)!=null) {
            throw new ResponseException(CMMErrorCode.USER_TITLE_IS_EXISTS);
        }
    }

    //验证用户手机是否重复
    public SysUser existTel(String tel) {
        return findBy("tel",tel);
    }

    /**
     * 验证商品是否重复  转化实体和模型
     */

    private SysUser verifyCreateDto(SysUserAddUpdateDto dto) {
        throwIfExistAccount(dto.getLoginName());
        SysUser sysUser=new SysUser();
        BeanUtils.copyProperties(dto, sysUser);
        return sysUser;
    }


    @Override
    public int add(SysUserAddUpdateDto userAddDto) {
        SysUser sysUser= verifyCreateDto(userAddDto);
        ToolUtil.entryptPassword(sysUser);
        sysUser.setLocked(ConstantsFlag.IsDeleteFlag.NotDeleted.getValue());
        DaoSupports.addOrgId(sysUser);//前端添加的用户 添加当前用户的机构主键
        if(userAddDto.getRoleList()!=null&&userAddDto.getRoleList().size()>ConstantsFlag.FLAG.ZERO.getValue())
            sysUserRoleRelationService.initUserRole(sysUser.getId(),userAddDto.getRoleList());
        return save(sysUser);
    }


    @Override
    public int initOrgUser(SysUser sysUser) {
        ToolUtil.entryptPassword(sysUser);
        sysUser.setLocked(ConstantsFlag.IsDeleteFlag.NotDeleted.getValue());
        return save(sysUser);
    }



    //根据模型  做更新前准备
    private SysUser getUser(SysUserAddUpdateDto userAddDto){
        //更新用户
        SysUser sysUser=new SysUser();
        BeanUtils.copyProperties(userAddDto, sysUser);
        return sysUser;
    }


    //更新用户操作
    @Override
    public int updateUser(SysUserAddUpdateDto userAddDto) {
        SysUser sysUser= getUser(userAddDto);
        ToolUtil.entryptPassword(sysUser);
        return update(sysUser);
    }




    @Override
    public PageInfo findByContion(SysUserContionDto dto) {
        PageHelper.startPage(dto.getIndex(), dto.getSize());
        Condition condition=new Condition(SysUser.class);
        Example.Criteria createCriteria=condition.createCriteria();
        if(StringUtils.isNoneBlank(dto.getLoginNameOrEmail())){
            createCriteria.andLike("loginName","%" + StringUtils.trim(dto.getLoginNameOrEmail()) + "%");
            createCriteria.orLike("email","%" + StringUtils.trim(dto.getLoginNameOrEmail()) + "%");
        }
        List<SysUser> userList=findByConditionDel(condition,createCriteria);
        return   new PageInfo(userList);
    }

    @Override
    public SysUserLoginSucessDto login(OperatorLoginDto dto) {
        Subject user=SecurityUtils.getSubject();
        user.login(new UsernamePasswordToken(dto.getUsername(), dto.getPassword(), dto.getRememberMe()));
        SysUser u = findByIdDel(MySysUser.id());
        SysUserLoginSucessDto su=new SysUserLoginSucessDto();
        if(u!=null){
            BeanUtils.copyProperties(u, su);
        }
        return su;
    }


}

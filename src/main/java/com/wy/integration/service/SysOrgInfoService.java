package com.wy.integration.service;
import com.wy.integration.model.SysOrgInfo;
import com.wy.integration.core.Service;


/**
 * Created by Edward on 2018/12/04.
 */
public interface SysOrgInfoService extends Service<SysOrgInfo> {
    public int addOrg(SysOrgInfo userAddDto);

    public int updateOrg(SysOrgInfo userAddDto);

}

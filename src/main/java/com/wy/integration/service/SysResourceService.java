package com.wy.integration.service;
import com.wy.integration.constants.ConstantsFlag;
import com.wy.integration.dto.AddDeatilsUpdate.SysResourceAddUpdateDto;
import com.wy.integration.model.SysResource;
import com.wy.integration.core.Service;


/**
 * Created by Edward on 2018/12/04.
 */
public interface SysResourceService extends Service<SysResource> {

    public String createResource(SysResourceAddUpdateDto dto, ConstantsFlag.ResourceLevel level);

}

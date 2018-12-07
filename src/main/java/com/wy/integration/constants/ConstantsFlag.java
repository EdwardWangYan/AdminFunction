/**
 * Copyright(c) Cloudolp Technology Co.,Ltd
 * All Rights Reserved.
 * <p>
 * This software is the confidential and proprietary information of Cloudolp
 * Technology Co.,Ltd. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with Cloudolp.
 * For more information about Cloudolp, welcome to http://www.cloudolp.com
 * <p>
 * project: yyTaxi-platform
 * <p>
 * Revision History:
 * Date		Version		Name				Description
 * 5/3/2016	1.0			Franklin			Creation File
 */
package com.wy.integration.constants;


/**
 * Description:
 *
 * @author Edward
 * Date 12/5/2018
 */
public class ConstantsFlag {

    public enum FLAG {
        ZERO(0);
        public Integer value;

        FLAG(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }

    public enum IsDeleteFlag {
        NotDeleted(0),
        DELETED(1);
        public Integer value;

        IsDeleteFlag(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }


    public enum DateData {
        yesterday(-1),
        today(0),
        tomorrow(1);
        public Integer value;

        DateData(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }

    public enum ResourceLevel {
        MODULE(1, null, "模块"),
        MENU(2, MODULE, "菜单"),
        PAGE(3, MENU, "页面"),
        OPERATION(4, PAGE, "操作"),;

        private int val;
        private ResourceLevel parent;
        private String desc;

        public int getVal() {
            return val;
        }

        public ResourceLevel getParent() {
            return parent;
        }

        public String getDesc() {
            return desc;
        }

        ResourceLevel(int val, ResourceLevel parent, String desc) {
            this.val = val;
            this.parent = parent;
            this.desc = desc;
        }
    }

}

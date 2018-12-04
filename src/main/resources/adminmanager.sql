/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.24 : Database - adminmanager
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`adminmanager` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `adminmanager`;

/*Table structure for table `sys_log` */

DROP TABLE IF EXISTS `sys_log`;

CREATE TABLE `sys_log` (
  `id` varchar(64) NOT NULL,
  `org_id` varchar(64) NOT NULL COMMENT '关联机构信息表ID',
  `type` varchar(64) DEFAULT '0' COMMENT '上一级部门ID，关联本表ID字段，如为顶级则为0，默认为0',
  `title` varchar(30) NOT NULL COMMENT '部门名称',
  `remote_addr` varchar(64) DEFAULT NULL,
  `user_name` varchar(30) DEFAULT NULL COMMENT '部门的简称',
  `request_uri` longtext COMMENT '简称字母表示',
  `http_method` varchar(150) DEFAULT NULL COMMENT '部门的图标，可以为空',
  `class_method` varchar(150) NOT NULL DEFAULT '1' COMMENT '用于记录的逻辑删除，0：删除，1：正常，默认为1\r\n            业务逻辑中：若DELETED_FLAG = 0为删除状态，则该记录一点不能被操作\r\n            ',
  `session_id` varchar(150) DEFAULT NULL COMMENT '简称字母表示',
  `use_time` bigint(150) DEFAULT NULL COMMENT '简称字母表示',
  `browser` varchar(150) DEFAULT NULL COMMENT '简称字母表示',
  `area` varchar(150) DEFAULT NULL COMMENT '简称字母表示',
  `province` varchar(150) DEFAULT NULL COMMENT '简称字母表示',
  `city` varchar(150) DEFAULT NULL COMMENT '简称字母表示',
  `isp` varchar(150) DEFAULT NULL COMMENT '简称字母表示',
  `create_date` datetime NOT NULL COMMENT '创建时间，创建该记录的系统时间。',
  `create_by` varchar(64) NOT NULL COMMENT '创建人ID，为系统用户表中的当前登录用户ID。',
  `update_date` datetime DEFAULT NULL COMMENT '上一次修改该记录的时间，未修改过可以为空或为创建记录的时间。',
  `update_by` varchar(64) DEFAULT NULL COMMENT '最近一次修改该记录的用户ID，可以为空或为首次创建人的ID',
  `remarks` varchar(150) DEFAULT NULL COMMENT '简称字母表示',
  `params` longtext COMMENT '简称字母表示',
  `exception` varchar(150) DEFAULT NULL COMMENT '简称字母表示',
  `response` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门信息表，为树结构定义。包括部门及下一级部门';

/*Table structure for table `sys_org_info` */

DROP TABLE IF EXISTS `sys_org_info`;

CREATE TABLE `sys_org_info` (
  `id` varchar(64) NOT NULL,
  `title` varchar(30) NOT NULL COMMENT '机构名称',
  `code` varchar(64) DEFAULT NULL,
  `org_type_code` varchar(64) DEFAULT NULL COMMENT '机构类型ID，关联机构类型表',
  `full_name` varchar(80) DEFAULT NULL COMMENT '机构全称',
  `short_name` varchar(30) DEFAULT NULL COMMENT '机构简称',
  `short_code` varchar(16) DEFAULT NULL COMMENT '机构简称代码',
  `parent_id` varchar(64) DEFAULT '0' COMMENT '父机构类别，关联本表ID字段，',
  `org_logo_id` varchar(64) DEFAULT NULL COMMENT '图片、文件资源与文件表中ID关联',
  `website` varchar(150) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `telephone` varchar(150) DEFAULT NULL,
  `contact_person` varchar(30) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT '1' COMMENT '用于标识该记录状态情况只有STATUS != 0的记录才能被业务逻辑使用，0：无效，1：有效，默认为1。',
  `del_flag` int(11) NOT NULL DEFAULT '1' COMMENT '用于记录的逻辑删除，0：删除，1：正常，默认为1\r\n            业务逻辑中：若DELETED_FLAG = 0为删除状态，则该记录一点不能被操作\r\n            ',
  `create_date` datetime NOT NULL COMMENT '创建时间，创建该记录的系统时间。',
  `create_by` varchar(64) NOT NULL COMMENT '创建人ID，为系统用户表中的当前登录用户ID。',
  `update_date` datetime DEFAULT NULL COMMENT '上一次修改该记录的时间，未修改过可以为空或为创建记录的时间。',
  `update_by` varchar(64) DEFAULT NULL COMMENT '最近一次修改该记录的用户ID，可以为空或为首次创建人的ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机构基本信息表';

/*Table structure for table `sys_permission` */

DROP TABLE IF EXISTS `sys_permission`;

CREATE TABLE `sys_permission` (
  `id` varchar(64) NOT NULL,
  `permission_code` varchar(64) NOT NULL COMMENT '权限的代码/通配符,对应代码中@RequiresPermissions 的value',
  `permission_name` varchar(64) NOT NULL COMMENT '本权限的中文释义',
  `del_flag` int(11) NOT NULL DEFAULT '1' COMMENT '用于记录的逻辑删除，0：删除，1：正常，默认为1\r\n            业务逻辑中：若DELETED_FLAG = 0为删除状态，则该记录一点不能被操作\r\n            ',
  `create_date` datetime NOT NULL COMMENT '创建时间，创建该记录的系统时间。',
  `create_by` varchar(64) NOT NULL COMMENT '创建人ID，为系统用户表中的当前登录用户ID。',
  `update_date` datetime DEFAULT NULL COMMENT '上一次修改该记录的时间，未修改过可以为空或为创建记录的时间。',
  `update_by` varchar(64) DEFAULT NULL COMMENT '最近一次修改该记录的用户ID，可以为空或为首次创建人的ID',
  `org_id` varbinary(64) DEFAULT NULL COMMENT '机构主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统默认权限表';

/*Table structure for table `sys_resource` */

DROP TABLE IF EXISTS `sys_resource`;

CREATE TABLE `sys_resource` (
  `id` varchar(192) DEFAULT NULL,
  `parent_id` varchar(192) DEFAULT NULL,
  `resource_title` varchar(90) DEFAULT NULL,
  `summary` varchar(765) DEFAULT NULL,
  `resource_type` double DEFAULT NULL,
  `resource_icon` varchar(450) DEFAULT NULL,
  `resource_url` varchar(1500) DEFAULT NULL,
  `resource_ext` varchar(6000) DEFAULT NULL,
  `org_type` varchar(192) DEFAULT NULL,
  `orders_index` double DEFAULT NULL,
  `remark2` varchar(765) DEFAULT NULL,
  `del_flag` double DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(192) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(192) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `sys_role_info` */

DROP TABLE IF EXISTS `sys_role_info`;

CREATE TABLE `sys_role_info` (
  `id` varchar(64) NOT NULL,
  `org_id` varchar(64) DEFAULT NULL,
  `role_name` varchar(30) NOT NULL,
  `code` varchar(50) NOT NULL COMMENT '标识代码，在同一组织机构内唯一',
  `type_id` varchar(64) DEFAULT NULL COMMENT '角色类型,1:平台;2:机构,3:通用',
  `remark` varchar(255) DEFAULT NULL,
  `del_flag` int(11) NOT NULL DEFAULT '1' COMMENT '用于记录的逻辑删除，0：删除，1：正常，默认为1\r\n            业务逻辑中：若DELETED_FLAG = 0为删除状态，则该记录一点不能被操作\r\n            ',
  `create_date` datetime NOT NULL COMMENT '创建时间，创建该记录的系统时间。',
  `create_by` varchar(64) NOT NULL COMMENT '创建人ID，为系统用户表中的当前登录用户ID。',
  `update_date` datetime DEFAULT NULL COMMENT '上一次修改该记录的时间，未修改过可以为空或为创建记录的时间。',
  `update_by` varchar(64) DEFAULT NULL COMMENT '最近一次修改该记录的用户ID，可以为空或为首次创建人的ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台提供的默色角色';

/*Table structure for table `sys_role_permission` */

DROP TABLE IF EXISTS `sys_role_permission`;

CREATE TABLE `sys_role_permission` (
  `id` varchar(64) NOT NULL,
  `role_id` varchar(64) NOT NULL COMMENT '关联系统角色表',
  `permission_id` varchar(64) NOT NULL COMMENT '关联系统权限表',
  `del_flag` int(11) NOT NULL DEFAULT '1' COMMENT '用于记录的逻辑删除，0：删除，1：正常，默认为1\r\n            业务逻辑中：若DELETED_FLAG = 0为删除状态，则该记录一点不能被操作\r\n            ',
  `create_date` datetime NOT NULL COMMENT '创建时间，创建该记录的系统时间。',
  `create_by` varchar(64) NOT NULL COMMENT '创建人ID，为系统用户表中的当前登录用户ID。',
  `update_date` datetime DEFAULT NULL COMMENT '上一次修改该记录的时间，未修改过可以为空或为创建记录的时间。',
  `update_by` varchar(64) DEFAULT NULL COMMENT '最近一次修改该记录的用户ID，可以为空或为首次创建人的ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统默认角色权限表';

/*Table structure for table `sys_role_resource` */

DROP TABLE IF EXISTS `sys_role_resource`;

CREATE TABLE `sys_role_resource` (
  `id` varchar(64) NOT NULL,
  `role_id` varchar(64) NOT NULL COMMENT '关联sys_role_info 系统角色表',
  `resource_id` varchar(64) NOT NULL COMMENT '关联sys_resource 系统权限表',
  `del_flag` int(11) NOT NULL DEFAULT '1' COMMENT '用于记录的逻辑删除，0：删除，1：正常，默认为1\r\n            业务逻辑中：若DELETED_FLAG = 0为删除状态，则该记录一点不能被操作\r\n            ',
  `create_date` datetime NOT NULL COMMENT '创建时间，创建该记录的系统时间。',
  `create_by` varchar(64) NOT NULL COMMENT '创建人ID，为系统用户表中的当前登录用户ID。',
  `update_date` datetime DEFAULT NULL COMMENT '上一次修改该记录的时间，未修改过可以为空或为创建记录的时间。',
  `update_by` varchar(64) DEFAULT NULL COMMENT '最近一次修改该记录的用户ID，可以为空或为首次创建人的ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统默认角色权限表';

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` varchar(64) NOT NULL,
  `login_name` varchar(64) NOT NULL COMMENT '关联机构信息表ID',
  `nick_name` varchar(64) DEFAULT '0' COMMENT '上一级部门ID，关联本表ID字段，如为顶级则为0，默认为0',
  `icon` varchar(150) DEFAULT NULL COMMENT '保留字段',
  `password` varchar(64) DEFAULT NULL,
  `salt` varchar(30) DEFAULT NULL COMMENT '部门的简称',
  `tel` varchar(20) DEFAULT NULL COMMENT '简称字母表示',
  `email` varchar(150) DEFAULT NULL COMMENT '部门的图标，可以为空',
  `locked` varchar(150) NOT NULL DEFAULT '1' COMMENT '用于记录的逻辑删除，0：删除，1：正常，默认为1\r\n            业务逻辑中：若DELETED_FLAG = 0为删除状态，则该记录一点不能被操作\r\n            ',
  `del_flag` int(11) NOT NULL DEFAULT '1' COMMENT '用于记录的逻辑删除，0：删除，1：正常，默认为1\r\n            业务逻辑中：若DELETED_FLAG = 0为删除状态，则该记录一点不能被操作\r\n            ',
  `create_date` datetime NOT NULL COMMENT '创建时间，创建该记录的系统时间。',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建人ID，为系统用户表中的当前登录用户ID。',
  `update_date` datetime DEFAULT NULL COMMENT '上一次修改该记录的时间，未修改过可以为空或为创建记录的时间。',
  `remarks` varchar(150) DEFAULT NULL COMMENT '部门的简称',
  `update_by` varchar(64) DEFAULT NULL COMMENT '最近一次修改该记录的用户ID，可以为空或为首次创建人的ID',
  `org_id` varchar(64) DEFAULT NULL COMMENT '机构id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门信息表，为树结构定义。包括部门及下一级部门';

/*Table structure for table `sys_user_role_relation` */

DROP TABLE IF EXISTS `sys_user_role_relation`;

CREATE TABLE `sys_user_role_relation` (
  `id` varchar(64) NOT NULL,
  `user_id` varchar(64) NOT NULL COMMENT '此操作员为后台用户，关联用户信息表',
  `role_id` varchar(64) NOT NULL COMMENT '此操作员为后台用户，关联角色信息表',
  `del_flag` int(11) NOT NULL DEFAULT '1' COMMENT '用于记录的逻辑删除，0：删除，1：正常，默认为1\r\n            业务逻辑中：若DELETED_FLAG = 0为删除状态，则该记录一点不能被操作\r\n            ',
  `create_date` datetime NOT NULL COMMENT '创建时间，创建该记录的系统时间。',
  `create_by` varchar(64) NOT NULL COMMENT '创建人ID，为系统用户表中的当前登录用户ID。',
  `update_date` datetime DEFAULT NULL COMMENT '上一次修改该记录的时间，未修改过可以为空或为创建记录的时间。',
  `update_by` varchar(64) DEFAULT NULL COMMENT '最近一次修改该记录的用户ID，可以为空或为首次创建人的ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台操作员用户与角色关联表。';

/* Function  structure for function  `getProductCategoryName` */

/*!50003 DROP FUNCTION IF EXISTS `getProductCategoryName` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`cmm`@`%` FUNCTION `getProductCategoryName`(productId VARCHAR(64)) RETURNS varchar(64) CHARSET utf8
BEGIN
	DECLARE productCategoryName VARCHAR(64);
	SELECT 
		CONCAT(pc2.title,'/',pc1.title) INTO productCategoryName
	FROM 
		scm_product_info spi
	LEFT JOIN
		scm_product_category pc1
	ON
		spi.category_id = pc1.id
	LEFT JOIN
		scm_product_category pc2
	ON
		pc1.parent_id = pc2.id
	WHERE 
		spi.id = productId;
RETURN productCategoryName;
END */$$
DELIMITER ;

/* Function  structure for function  `getStaffName` */

/*!50003 DROP FUNCTION IF EXISTS `getStaffName` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`cmm`@`%` FUNCTION `getStaffName`(operatorId VARCHAR(64)) RETURNS varchar(64) CHARSET utf8
BEGIN
	DECLARE staffName VARCHAR(64);
	SELECT 
		os.staff_name INTO staffName
	FROM 
		pat_org_staff os,
		pat_org_staff_operator_relation osor
	WHERE
		os.deleted_flag = 0
	AND	
		osor.deleted_flag = 0
	AND
		os.id = osor.staff_id
	AND
		osor.operator_id = operatorId;
RETURN staffName;
END */$$
DELIMITER ;

/* Function  structure for function  `getWorkbenchUserName` */

/*!50003 DROP FUNCTION IF EXISTS `getWorkbenchUserName` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`cmm`@`%` FUNCTION `getWorkbenchUserName`(workbenchUserId VARCHAR(64),workbenchType INT) RETURNS varchar(64) CHARSET utf8
BEGIN
	DECLARE staffName VARCHAR(64);
	
	SELECT 
		os.staff_name INTO staffName
	FROM 
		pat_org_staff os,
		pat_org_staff_operator_relation osor,
		pat_org_operator oo
	WHERE
		os.deleted_flag = 0
	AND	
		osor.deleted_flag = 0
	AND
		oo.deleted_flag = 0
	AND
		os.id = osor.staff_id
	AND
		oo.id = osor.operator_id
	AND
		osor.operator_id = workbenchUserId
	AND
		oo.staff_type = workbenchType;
RETURN staffName;
END */$$
DELIMITER ;

/* Procedure structure for procedure `createDepartureCoordinate` */

/*!50003 DROP PROCEDURE IF EXISTS  `createDepartureCoordinate` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`cmm`@`%` PROCEDURE `createDepartureCoordinate`(IN departureRecordId VARCHAR(64),IN lat VARCHAR(64),IN lng VARCHAR(64))
begin
	
	INSERT INTO 
		scm_ship_departure_relation 
		(
			departure_record_id,
			lat,
			lng,
			created_time
		)
		values
		(
			departureRecordId,
			lat,
			lng,
			now()
		);
end */$$
DELIMITER ;

/* Procedure structure for procedure `emptyPurchaseAndWarehouseTable` */

/*!50003 DROP PROCEDURE IF EXISTS  `emptyPurchaseAndWarehouseTable` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`cmm`@`%` PROCEDURE `emptyPurchaseAndWarehouseTable`()
begin
		#DELETE FROM scm_product_purchase_price_history;#采购历史价格表
		DELETE FROM scm_purchase_accept_info;#采购收货信息
		DELETE FROM scm_purchase_order_details;#采购订单详情
		DELETE FROM scm_purchase_order_info;#采购订单
		DELETE FROM scm_purchase_order_request;#采购请购申请
		DELETE FROM scm_purchase_order_request_details;#采购请购申请详情
		DELETE FROM scm_purchase_order_request_process;#采购请购审批
		DELETE FROM scm_purchase_order_request_supplier_info;#采购请购申请供货信息(关联采购请购)
		DELETE FROM scm_package_details;#打包明细
		DELETE FROM scm_package_info;#打包信息
		DELETE FROM scm_sorting_details;#分拣明细
		DELETE FROM scm_sorting_schedule_info;#分拣排程
		DELETE FROM scm_stock_in_details;#入库明细表
		DELETE FROM scm_stock_in_info;#入库单信息表
		DELETE FROM scm_stock_out_details;#出库明细表
		DELETE FROM scm_stock_out_records;#出库单实体类
		
		#DELETE FROM scm_stock_info;#仓库
		#DELETE FROM scm_stock_category;#仓库类别
		#DELETE FROM scm_stock_storage_info;#仓位
		#DELETE FROM scm_stock_workbench;#工作台
		#DELETE FROM scm_device_info;#设备
		#DELETE FROM scm_workbench_device_relation;#工作台设备信息关联表
		DELETE FROM pat_problem_feedback;#问题反馈
end */$$
DELIMITER ;

/* Procedure structure for procedure `updateOrderStatus` */

/*!50003 DROP PROCEDURE IF EXISTS  `updateOrderStatus` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`cmm`@`%` PROCEDURE `updateOrderStatus`(IN orderId VARCHAR(255))
begin
	#订单明细总量
	DECLARE detailTotal INT;
	#换货总量
	DECLARE turnoverTotal INT;
	#换货完成数量
	DECLARE turnoverCompleteTotal INT;
	#退货总量
	DECLARE returnTotal INT;
	#退货完成数量
	DECLARE returnCompleteTotal INT;
	#订单状态
	DECLARE orderStatus INT;
	#如果orderId不为空,查询订单明细总量和退换货数量
	IF (orderId IS NOT NULL) THEN	
		SELECT COUNT(id) INTO detailTotal FROM scm_sales_order_details WHERE order_id = orderId;
		SELECT 
			COUNT(CASE method = 2 WHEN 1 THEN 1 END),
			COUNT(CASE method = 2 AND exchange_reach = 1 WHEN 1 THEN 1 END),
			COUNT(CASE method = 1 WHEN 1 THEN 1 END),
			COUNT(CASE method = 1 AND exchange_reach = 1 WHEN 1 THEN 1 END)
			INTO turnoverTotal,turnoverCompleteTotal,returnTotal,returnCompleteTotal
		FROM 
			scm_sales_returns_goods 
		WHERE 
			`status` != 3 
		AND
			`status` != 0	
		AND 
			order_id =  orderId;
		#如果退货总量和换货总量都大于0
			IF turnoverTotal > 0 && turnoverTotal = turnoverCompleteTotal && returnTotal > 0 && returnTotal = returnCompleteTotal THEN SET orderStatus = 1;
			#如果退货总量为0,并且换货完成数量大于0,并且换货总量等于换货完成数量
			ELSEIF returnTotal = 0 && turnoverCompleteTotal > 0 && turnoverTotal = turnoverCompleteTotal THEN SET orderStatus = 1;
			#如果换货总量为0,并且退货总量小于订单明细总量,并且退货总量等于退货完成数量
			ELSEIF turnoverTotal = 0 && returnTotal < detailTotal && returnTotal = returnCompleteTotal THEN SET orderStatus = 1;
			#如果换货总量为0,并且退货完成数量等于订单明细总量
			ELSEIF turnoverTotal = 0 && returnCompleteTotal = detailTotal THEN SET orderStatus = 5;
			END IF;
			#修改采购订单采购状态
			UPDATE 
				scm_sales_order
			SET
				`status` = orderStatus
			WHERE
				id = orderId;
	END IF;
end */$$
DELIMITER ;

/* Procedure structure for procedure `updatePurchaseOrderStatus` */

/*!50003 DROP PROCEDURE IF EXISTS  `updatePurchaseOrderStatus` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`cmm`@`%` PROCEDURE `updatePurchaseOrderStatus`(IN orderId VARCHAR(255))
begin
	#采购订单明细数量
	DECLARE countDetail INT;
	#已采购总量
	DECLARE countPurchase INT;
	#已收货总量
	DECLARE countAccept INT;
	#采购状态(1:待采购,2:采购中,3:待收货(已采购,采购app该订单全部确认采购),4:已收货(暂时不用)(打印批次条码))
	DECLARE procurementStatus INT;
	#如果orderId不为空,修改采购订单采购总数量
	IF (orderId IS NOT NULL) THEN
		UPDATE 
			scm_purchase_order_info 
		SET 
			final_sum = (SELECT sum(sum) FROM scm_purchase_accept_info WHERE order_id = orderId)
		WHERE
			id = orderId;
		
		#有采购收货版本
		#采购明细总量
		#SET countDetail = (SELECT COUNT(id) FROM scm_purchase_order_details WHERE order_id = orderId);
		#已采购总量,来源于采购收货表,有数据表示已采购
		#SET countPurchase = (SELECT COUNT(id) FROM scm_purchase_accept_info WHERE order_id = orderId);
		#已收货总量,判定标准为是否生成条码
		#SET countAccept = (SELECT COUNT(id) FROM scm_purchase_accept_info WHERE order_id = orderId AND batches_bar_code IS NOT NULL);
		
		#没有采购收货版本
		#采购明细总量
		SET countDetail = (SELECT COUNT(id) FROM scm_purchase_order_details WHERE order_id = orderId);
		# 已采购总量,判定标准为采购员已录入采购数量
		SET countPurchase = (SELECT COUNT(id) FROM scm_purchase_order_details WHERE order_id = orderId AND final_quantity IS NOT NULL);	
		#已收货(已生成入库单)总量,这里暂定为采购收货已生成入库单的总量
		#SET countAccept = (SELECT COUNT(id) FROM scm_purchase_accept_info WHERE order_id = orderId AND whether_create_stock_order = 1);
			#已采购数量为0,状态为待采购
			IF countPurchase = 0 THEN SET procurementStatus = 1;
			#已采购数量小于订单明细总量,并且已采购量大于0
			ELSEIF (countPurchase < countDetail) && (countPurchase > 0) THEN SET procurementStatus = 2;			
			
			#有采购收货版本
			#已采购数量等于订单明细总量,并且已收货数量小于总量
			#ELSEIF (countPurchase = countDetail) && (countAccept < countDetail) THEN SET procurementStatus = 3;
      #已采购数量等于订单明细总量,并且已收货数量等于总量
			#ELSEIF (countPurchase = countDetail) && (countAccept = countDetail) THEN SET procurementStatus = 4;
			#没有采购收货版本
			#已采购总量等于采购订单明细总量
			ELSEIF (countPurchase = countDetail) THEN SET procurementStatus = 3;
			END IF;
		#修改采购订单采购状态
		UPDATE 
			scm_purchase_order_info
		SET
			procurement_status = procurementStatus
		WHERE
			id = orderId;
	END IF;
end */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

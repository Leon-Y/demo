/*
Navicat MySQL Data Transfer

Source Server         : 172.16.9.5
Source Server Version : 50710
Source Host           : 172.16.9.5:4000
Source Database       : gddn_temp

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2018-10-26 17:07:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for id_gen
-- ----------------------------
DROP TABLE IF EXISTS `id_gen`;
CREATE TABLE `id_gen` (
  `GEN_KEY` varchar(100) NOT NULL COMMENT '主键KEY',
  `GEN_VALUE` int(11) NOT NULL COMMENT '主键',
  PRIMARY KEY (`GEN_KEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='主键表';

-- ----------------------------
-- Table structure for zhgd_chart
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_chart`;
CREATE TABLE `zhgd_chart` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `display_type` varchar(50) DEFAULT NULL COMMENT '图形控件类型，见标准编码定义',
  `title_text` varchar(200) DEFAULT NULL COMMENT '图形的标题文本',
  `subtitle_text` varchar(200) DEFAULT NULL COMMENT '图形的副标题字段名，从结果获取该字段值来显示',
  `syntax` text DEFAULT NULL COMMENT '图形对象数据查询SQL主体语句',
  `xaxis_category_field` varchar(50) DEFAULT NULL COMMENT '显示在x轴的字段名',
  `yaxis_title_text` varchar(200) DEFAULT NULL COMMENT 'y轴的标题文字',
  `tooltip_valuesuffix` varchar(50) DEFAULT NULL COMMENT '值显示的后缀',
  `name` varchar(200) DEFAULT NULL COMMENT '图形控件名称',
  `code` varchar(50) DEFAULT NULL COMMENT '图形控件代码，图形的唯一标识',
  `update_datetime` datetime DEFAULT NULL COMMENT '对象数据最后更改时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '对象数据最后更改人',
  `filter_syntax` text DEFAULT NULL COMMENT '图形对象数据查询SQL过滤语句',
  `xaxis_is_code` tinyint(4) DEFAULT NULL COMMENT '显示在x轴的字段名',
  `xaxis_code_group` varchar(50) DEFAULT NULL COMMENT '如果显示在x轴的值为代码，代码组别名',
  `db_name` varchar(50) DEFAULT NULL COMMENT '数据源名称（已移除替换为dataSourceType，可删除字段）',
  `subsystem_type` varchar(50) DEFAULT NULL COMMENT '子系统类型，如果使用的是子系统数据库',
  `yaxis_allow_decimals` tinyint(4) DEFAULT NULL COMMENT 'y轴是否允许小数',
  `realtime_enabled` tinyint(4) DEFAULT NULL COMMENT '是否开启实时更新',
  `realtime_interval` int(11) DEFAULT NULL COMMENT '实时更新时间间隔（秒）',
  `realtime_filter_syntax` text DEFAULT NULL COMMENT '实时更新的额外过滤语法',
  `legend_align` varchar(50) DEFAULT NULL COMMENT '图例水平对齐方式',
  `legend_vertical_align` varchar(50) DEFAULT NULL COMMENT '图例垂直对齐方式',
  `legend_x` int(11) DEFAULT NULL COMMENT '图例垂直x轴偏移量',
  `legend_y` int(11) DEFAULT NULL COMMENT '图例垂直y轴偏移量',
  `datasource_type` varchar(50) DEFAULT NULL COMMENT 'JNDI数据库的名称，如果使用的是本地数据库',
  `is_standardcode` tinyint(4) DEFAULT NULL COMMENT '是否用于标准编码',
  `view_name` varchar(50) DEFAULT NULL COMMENT '简单数据显示的视图名称',
  `is_pagination` tinyint(4) DEFAULT NULL COMMENT '是否分页显示',
  `is_allow_export` tinyint(4) DEFAULT NULL COMMENT '是否允许导出',
  `is_display_toolbar` tinyint(4) DEFAULT NULL COMMENT '简单数据显示的视图名称',
  `is_display_timebar` tinyint(4) DEFAULT NULL COMMENT '是否显示时间切换按钮',
  `timebar_format` varchar(50) DEFAULT NULL COMMENT '时间切换格式',
  `timebar_filter_fieldname` varchar(50) DEFAULT NULL COMMENT '时间切换对应过滤字段名',
  `timebar_interval` tinyint(4) DEFAULT NULL COMMENT '时间切换间隔',
  `inverted` tinyint(4) DEFAULT NULL COMMENT '是否反转',
  `x_type` varchar(50) DEFAULT NULL COMMENT 'x轴的类型',
  `x_dateformat` varchar(50) DEFAULT NULL COMMENT 'x轴时间格式',
  `is_external_view` tinyint(4) DEFAULT NULL COMMENT '是否外部视图',
  `description` varchar(200) DEFAULT NULL COMMENT '描述文字',
  `versions` varchar(200) DEFAULT NULL COMMENT '适用产品版本',
  `editor_name` varchar(50) DEFAULT NULL COMMENT '编辑用JSP View名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='图形控件表';

-- ----------------------------
-- Table structure for zhgd_chart_addon
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_chart_addon`;
CREATE TABLE `zhgd_chart_addon` (
  `id` int(11) NOT NULL,
  `chart_id` int(11) NOT NULL,
  `field` varchar(50) DEFAULT NULL COMMENT '图形控件数据项字段名，从结果集中取该字段',
  `update_datetime` datetime DEFAULT NULL COMMENT '对象数据最后更新时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '对象数据最后更改人',
  `addon_column_criteria` text DEFAULT NULL COMMENT '派生数据项显示条件',
  `addon_data_source` varchar(50) DEFAULT NULL COMMENT '派生数据项显示内容',
  `addon_data_source_params` text DEFAULT NULL COMMENT '派生数据项显示内容',
  `addon_column_content` text DEFAULT NULL COMMENT '派生数据项显示内容',
  `addon_data_source_type` varchar(50) DEFAULT NULL COMMENT '数据源类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='图形控件数据派生列';

-- ----------------------------
-- Table structure for zhgd_chart_data
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_chart_data`;
CREATE TABLE `zhgd_chart_data` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `chart_id` int(11) NOT NULL COMMENT '关联图形控件表外键',
  `name` varchar(100) DEFAULT NULL COMMENT '图形控件数据项名称',
  `field` varchar(50) DEFAULT NULL COMMENT '图形控件数据项字段名，从结果集中取该字段',
  `priority` int(11) DEFAULT NULL COMMENT '图形控件数据项优先级',
  `update_datetime` datetime DEFAULT NULL COMMENT '对象数据最后更新时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '对象数据最后更改人',
  `is_code` tinyint(4) DEFAULT NULL COMMENT '图形控件数据项字段值是否为代码',
  `code_group` varchar(50) DEFAULT NULL COMMENT '图形控件数据项字段值如果是代码，代码组别',
  `refer_feature_id` varchar(50) DEFAULT NULL COMMENT '关联的系统功能ID',
  `refer_param_name` varchar(50) DEFAULT NULL COMMENT '关联的系统功能需要传输的参数名，多个参数名用（,）分隔',
  `refer_field_name` varchar(50) DEFAULT NULL COMMENT '关联的系统功能需要传输的参数字段名，多个字段名用（,）分隔',
  `refer_display_type` varchar(50) DEFAULT NULL COMMENT '关联显示类型，Dialog, Navtab, Dev',
  `refer_display_width` int(11) DEFAULT NULL COMMENT '关联显示类型为Dialog时的宽度',
  `refer_display_height` int(11) DEFAULT NULL COMMENT '关联显示类型为Dialog时的高度',
  `color` varchar(50) DEFAULT NULL COMMENT '图形数据显示的颜色',
  `section` varchar(200) DEFAULT NULL COMMENT '数据显示区域，用于List类型显示归类数据',
  `suffix` varchar(50) DEFAULT NULL COMMENT '数据显示后缀，多维图形使用',
  `display_type` varchar(50) DEFAULT NULL COMMENT '数据显示类型，多维图形使用，column，line。。。',
  `yaxis_allow_decimals` tinyint(4) DEFAULT NULL COMMENT 'y轴是否允许小数，多维图形使用',
  `dash_style` varchar(50) DEFAULT NULL COMMENT '数据显示的虚实风格，见标准编码定义',
  `alignment_style` varchar(50) DEFAULT NULL COMMENT '数据显示的对齐风格，仅用于table类型',
  `has_line_point` tinyint(4) DEFAULT NULL COMMENT '线形图是否显示数据点',
  `is_addon_column` tinyint(4) DEFAULT NULL COMMENT '未使用，可删除',
  `addon_column_criteria` text DEFAULT NULL COMMENT '未使用，可删除',
  `addon_column_content` text DEFAULT NULL COMMENT '未使用，可删除',
  `size` varchar(50) DEFAULT NULL COMMENT '饼图显示圈的大小',
  `is_dimension` tinyint(4) DEFAULT NULL COMMENT '地图数据是否维度',
  `refer_display_target` varchar(50) DEFAULT NULL COMMENT '关联显示类型为Div时的目标窗口名字，不填则为本身窗口',
  `refer_close_parent` tinyint(4) DEFAULT NULL COMMENT '关联显示表格类型是否关闭父类窗口',
  `is_pivot` tinyint(4) DEFAULT NULL COMMENT '是否自动行转列',
  `pivot_pkf` varchar(50) DEFAULT NULL COMMENT '行转列主键',
  `pivot_fkf` varchar(50) DEFAULT NULL COMMENT '行转列外键',
  `pivot_param1` varchar(50) DEFAULT NULL COMMENT '行转列参数1',
  `pivot_param2` varchar(50) DEFAULT NULL COMMENT '行转列参数2',
  `pivot_param3` varchar(50) DEFAULT NULL COMMENT '行转列参数3',
  `pivot_param4` varchar(50) DEFAULT NULL COMMENT '行转列参数4',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='图形控件数据显示项';

-- ----------------------------
-- Table structure for zhgd_device
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_device`;
CREATE TABLE `zhgd_device` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `device_type` varchar(50) DEFAULT NULL COMMENT '设备类型，见标准编码定义',
  `device_status` varchar(50) DEFAULT NULL COMMENT '设备状态，见标准编码定义',
  `device_name` varchar(100) DEFAULT NULL COMMENT '设备名称',
  `group_code` varchar(50) DEFAULT NULL COMMENT '组织机构代码',
  `update_datetime` datetime DEFAULT NULL COMMENT '对象数据最后更改时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '对象数据最后更改人',
  `vendor_code` varchar(50) DEFAULT NULL COMMENT '供货商代码，见标准编码定义',
  `priority` int(11) DEFAULT NULL COMMENT '设备优先级',
  `system_id` int(11) DEFAULT NULL COMMENT '关联子系统表外键（一对多关系）',
  `connection_str` longtext DEFAULT NULL COMMENT '设备连接信息串',
  `position_x` float DEFAULT NULL COMMENT '位置X轴坐标',
  `position_y` float DEFAULT NULL COMMENT '位置Y轴坐标',
  `size` float DEFAULT NULL COMMENT '塔机的尺寸',
  `target_device_type` varchar(50) DEFAULT NULL COMMENT '目标设备类型，用于视频监控',
  `target_device_sn` varchar(50) DEFAULT NULL COMMENT '目标设备序列号，用于视频监控',
  `angel` int(11) DEFAULT NULL COMMENT '角度',
  `is_mater_device` tinyint(4) DEFAULT NULL COMMENT '是否主设备（用于水电表）',
  `electricity_ct` float DEFAULT NULL COMMENT '电表CT倍率',
  `electricity_pt` float DEFAULT NULL COMMENT '电表PT倍率',
  `is_only_location` tinyint(4) DEFAULT NULL COMMENT '是否仅是位置显示设备，非真实数据采集设备',
  `location_device_id` int(11) DEFAULT NULL COMMENT '位置显示设备ID,对于非位置显示设备有效',
  `cover_str` longtext DEFAULT NULL COMMENT '设备连接信息串',
  `device_sn` varchar(200) DEFAULT NULL COMMENT '设备序列号',
  `is_2d_sync` tinyint(4) DEFAULT NULL COMMENT '是否同步2维场景图',
  `is_3d_sync` tinyint(4) DEFAULT NULL COMMENT '是否同步3维场景图',
  `ccbim_point_id` varchar(50) DEFAULT NULL COMMENT 'CCBIM标注点ID',
  `is_external_sync` tinyint(4) DEFAULT NULL COMMENT '是否同步3维场景图',
  `external_sync_time` datetime DEFAULT NULL COMMENT '对象数据最后更改时间',
  `ccbim_point_json` longtext DEFAULT NULL COMMENT 'CCBIM标注点位置信息',
  `op_interval` int(11) DEFAULT NULL COMMENT '操作时间间隔（分）',
  `op_lasttime` datetime DEFAULT NULL COMMENT '上次操作时间',
  `op_nexttime` datetime DEFAULT NULL COMMENT '下次操作时间',
  `father_device_sn` varchar(50) DEFAULT NULL COMMENT '设备序列号（萤石云设备、配电箱设备）',
  `device_port` varchar(50) DEFAULT NULL COMMENT '设备端口',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='内部设备表';

-- ----------------------------
-- Table structure for zhgd_device_threshold
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_device_threshold`;
CREATE TABLE `zhgd_device_threshold` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `device_id` varchar(50) DEFAULT NULL COMMENT '关联设备表外键',
  `threshold_code` varchar(50) DEFAULT NULL COMMENT '阈值代码',
  `group_code` varchar(50) DEFAULT NULL COMMENT '组织机构代码',
  `update_datetime` datetime DEFAULT NULL COMMENT '对象数据最后更改时间',
  `threshold_name` varchar(200) DEFAULT NULL COMMENT '阈值名称',
  `update_user` varchar(50) DEFAULT NULL COMMENT '对象数据最后更改人',
  `threshold_value` varchar(200) DEFAULT NULL COMMENT '阈值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='设备阈值表';

-- ----------------------------
-- Table structure for zhgd_examination
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_examination`;
CREATE TABLE `zhgd_examination` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `group_code` varchar(50) DEFAULT NULL COMMENT '组织机构代码',
  `examination_name` varchar(100) DEFAULT NULL COMMENT '考试名称',
  `is_template` tinyint(4) DEFAULT NULL COMMENT '是否模板(1为模板，0不为模板)',
  `examination_type` tinyint(4) DEFAULT NULL COMMENT '是否顺序（顺序和无序）',
  `update_datetime` datetime DEFAULT NULL COMMENT '最后更改时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '最后更改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='考试表';

-- ----------------------------
-- Table structure for zhgd_feature
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_feature`;
CREATE TABLE `zhgd_feature` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `name` varchar(200) DEFAULT NULL COMMENT '系统功能名称',
  `priority` int(11) DEFAULT NULL COMMENT '系统功能优先级',
  `resources` longblob DEFAULT NULL COMMENT '系统功能所用到的资源，多个资源用逗号隔开',
  `access_point` varchar(200) DEFAULT NULL COMMENT '系统功能的访问入口地址',
  `is_open_access` tinyint(4) DEFAULT NULL COMMENT '是否开放访问的功能',
  `is_auto_grant` tinyint(4) DEFAULT NULL COMMENT '是否自动授权给全部登录用户',
  `subsystem_type` varchar(50) DEFAULT NULL COMMENT '相关的子系统类型，子系统功能必填',
  `update_datetime` datetime DEFAULT NULL COMMENT '对象数据最后更新时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '对象数据最后更改人',
  `icon` varchar(50) DEFAULT NULL COMMENT '系统功能显示图标',
  `is_subsystem_feature` int(11) DEFAULT NULL COMMENT '是否子系统功能，直接调用子系统页面，需要先登录子系统',
  `is_independent_page` tinyint(4) DEFAULT NULL COMMENT '是否DWZ独立功能，全HTML页面',
  `is_not_support_mobile` tinyint(4) DEFAULT NULL COMMENT '是否不支持手机',
  `mobile_icon` varchar(50) DEFAULT NULL COMMENT '手机版功能显示图标',
  `group_types` varchar(200) DEFAULT NULL COMMENT '功能适用的组织机构类型：企业 或 项目',
  `is_panel_component` tinyint(4) DEFAULT NULL COMMENT '是否DWZ独立功能，全HTML页面',
  `is_auto_manage` tinyint(4) DEFAULT NULL COMMENT '是否自动管理',
  `versions` varchar(200) DEFAULT NULL COMMENT '适用产品版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='系统功能对象表';

-- ----------------------------
-- Table structure for zhgd_filter
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_filter`;
CREATE TABLE `zhgd_filter` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `object_type` varchar(50) DEFAULT NULL COMMENT '过滤对象类型,见常量定义',
  `name` varchar(100) DEFAULT NULL COMMENT '过滤器名称',
  `update_datetime` datetime DEFAULT NULL COMMENT '最后更新时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '最后更改人',
  `syntax` text DEFAULT NULL COMMENT '过滤SQL语法',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='过滤器对象表';

-- ----------------------------
-- Table structure for zhgd_group
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_group`;
CREATE TABLE `zhgd_group` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `father_id` int(11) DEFAULT NULL COMMENT '上级组织机构ID',
  `group_code` varchar(50) DEFAULT NULL COMMENT '组织机构代码，唯一代码，系统自动生成',
  `name` varchar(200) DEFAULT NULL COMMENT '组织机构名称',
  `is_disabled` tinyint(4) DEFAULT NULL COMMENT '组织机构是否被禁用',
  `update_datetime` datetime DEFAULT NULL COMMENT '对象数据最后更改时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '对象数据最后更改人',
  `group_type` varchar(50) DEFAULT NULL COMMENT '组织机构类型 - 企业 或 项目',
  `area_province` varchar(50) DEFAULT NULL COMMENT '组织机构所属省',
  `area_city` varchar(50) DEFAULT NULL COMMENT '组织机构所属市',
  `area_county` varchar(50) DEFAULT NULL COMMENT '组织机构所属区县',
  `latitude` float DEFAULT NULL COMMENT '项目所在地维度',
  `longtitude` float DEFAULT NULL COMMENT '项目所在地经度',
  `map_xy` varchar(200) DEFAULT NULL COMMENT '项目所在地经维度字符串表述',
  `project_status` varchar(50) DEFAULT NULL COMMENT '项目当前状态，见标准编码定义',
  `project_budget` float DEFAULT NULL COMMENT '项目预算，万元',
  `project_cost` float DEFAULT NULL COMMENT '项目当前花费（万元）',
  `project_plan_start_time` datetime DEFAULT NULL COMMENT '项目计划开始时间',
  `project_plan_end_time` datetime DEFAULT NULL COMMENT '项目计划结束时间',
  `project_status_time` datetime DEFAULT NULL COMMENT '项目当前状态时间',
  `weight` int(11) DEFAULT NULL COMMENT '组织机构权重，每次进入组织机构权重+1',
  `project_area` float DEFAULT NULL COMMENT '项目面积（万平）',
  `project_water` float DEFAULT NULL COMMENT '组织机构用水量（项目概念）',
  `project_electricity` float DEFAULT NULL COMMENT '组织机构用电量（项目概念）',
  `version_num` varchar(50) DEFAULT NULL COMMENT '版本号码',
  `project_manager` varchar(50) DEFAULT NULL COMMENT '项目经理',
  `project_phone` varchar(50) DEFAULT NULL COMMENT '项目电话',
  `creator_group_id` int(11) DEFAULT NULL COMMENT '创建者Group id, 代理商或品茗',
  `expire_date` datetime DEFAULT NULL COMMENT '过期时间',
  `max_project_create` int(11) DEFAULT NULL COMMENT '最大可创建项目数',
  `max_depart_create` int(11) DEFAULT NULL COMMENT '最大可创建企业或部门数',
  `max_gov_create` int(11) DEFAULT NULL COMMENT '最大可创建政府机构数量',
  `supervisor_group_ids` varchar(200) DEFAULT NULL COMMENT '项目所管辖政府机构 Group Id',
  `owner_group_id` varchar(50) DEFAULT NULL COMMENT '项目所属企业Group Id',
  `zz_enterprice_code` varchar(50) DEFAULT NULL COMMENT '品茗通行证企业组织机构代码(桩桩企业号)',
  `zz_depart_code` varchar(50) DEFAULT NULL COMMENT '品茗通行证部门组织机构代码',
  `zz_project_code` varchar(50) DEFAULT NULL COMMENT '品茗通行证项目组织机构代码',
  `project_structure_type` varchar(50) DEFAULT NULL COMMENT '建筑结构类型 ',
  `project_owner_unit` varchar(100) DEFAULT NULL COMMENT '建设单位',
  `project_design_unit` varchar(100) DEFAULT NULL COMMENT '设计单位',
  `project_monitor_unit` varchar(100) DEFAULT NULL COMMENT '监理单位',
  `project_construction_unit` varchar(100) DEFAULT NULL COMMENT '施工单位',
  `project_safe_monitor_unit` varchar(100) DEFAULT NULL COMMENT '安全监督',
  `project_quality_monitor_unit` varchar(100) DEFAULT NULL COMMENT '质量监督',
  `scene_width` int(11) DEFAULT NULL COMMENT '2D场景图宽度',
  `scene_high` int(11) DEFAULT NULL COMMENT '2D场景图高度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='组织机构对象表';

-- ----------------------------
-- Table structure for zhgd_group_memo
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_group_memo`;
CREATE TABLE `zhgd_group_memo` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `group_id` int(11) DEFAULT NULL COMMENT '关联组织机构ID',
  `memo_time` datetime DEFAULT NULL COMMENT '新闻发生时间',
  `icon_image` varchar(200) DEFAULT NULL COMMENT '新闻标题图片地址',
  `subject` varchar(200) DEFAULT NULL COMMENT '新闻文字标题',
  `context` longtext DEFAULT NULL COMMENT '新闻内容文本',
  `type` varchar(50) DEFAULT NULL COMMENT '新闻类型：见标准代码定义',
  `attachment` varchar(200) DEFAULT NULL COMMENT '上传附件，为解决上传视频问题添加',
  `param1` varchar(50) DEFAULT NULL COMMENT '参数1（为解决行为榜星排序问题）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='项目新闻表';

-- ----------------------------
-- Table structure for zhgd_group_param
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_group_param`;
CREATE TABLE `zhgd_group_param` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `group_code` varchar(50) DEFAULT NULL COMMENT '组织机构代码',
  `group_param_code` varchar(50) DEFAULT NULL COMMENT '阈值代码',
  `group_param_min` float DEFAULT NULL COMMENT '阈值最小值',
  `group_param_max` float DEFAULT NULL COMMENT '阈值最大值',
  `group_param_unit` varchar(50) DEFAULT NULL COMMENT '阈值单位',
  `update_user` varchar(50) DEFAULT NULL COMMENT '维护人',
  `update_datetime` datetime DEFAULT NULL COMMENT '维护时间',
  `group_param_value` text DEFAULT NULL COMMENT '参数值',
  `group_param_value_memo` text DEFAULT NULL COMMENT '参数值说明',
  `group_param_value_diff` varchar(50) DEFAULT NULL COMMENT '参数值变化量',
  `group_param_value_pattern` varchar(50) DEFAULT NULL COMMENT '参数值格式',
  PRIMARY KEY (`id`),
  KEY `idx_param_code_code` (`group_code`,`group_param_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='组织机构阈值设置对象表';

-- ----------------------------
-- Table structure for zhgd_group_plan
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_group_plan`;
CREATE TABLE `zhgd_group_plan` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `group_code` varchar(50) DEFAULT NULL,
  `activity_name` text DEFAULT NULL COMMENT '工程名称',
  `plan_start_time` datetime DEFAULT NULL COMMENT '工程开始时间',
  `plan_end_time` datetime DEFAULT NULL COMMENT '工程结束时间',
  `plan_level` int(11) DEFAULT NULL COMMENT '工程任务级别',
  `duration` float DEFAULT NULL COMMENT '工期',
  `predecessors` varchar(200) DEFAULT NULL COMMENT '前置任务',
  `plan_type` varchar(50) DEFAULT NULL COMMENT '进度计划类型',
  `father_task_id` int(11) DEFAULT NULL COMMENT '上级任务ID',
  `task_id` int(11) DEFAULT NULL COMMENT '任务ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='项目工程的生产进度表';

-- ----------------------------
-- Table structure for zhgd_group_refer
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_group_refer`;
CREATE TABLE `zhgd_group_refer` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `group_code` varchar(50) DEFAULT NULL COMMENT '项目代码',
  `subsystem_group_code` varchar(50) DEFAULT NULL COMMENT '对应的子系统项目代码',
  `subsystem_id` int(11) DEFAULT NULL COMMENT '组织机构所关联的子系统ID',
  `update_datetime` datetime DEFAULT NULL COMMENT '最后更改时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '最后更改人',
  `param1` varchar(100) DEFAULT NULL COMMENT '附属参数1',
  `param2` varchar(100) DEFAULT NULL COMMENT '附属参数2',
  `param3` varchar(100) DEFAULT NULL COMMENT '附属参数3',
  `param4` varchar(100) DEFAULT NULL COMMENT '附属参数4',
  `subsystem_type` varchar(50) DEFAULT NULL COMMENT '组织机构所关联的子系统类型',
  `type` varchar(50) DEFAULT NULL COMMENT '机构授权类型',
  `interface_id` int(11) DEFAULT NULL COMMENT '关联接口表外键',
  `interface_key` varchar(50) DEFAULT NULL COMMENT '接口Key',
  `interface_secret` varchar(50) DEFAULT NULL COMMENT '接口Secret',
  `subsystem_datasource_type` varchar(50) DEFAULT NULL COMMENT '子系统数据源请求方式（0子系统数据源，1接口数据源）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='组织机构子系统参数对象表';

-- ----------------------------
-- Table structure for zhgd_group_service
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_group_service`;
CREATE TABLE `zhgd_group_service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `service_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=60060 COMMENT='组织机构与服务表关联关系表';

-- ----------------------------
-- Table structure for zhgd_group_status
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_group_status`;
CREATE TABLE `zhgd_group_status` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `group_code` varchar(50) NOT NULL COMMENT '组织机构ID，组织机构和组织机构状态为1:n。状态为每月新建一条',
  `status_datetime` datetime DEFAULT NULL COMMENT '状态发生时间',
  `status` varchar(50) DEFAULT NULL COMMENT '状态代码，见标准编码定义',
  `monthly_cost` float DEFAULT NULL COMMENT '项目月花费',
  `update_datetime` datetime DEFAULT NULL COMMENT '最近更改时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '最近更改人',
  `water` float DEFAULT NULL COMMENT '项目水表',
  `electricity` float DEFAULT NULL COMMENT '项目电表',
  `monthly_budget` float DEFAULT NULL COMMENT '项目产值 ',
  `monthly_approval` float DEFAULT NULL COMMENT '审批金额',
  `monthly_unpaid` float DEFAULT NULL COMMENT '未付金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='项目状态表';

-- ----------------------------
-- Table structure for zhgd_interface
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_interface`;
CREATE TABLE `zhgd_interface` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `name` varchar(200) DEFAULT NULL COMMENT '图形控件名称',
  `code` varchar(50) DEFAULT NULL COMMENT '图形控件代码，图形的唯一标识',
  `update_datetime` date DEFAULT NULL COMMENT '对象数据最后更改时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '对象数据最后更改人',
  `filter_syntax` longtext DEFAULT NULL COMMENT '过滤文本',
  `db_name` varchar(100) DEFAULT NULL COMMENT '未使用，可删除',
  `subsystem_type` varchar(50) DEFAULT NULL COMMENT '子系统类型，如果使用的是子系统数据库',
  `datasource_type` varchar(50) DEFAULT NULL COMMENT 'JNDI数据库的名称，如果使用的是本地数据库',
  `table_name` varchar(50) DEFAULT NULL COMMENT '接口对应表名称',
  `jdbc_type` varchar(50) DEFAULT NULL COMMENT '子系统数据库类型',
  `primary_keys` varchar(200) DEFAULT NULL COMMENT '上传文件主键名称字符串，以逗号相隔',
  `group_keys` varchar(200) DEFAULT NULL COMMENT ' 默认设置字段',
  `versions` varchar(200) DEFAULT NULL COMMENT '接口版本号（未使用，可删除）',
  `doc_url` varchar(200) DEFAULT NULL COMMENT '接口帮助文档地址',
  `foreign_keys` varchar(200) DEFAULT NULL COMMENT '外键约束，以逗号相隔',
  `effective_fields` varchar(200) DEFAULT NULL COMMENT '有效字段',
  `del_primary_conflict` tinyint(4) DEFAULT NULL COMMENT '主键冲突时是否自动删除',
  `is_custom` tinyint(4) DEFAULT NULL COMMENT '是否自定义查询接口',
  `custom_sql` text DEFAULT NULL COMMENT '自定义查询接口查询语句',
  `mandatory_keys` varchar(200) DEFAULT NULL COMMENT '必填约束',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='接口对象表';

-- ----------------------------
-- Table structure for zhgd_log
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_log`;
CREATE TABLE `zhgd_log` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `log_datetime` datetime DEFAULT NULL COMMENT '产生日志时间',
  `user_name` varchar(50) DEFAULT NULL COMMENT '操作员名称',
  `user_ip` varchar(50) DEFAULT NULL COMMENT '操作员IP',
  `user_device` varchar(100) DEFAULT NULL COMMENT '操作员设备',
  `server_ip` varchar(50) DEFAULT NULL COMMENT '服务器',
  `operation_type` varchar(50) DEFAULT NULL COMMENT '操作类型',
  `operation_class` varchar(200) DEFAULT NULL COMMENT '操作对象类别',
  `operation_object` varchar(200) DEFAULT NULL COMMENT '操作对象',
  `operation_result` longtext DEFAULT NULL COMMENT '操作结果',
  `operation_message` longtext DEFAULT NULL COMMENT '操作信息',
  `group_code` varchar(200) DEFAULT NULL COMMENT '组织机构代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='操作日志记录表';

-- ----------------------------
-- Table structure for zhgd_log_copy
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_log_copy`;
CREATE TABLE `zhgd_log_copy` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `log_datetime` datetime DEFAULT NULL COMMENT '产生日志时间',
  `user_name` varchar(50) DEFAULT NULL COMMENT '操作员名称',
  `user_ip` varchar(50) DEFAULT NULL COMMENT '操作员IP',
  `user_device` varchar(100) DEFAULT NULL COMMENT '操作员设备',
  `server_ip` varchar(50) DEFAULT NULL COMMENT '服务器',
  `operation_type` varchar(50) DEFAULT NULL COMMENT '操作类型',
  `operation_class` varchar(200) DEFAULT NULL COMMENT '操作对象类别',
  `operation_object` varchar(200) DEFAULT NULL COMMENT '操作对象',
  `operation_result` longtext DEFAULT NULL COMMENT '操作结果',
  `operation_message` longtext DEFAULT NULL COMMENT '操作信息',
  `group_code` varchar(200) DEFAULT NULL COMMENT '组织机构代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='操作日志记录表';

-- ----------------------------
-- Table structure for zhgd_page
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_page`;
CREATE TABLE `zhgd_page` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `name` varchar(100) DEFAULT NULL COMMENT '页面名称',
  `layout` varchar(50) DEFAULT NULL COMMENT '页面布局，见标准信息定义',
  `update_datetime` datetime DEFAULT NULL COMMENT '对象数据最后更改时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '对象数据最后更改人',
  `code` varchar(50) DEFAULT NULL COMMENT '页面代码，唯一',
  `direction` varchar(50) DEFAULT NULL COMMENT '页面布局方向，水平或垂直',
  `width` int(11) DEFAULT NULL COMMENT '页面宽度',
  `height` int(11) DEFAULT NULL COMMENT '页面高度',
  `css_class` varchar(50) DEFAULT NULL COMMENT '页面风格',
  `mobile_default_code` varchar(50) DEFAULT NULL COMMENT '手机风格',
  `group_code` varchar(50) DEFAULT NULL COMMENT '组织机构代码',
  `is_custom` tinyint(4) DEFAULT NULL COMMENT '是否机构定制',
  `layout_group_params` text DEFAULT NULL COMMENT '页面布局参数',
  `is_component` tinyint(4) DEFAULT NULL COMMENT '是否组件',
  `icon` varchar(50) DEFAULT NULL COMMENT '系统页面图标',
  `versions` varchar(200) DEFAULT NULL COMMENT '适用产品版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='页面对象表';

-- ----------------------------
-- Table structure for zhgd_panel
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_panel`;
CREATE TABLE `zhgd_panel` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `priority` int(11) DEFAULT NULL COMMENT '面板的优先级',
  `page_id` int(11) DEFAULT NULL COMMENT '页面表外键',
  `update_datetime` datetime DEFAULT NULL COMMENT '最后更改时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '最后更改人',
  `name` varchar(50) DEFAULT NULL COMMENT '面板名称',
  `line_height` varchar(10) DEFAULT NULL COMMENT '面板的高度百分比',
  `line_width` varchar(10) DEFAULT NULL COMMENT '面板的宽度百分比',
  `panel_text` longblob DEFAULT NULL COMMENT '面板的HTML内容，没有面板功能项ID时，显示该HTML',
  `feature_id` varchar(50) DEFAULT NULL COMMENT '关联功能表外键',
  `panel_code` varchar(50) DEFAULT NULL COMMENT '面板代码，全局唯一。是面板显示时的ID',
  `is_ignore_head` tinyint(4) DEFAULT NULL COMMENT '是否显示面板标题',
  `suggest_feature_id` varchar(50) DEFAULT NULL COMMENT '建议内容显示的系统功能ID（未使用，可删除）',
  `suggest_feature_width` int(11) DEFAULT NULL COMMENT '建议内容显示的系统功能宽度（未使用，可删除）',
  `suggest_feature_height` int(11) DEFAULT NULL COMMENT '建议内容显示的系统功能高度（未使用，可删除）',
  `suggest_feature_style` varchar(50) DEFAULT NULL COMMENT '建议内容显示的系统功能样式（未使用，可删除）',
  `right_margin` int(11) DEFAULT NULL COMMENT '面板右边距',
  `css_class` varchar(50) DEFAULT NULL COMMENT '页面风格',
  `is_dependent` tinyint(4) DEFAULT NULL COMMENT '是否独立面板（未使用，可删除）',
  `depend_panel_code` varchar(50) DEFAULT NULL COMMENT '独立面板代码（未使用，可删除）',
  `is_not_support_mobile` tinyint(4) DEFAULT NULL COMMENT '未定义，可删除',
  `is_open_in_mobile` tinyint(4) DEFAULT NULL COMMENT '未定义，可删除',
  `group_code` varchar(50) DEFAULT NULL COMMENT '组织机构代码',
  `is_custom` tinyint(4) DEFAULT NULL COMMENT '是否机构定制面板',
  `layout_group_no` int(11) DEFAULT NULL COMMENT '布局组件序号',
  `left_margin` int(11) DEFAULT NULL COMMENT '面板左边距',
  `top_margin` int(11) DEFAULT NULL COMMENT '面板上边距',
  `bottom_margin` int(11) DEFAULT NULL COMMENT '面板下边距',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='页面模板对象表';

-- ----------------------------
-- Table structure for zhgd_param
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_param`;
CREATE TABLE `zhgd_param` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `object_type` varchar(50) DEFAULT NULL COMMENT '参数所属对象的类型，见UserObject对象类型',
  `name` varchar(100) DEFAULT NULL COMMENT '参数名称',
  `section` varchar(100) DEFAULT NULL COMMENT '参数显示区域',
  `section_depend_param_name` varchar(100) DEFAULT NULL COMMENT '参数显示区域的依赖参数',
  `section_depend_param_value` varchar(100) DEFAULT NULL COMMENT '参数显示区域的依赖参数值',
  `param_name` varchar(100) DEFAULT NULL COMMENT '参数字段名，对应数据库',
  `param_default_value` text DEFAULT NULL COMMENT '参数缺省值',
  `param_value_pattern` varchar(100) DEFAULT NULL COMMENT '参数值格式的正则表达式',
  `priority` int(11) DEFAULT NULL COMMENT '参数优先级',
  `update_datetime` datetime DEFAULT NULL COMMENT '对象数据最近更改时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '对象数据最近更改人',
  `is_mandatory` int(11) DEFAULT NULL COMMENT '是否必需',
  `display_type` varchar(50) DEFAULT NULL COMMENT '参数显示类型，见标准代码定义',
  `dependency` varchar(100) DEFAULT NULL COMMENT '依赖参数',
  `prefix` varchar(50) DEFAULT NULL COMMENT '参数前缀',
  `suffix` varchar(50) DEFAULT NULL COMMENT '参数后缀',
  `object_id` int(11) DEFAULT NULL COMMENT '参数所属对象的ID',
  `param_alternative_value` text DEFAULT NULL COMMENT '参数第二缺省值，check类型，未选中时使用该值',
  `limitation_group` text DEFAULT NULL COMMENT '参数可选项的代码组，多个代码组用逗号隔开',
  `delimiter` varchar(50) DEFAULT NULL COMMENT '参数分隔符，多选参数值的分隔符',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='过滤器、排序器、图形数据等参数对象表';

-- ----------------------------
-- Table structure for zhgd_param_value
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_param_value`;
CREATE TABLE `zhgd_param_value` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `param_id` int(11) DEFAULT NULL COMMENT '关联过滤器、排序器、图形数据等参数对象表的外键',
  `param_value` text DEFAULT NULL COMMENT '参数值内容',
  `is_disabled` smallint(6) DEFAULT NULL COMMENT '是否无效',
  `update_datetime` datetime DEFAULT NULL COMMENT '对象数据最近更改时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '对象数据最近更改人',
  `key_value` varchar(50) DEFAULT NULL COMMENT '参数值主键，唯一',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='过滤器、排序器、图形数据等参数值对象表';

-- ----------------------------
-- Table structure for zhgd_role
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_role`;
CREATE TABLE `zhgd_role` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `role_code` varchar(50) DEFAULT NULL COMMENT '角色代码',
  `name` varchar(200) DEFAULT NULL COMMENT '角色名称',
  `update_datetime` datetime DEFAULT NULL COMMENT '对象数据最后修改时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '对象数据最后修改人',
  `need_menu_bar` tinyint(4) DEFAULT NULL COMMENT '是否需要显示DWZ的工具菜单',
  `priority` int(11) DEFAULT NULL COMMENT '角色优先级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色对象的数据模型';

-- ----------------------------
-- Table structure for zhgd_role_feature
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_role_feature`;
CREATE TABLE `zhgd_role_feature` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `role_id` int(11) NOT NULL COMMENT '角色表外键',
  `feature_id` int(11) NOT NULL COMMENT '功能表外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=63833 COMMENT='角色与功能中间表';

-- ----------------------------
-- Table structure for zhgd_role_page
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_role_page`;
CREATE TABLE `zhgd_role_page` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `role_id` int(11) DEFAULT NULL COMMENT '角色表外键',
  `version_num` varchar(50) DEFAULT NULL COMMENT '版本号',
  `page_code` varchar(50) DEFAULT NULL COMMENT '默认页面代码，页面表外键',
  `group_type` varchar(50) DEFAULT NULL COMMENT '组织机构类型',
  `update_user` varchar(50) DEFAULT NULL COMMENT '对象数据最后修改人',
  `update_datetime` datetime DEFAULT NULL COMMENT '对象数据最后修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色的默认页面';

-- ----------------------------
-- Table structure for zhgd_service
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_service`;
CREATE TABLE `zhgd_service` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `name` varchar(200) DEFAULT NULL COMMENT '服务项名称',
  `father_id` int(11) DEFAULT NULL COMMENT '上级服务项ID',
  `priority` int(11) DEFAULT NULL COMMENT '服务项优先级',
  `update_datetime` datetime DEFAULT NULL COMMENT '对象数据最近更改时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '对象数据最近更改人',
  `code` varchar(50) DEFAULT NULL COMMENT '服务代码，唯一代码，系统自动生成',
  PRIMARY KEY (`id`),
  KEY `INDEX_ZHGD_SERVICE_CODE` (`code`),
  KEY `INDEX_ZHGD_SERVICE_FATHER_ID` (`father_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='服务项目对象表';

-- ----------------------------
-- Table structure for zhgd_service_feature
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_service_feature`;
CREATE TABLE `zhgd_service_feature` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `service_id` int(11) NOT NULL COMMENT '关联服务表外键',
  `feature_id` char(10) NOT NULL COMMENT '关联功能表外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=90692 COMMENT='服务表与功能表关联关系表';

-- ----------------------------
-- Table structure for zhgd_smart_wifi
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_smart_wifi`;
CREATE TABLE `zhgd_smart_wifi` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `device_sn` varchar(50) DEFAULT NULL COMMENT '设备号',
  `device_name` varchar(200) DEFAULT NULL COMMENT '智能WiFi设备名',
  `update_datetime` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '修改人',
  `group_code` varchar(50) DEFAULT NULL COMMENT '组织机构代码',
  `test_code` varchar(50) DEFAULT NULL COMMENT '关联的考试代码',
  `res_download_time` datetime DEFAULT NULL COMMENT '资源下载时间',
  `is_real_identity` tinyint(4) DEFAULT NULL COMMENT '是否开启实名认证',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='智能WiFi表';

-- ----------------------------
-- Table structure for zhgd_sort
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_sort`;
CREATE TABLE `zhgd_sort` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `object_type` varchar(50) DEFAULT NULL COMMENT '排序器对象类型，见过滤器对象类型',
  `name` varchar(100) DEFAULT NULL COMMENT '排序器名称',
  `update_datetime` datetime DEFAULT NULL COMMENT '对象数据最近更改时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '对象数据最近更改人',
  `syntax` text DEFAULT NULL COMMENT '排序器语法',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='排序器对象表';

-- ----------------------------
-- Table structure for zhgd_standard_code
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_standard_code`;
CREATE TABLE `zhgd_standard_code` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `name` varchar(200) DEFAULT NULL COMMENT '标准代码名称',
  `value_local` varchar(200) DEFAULT NULL COMMENT '标准代码值，本类别',
  `father_id` int(11) DEFAULT NULL COMMENT '上级标准代码ID',
  `priority` int(11) DEFAULT NULL COMMENT '标准代码优先级',
  `update_datetime` datetime DEFAULT NULL COMMENT '对象数据最近更改时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '对象数据最近更改人',
  `param_1` varchar(200) DEFAULT NULL COMMENT '标准代码参数1',
  `param_2` varchar(200) DEFAULT NULL COMMENT '标准代码参数2',
  `param_3` varchar(200) DEFAULT NULL COMMENT '标准代码参数3',
  `param_4` varchar(200) DEFAULT NULL COMMENT '标准代码参数4',
  `chart_code` varchar(50) DEFAULT NULL COMMENT '关联图形控件表外键（动态数据源代码）',
  `is_chart_datasource` tinyint(4) DEFAULT NULL COMMENT '是否使用动态数据源',
  `value` varchar(400) DEFAULT NULL COMMENT '标准代码值，全局',
  PRIMARY KEY (`id`),
  KEY `INDEX_ZHGD_STANDARD_CODE_FATHER_ID` (`father_id`),
  KEY `INDEX_ZHGD_STANDARD_CODE_VALUE` (`value`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='标准编码对象表';

-- ----------------------------
-- Table structure for zhgd_subsystem
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_subsystem`;
CREATE TABLE `zhgd_subsystem` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `name` varchar(200) DEFAULT NULL COMMENT '子系统名称',
  `type` varchar(50) DEFAULT NULL COMMENT '子系统类型',
  `func_url` varchar(200) DEFAULT NULL COMMENT '子系统功能入口地址',
  `service_url` varchar(200) DEFAULT NULL COMMENT '子系统Web Service入口地址',
  `update_datetime` datetime DEFAULT NULL COMMENT '对象数据最近更改时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '对象数据最近更改人',
  `service_qname` varchar(200) DEFAULT NULL COMMENT '子系统Web Service的 QName',
  `code` varchar(50) DEFAULT NULL COMMENT '子系统代码',
  `subsystem_id` varchar(50) DEFAULT NULL COMMENT '子系统中的编号',
  `jdbc_url` varchar(100) DEFAULT NULL COMMENT '子系统数据库地址',
  `jdbc_user` varchar(50) DEFAULT NULL COMMENT '子系统数据库账户',
  `jdbc_pass` varchar(50) DEFAULT NULL COMMENT '子系统数据库密码',
  `jdbc_type` varchar(50) DEFAULT NULL COMMENT '子系统数据库类型',
  `is_sso_login` tinyint(4) DEFAULT NULL COMMENT '子系统是否SSO登录',
  `login_url` varchar(200) DEFAULT NULL COMMENT '外部子系统登录地址',
  `is_sync` tinyint(4) DEFAULT NULL COMMENT '是否需要和子系统同步账户信息',
  `is_external` tinyint(4) DEFAULT NULL COMMENT '是否外部子系统',
  `vendor` varchar(50) DEFAULT NULL COMMENT '子系统供应商，见标准编码',
  `subsystem_key` varchar(200) DEFAULT NULL COMMENT '子系统中的Key',
  `group_code` varchar(50) DEFAULT NULL COMMENT '组织机构代码',
  `is_interface` tinyint(4) DEFAULT NULL COMMENT '是否接口子系统',
  `versions` varchar(200) DEFAULT NULL COMMENT '适用产品版本',
  `is_allow_interface_grant` tinyint(4) DEFAULT NULL COMMENT '是否允许接口授权',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='子系统对象表';

-- ----------------------------
-- Table structure for zhgd_test
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_test`;
CREATE TABLE `zhgd_test` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `test_code` varchar(50) DEFAULT NULL COMMENT '试卷代码标志',
  `test_name` varchar(200) DEFAULT NULL COMMENT '试卷名称',
  `test_desc_url` varchar(200) DEFAULT NULL COMMENT '学习内容的URL',
  `update_datetime` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '修改人',
  `group_code` varchar(50) DEFAULT NULL COMMENT '组织机构代码',
  `question_num` int(11) DEFAULT NULL COMMENT '试卷的题目数量',
  `pass_score` int(11) DEFAULT NULL COMMENT '通过分数',
  `test_total_score` int(11) DEFAULT NULL COMMENT '试卷总分',
  `test_welcome_text` text DEFAULT NULL COMMENT '注册欢迎词',
  `priority` int(11) DEFAULT NULL COMMENT '优先级',
  `examination_id` int(11) DEFAULT NULL COMMENT '关联考试表外键',
  `is_template` tinyint(4) DEFAULT NULL COMMENT '是否模板试卷',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='考试试卷表';

-- ----------------------------
-- Table structure for zhgd_test_question
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_test_question`;
CREATE TABLE `zhgd_test_question` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `group_code` varchar(50) DEFAULT NULL COMMENT '组织机构代码',
  `question_text` text DEFAULT NULL COMMENT ' 考试题目',
  `question_score` int(11) DEFAULT NULL COMMENT '每题的分值',
  `test_code` varchar(50) DEFAULT NULL COMMENT '试卷代码标志',
  `update_datetime` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT ' 修改人',
  `question_type` varchar(50) DEFAULT NULL COMMENT '考题类型(1为单选;2为多选;3为判断题)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='试卷题目表';

-- ----------------------------
-- Table structure for zhgd_test_question_answer
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_test_question_answer`;
CREATE TABLE `zhgd_test_question_answer` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `question_id` int(11) DEFAULT NULL COMMENT '关联考题表外键',
  `answer_text` text DEFAULT NULL COMMENT '考试答案选项',
  `priority` int(11) DEFAULT NULL COMMENT '优先级',
  `is_correct` tinyint(4) DEFAULT NULL COMMENT '是否是正确答案',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='题目答案表';

-- ----------------------------
-- Table structure for zhgd_test_question_record
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_test_question_record`;
CREATE TABLE `zhgd_test_question_record` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `test_record_id` int(11) DEFAULT NULL COMMENT '关联考试结果详细表外键',
  `update_datetime` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '修改人',
  `question_id` int(11) DEFAULT NULL COMMENT '考试题目表ID',
  `question_answer_id` int(11) DEFAULT NULL COMMENT '考试题目答案表ID',
  `score` int(11) DEFAULT NULL COMMENT '本题得分',
  `result` varchar(50) DEFAULT NULL COMMENT '答题结果',
  `group_code` varchar(50) DEFAULT NULL COMMENT '组织机构代码',
  `question_answer_multi` varchar(150) DEFAULT NULL COMMENT '结果',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='考试系统答题详细信息表';

-- ----------------------------
-- Table structure for zhgd_test_record
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_test_record`;
CREATE TABLE `zhgd_test_record` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `tester_name` varchar(50) DEFAULT NULL COMMENT '考生姓名',
  `tester_work_type` varchar(50) DEFAULT NULL COMMENT '工种 ',
  `tester_phone` varchar(50) DEFAULT NULL COMMENT '手机号',
  `update_datetime` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '修改人',
  `test_score` int(11) DEFAULT NULL COMMENT '考试分数',
  `test_result` varchar(50) DEFAULT NULL COMMENT '考试结果',
  `test_code` varchar(50) DEFAULT NULL COMMENT '试卷代码标志',
  `group_code` varchar(50) DEFAULT NULL COMMENT '组织机构代码',
  `tester_unit_name` varchar(200) DEFAULT NULL COMMENT '劳务单位名称',
  `tester_card` varchar(50) DEFAULT NULL COMMENT '身份证号',
  `tester_address` varchar(200) DEFAULT NULL COMMENT ' 家庭住址',
  `examination_name` varchar(100) DEFAULT NULL COMMENT '考试名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='考试系统考试详细表';

-- ----------------------------
-- Table structure for zhgd_user
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_user`;
CREATE TABLE `zhgd_user` (
  `id` int(11) NOT NULL COMMENT '用户表主键',
  `name` varchar(200) DEFAULT NULL COMMENT '用户名，唯一',
  `password` varchar(200) DEFAULT NULL COMMENT '用户密码',
  `is_disabled` tinyint(4) DEFAULT NULL COMMENT '用户是否有效（用于删除用户）',
  `is_locked` tinyint(4) DEFAULT NULL COMMENT '账号是否封锁',
  `is_expired` tinyint(4) DEFAULT NULL COMMENT '账号是否过期',
  `default_role_code` varchar(50) DEFAULT NULL COMMENT '缺省角色代码，用于控制功能',
  `update_datetime` datetime DEFAULT NULL COMMENT '对象数据最后更改时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '对象数据最后更改人',
  `group_code` varchar(50) DEFAULT NULL COMMENT '所属组织机构代码',
  `original_password` varchar(200) DEFAULT NULL COMMENT '密码明码，用于子系统同步',
  `real_name` varchar(50) DEFAULT NULL COMMENT '真实名字',
  `gender` varchar(50) DEFAULT NULL COMMENT '性别',
  `id_no` varchar(50) DEFAULT NULL COMMENT '身份证号',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(50) DEFAULT NULL COMMENT '固话',
  `mobile` varchar(50) DEFAULT NULL COMMENT '手机号',
  `default_group_code` varchar(50) DEFAULT NULL COMMENT '缺省组织机构代码，用于浏览',
  `department_page_code` varchar(50) DEFAULT NULL COMMENT '企业主页面',
  `project_page_code` varchar(50) DEFAULT NULL COMMENT '项目主页面',
  `subsystem_user_id` varchar(50) DEFAULT NULL COMMENT '子系统中用户名',
  `memberNo` varchar(50) DEFAULT NULL COMMENT '桩桩号',
  `password_change_datetime` datetime DEFAULT NULL COMMENT '密码更改时间',
  `need_change_password` tinyint(4) DEFAULT NULL COMMENT '是否强制更改密码',
  `default_style` varchar(50) DEFAULT NULL COMMENT '缺省风格',
  `is_zz_user` tinyint(4) DEFAULT NULL COMMENT '是否品茗通行证用户',
  `zz_username` varchar(50) DEFAULT NULL COMMENT '桩桩用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户对象的数据模型';

-- ----------------------------
-- Table structure for zhgd_user_extend
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_user_extend`;
CREATE TABLE `zhgd_user_extend` (
  `id` int(11) NOT NULL COMMENT '用户扩展表主键',
  `member_id` char(32) DEFAULT NULL COMMENT '用户ID',
  `real_name` varchar(50) DEFAULT NULL COMMENT '真实名字',
  `default_role_code` varchar(50) DEFAULT NULL COMMENT '缺省角色代码，用于控制功能',
  `group_code` varchar(50) DEFAULT NULL COMMENT '所属组织机构代码',
  `original_password` varchar(200) DEFAULT NULL COMMENT '密码明码，用于子系统同步',
  `id_no` varchar(50) DEFAULT NULL COMMENT '身份证号',
  `default_group_code` varchar(50) DEFAULT NULL COMMENT '缺省组织机构代码，用于浏览',
  `department_page_code` varchar(50) DEFAULT NULL COMMENT '企业主页面',
  `project_page_code` varchar(50) DEFAULT NULL COMMENT '项目主页面',
  `subsystem_user_id` varchar(50) DEFAULT NULL COMMENT '子系统中用户名',
  `default_style` varchar(50) DEFAULT NULL COMMENT '缺省风格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户对象属性扩展表';

-- ----------------------------
-- Table structure for zhgd_user_object
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_user_object`;
CREATE TABLE `zhgd_user_object` (
  `id` int(11) NOT NULL COMMENT '唯一主键',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户数据所属用户名',
  `object_id` int(11) DEFAULT NULL COMMENT '用户对象ID',
  `object_type` varchar(50) DEFAULT NULL COMMENT '用户对象类型',
  `app_data` text DEFAULT NULL COMMENT '用户对象数据结果语句',
  `syntax` text DEFAULT NULL COMMENT '用户对象数据原始语句',
  `key_value` varchar(50) DEFAULT NULL COMMENT '用户对象数据主键，唯一。和ParamValue中对应',
  `indicate_time` datetime DEFAULT NULL COMMENT '记录时间字段（暂时无用，可删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户数据对象的数据模型';

-- ----------------------------
-- Table structure for zhgd_user_role
-- ----------------------------
DROP TABLE IF EXISTS `zhgd_user_role`;
CREATE TABLE `zhgd_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户表外键',
  `role_id` int(11) DEFAULT NULL COMMENT '角色表外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=60030 COMMENT='用户与角色中间表';

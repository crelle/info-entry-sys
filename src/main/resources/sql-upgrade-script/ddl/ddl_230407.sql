ALTER TABLE `t_menu`
CHANGE COLUMN `menu_sort` `menu_sort` VARCHAR(64) NOT NULL COMMENT '菜单排序标识' ,
ADD UNIQUE INDEX `menu_sort_UNIQUE` (`menu_sort` ASC);



drop table if exists t_asset;

/*==============================================================*/
/* Table: t_asset                                               */
/*==============================================================*/
create table t_asset
(
   asset_id             varchar(255) not null comment '主键',
   employee_id          varchar(255) comment '员工id',
   department_id        varchar(255) comment '部门id',
   asset_no             varchar(255) comment '资产编号',
   asset_serial_number  varchar(255) comment '资产序列号',
   asset_name           varchar(255) comment '资产名称',
   asset_status         bit(1) default 1 comment '资产状态',
   asset_value          varchar(255) comment '资产价值',
   asset_type           bit(1) comment '资产类型',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   create_by            varchar(255) comment '创建人',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   update_by            varchar(255) comment '修改人',
   enabled              bit(1) default 1 comment '账号是否可用，1可以，0不可用，默认1',
   primary key (asset_id)
);

alter table t_asset comment '资产表';


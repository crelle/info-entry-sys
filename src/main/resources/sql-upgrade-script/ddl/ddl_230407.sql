ALTER TABLE `t_menu`
CHANGE COLUMN `menu_sort` `menu_sort` VARCHAR(64) NOT NULL COMMENT '菜单排序标识' ,
ADD UNIQUE INDEX `menu_sort_UNIQUE` (`menu_sort` ASC);
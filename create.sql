create table menu (id bigint not null auto_increment, component varchar(255), enabled varchar(255), icon_ls varchar(255), keep_alive varchar(255), name varchar(255), parent_id bigint, path varchar(255), require_auth varchar(255), url varchar(255), primary key (id)) engine=InnoDB
create table role (id bigint not null auto_increment, name varchar(255), name_zh varchar(255), primary key (id)) engine=InnoDB
create table role_menu (role_id bigint not null, menu_id bigint not null, primary key (role_id, menu_id)) engine=InnoDB
create table user (id bigint not null auto_increment, account_non_expired bit, account_non_locked bit, credentails_non_expired bit, enabled bit, password varchar(255), user_email varchar(255), user_nick_name varchar(255), user_phone varchar(255), username varchar(255), primary key (id)) engine=InnoDB
create table user_role (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table menu add constraint FKgeupubdqncc1lpgf2cn4fqwbc foreign key (parent_id) references menu (id)
alter table role_menu add constraint FKfg4e2mb2318tph615gh44ll3 foreign key (menu_id) references menu (id)
alter table role_menu add constraint FKqyvxw2gg2qk0wld3bqfcb58vq foreign key (role_id) references role (id)
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id)
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id)
create table menu (id bigint not null auto_increment, component varchar(255), enabled varchar(255), icon_ls varchar(255), keep_alive varchar(255), name varchar(255), parent_id bigint, path varchar(255), require_auth varchar(255), url varchar(255), primary key (id)) engine=InnoDB
create table role (id bigint not null auto_increment, name varchar(255), name_zh varchar(255), primary key (id)) engine=InnoDB
create table role_menu (role_id bigint not null, menu_id bigint not null, primary key (role_id, menu_id)) engine=InnoDB
create table user (id bigint not null auto_increment, account_non_expired bit, account_non_locked bit, credentails_non_expired bit, enabled bit, password varchar(255), user_email varchar(255), user_nick_name varchar(255), user_phone varchar(255), username varchar(255), primary key (id)) engine=InnoDB
create table user_role (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table menu add constraint FKgeupubdqncc1lpgf2cn4fqwbc foreign key (parent_id) references menu (id)
alter table role_menu add constraint FKfg4e2mb2318tph615gh44ll3 foreign key (menu_id) references menu (id)
alter table role_menu add constraint FKqyvxw2gg2qk0wld3bqfcb58vq foreign key (role_id) references role (id)
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id)
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id)
create table menu (id bigint not null auto_increment, component varchar(255), enabled varchar(255), icon_ls varchar(255), keep_alive varchar(255), name varchar(255), parent_id bigint, path varchar(255), require_auth varchar(255), url varchar(255), primary key (id)) engine=InnoDB
create table role (id bigint not null auto_increment, name varchar(255), name_zh varchar(255), primary key (id)) engine=InnoDB
create table role_menu (role_id bigint not null, menu_id bigint not null, primary key (role_id, menu_id)) engine=InnoDB
create table user (id bigint not null auto_increment, account_non_expired bit, account_non_locked bit, credentails_non_expired bit, enabled bit, password varchar(255), user_email varchar(255), user_nick_name varchar(255), user_phone varchar(255), username varchar(255), primary key (id)) engine=InnoDB
create table user_role (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table menu add constraint FKgeupubdqncc1lpgf2cn4fqwbc foreign key (parent_id) references menu (id)
alter table role_menu add constraint FKfg4e2mb2318tph615gh44ll3 foreign key (menu_id) references menu (id)
alter table role_menu add constraint FKqyvxw2gg2qk0wld3bqfcb58vq foreign key (role_id) references role (id)
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id)
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id)
create table menu (id bigint not null auto_increment, component varchar(255), enabled varchar(255), icon_ls varchar(255), keep_alive varchar(255), name varchar(255), parent_id bigint, path varchar(255), require_auth varchar(255), url varchar(255), primary key (id)) engine=InnoDB
create table role (id bigint not null auto_increment, name varchar(255), name_zh varchar(255), primary key (id)) engine=InnoDB
create table role_menu (role_id bigint not null, menu_id bigint not null, primary key (role_id, menu_id)) engine=InnoDB
create table user (id bigint not null auto_increment, account_non_expired bit, account_non_locked bit, credentails_non_expired bit, enabled bit, password varchar(255), user_email varchar(255), user_nick_name varchar(255), user_phone varchar(255), username varchar(255), primary key (id)) engine=InnoDB
create table user_role (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table menu add constraint FKgeupubdqncc1lpgf2cn4fqwbc foreign key (parent_id) references menu (id)
alter table role_menu add constraint FKfg4e2mb2318tph615gh44ll3 foreign key (menu_id) references menu (id)
alter table role_menu add constraint FKqyvxw2gg2qk0wld3bqfcb58vq foreign key (role_id) references role (id)
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id)
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id)
create table menu (id bigint not null auto_increment, component varchar(255), enabled varchar(255), icon_ls varchar(255), keep_alive varchar(255), name varchar(255), parent_id bigint, path varchar(255), require_auth varchar(255), url varchar(255), primary key (id)) engine=InnoDB
create table role (id bigint not null auto_increment, name varchar(255), name_zh varchar(255), primary key (id)) engine=InnoDB
create table role_menu (role_id bigint not null, menu_id bigint not null, primary key (role_id, menu_id)) engine=InnoDB
create table user (id bigint not null auto_increment, account_non_expired bit, account_non_locked bit, credentails_non_expired bit, enabled bit, password varchar(255), user_email varchar(255), user_nick_name varchar(255), user_phone varchar(255), username varchar(255), primary key (id)) engine=InnoDB
create table user_role (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table menu add constraint FKgeupubdqncc1lpgf2cn4fqwbc foreign key (parent_id) references menu (id)
alter table role_menu add constraint FKfg4e2mb2318tph615gh44ll3 foreign key (menu_id) references menu (id)
alter table role_menu add constraint FKqyvxw2gg2qk0wld3bqfcb58vq foreign key (role_id) references role (id)
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id)
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id)
create table menu (id bigint not null auto_increment, component varchar(255), enabled varchar(255), icon_ls varchar(255), keep_alive varchar(255), name varchar(255), parent_id bigint, path varchar(255), require_auth varchar(255), url varchar(255), primary key (id)) engine=InnoDB
create table role (id bigint not null auto_increment, name varchar(255), name_zh varchar(255), primary key (id)) engine=InnoDB
create table role_menu (role_id bigint not null, menu_id bigint not null, primary key (role_id, menu_id)) engine=InnoDB
create table user (id bigint not null auto_increment, account_non_expired bit, account_non_locked bit, credentails_non_expired bit, enabled bit, password varchar(255), user_email varchar(255), user_nick_name varchar(255), user_phone varchar(255), username varchar(255), primary key (id)) engine=InnoDB
create table user_role (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table menu add constraint FKgeupubdqncc1lpgf2cn4fqwbc foreign key (parent_id) references menu (id)
alter table role_menu add constraint FKfg4e2mb2318tph615gh44ll3 foreign key (menu_id) references menu (id)
alter table role_menu add constraint FKqyvxw2gg2qk0wld3bqfcb58vq foreign key (role_id) references role (id)
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id)
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id)
create table menu (id bigint not null auto_increment, component varchar(255), enabled varchar(255), icon_ls varchar(255), keep_alive varchar(255), name varchar(255), parent_id bigint, path varchar(255), require_auth varchar(255), url varchar(255), primary key (id)) engine=InnoDB
create table role (id bigint not null auto_increment, name varchar(255), name_zh varchar(255), primary key (id)) engine=InnoDB
create table role_menu (role_id bigint not null, menu_id bigint not null, primary key (role_id, menu_id)) engine=InnoDB
create table user (id bigint not null auto_increment, account_non_expired bit, account_non_locked bit, credentails_non_expired bit, enabled bit, password varchar(255), user_email varchar(255), user_nick_name varchar(255), user_phone varchar(255), username varchar(255), primary key (id)) engine=InnoDB
create table user_role (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table menu add constraint FKgeupubdqncc1lpgf2cn4fqwbc foreign key (parent_id) references menu (id)
alter table role_menu add constraint FKfg4e2mb2318tph615gh44ll3 foreign key (menu_id) references menu (id)
alter table role_menu add constraint FKqyvxw2gg2qk0wld3bqfcb58vq foreign key (role_id) references role (id)
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id)
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id)
create table menu (id bigint not null auto_increment, component varchar(255), enabled varchar(255), icon_ls varchar(255), keep_alive varchar(255), name varchar(255), parent_id bigint, path varchar(255), require_auth varchar(255), url varchar(255), primary key (id)) engine=InnoDB
create table role (id bigint not null auto_increment, name varchar(255), name_zh varchar(255), primary key (id)) engine=InnoDB
create table role_menu (role_id bigint not null, menu_id bigint not null, primary key (role_id, menu_id)) engine=InnoDB
create table user (id bigint not null auto_increment, account_non_expired bit, account_non_locked bit, credentails_non_expired bit, enabled bit, password varchar(255), user_email varchar(255), user_nick_name varchar(255), user_phone varchar(255), username varchar(255), primary key (id)) engine=InnoDB
create table user_role (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table menu add constraint FKgeupubdqncc1lpgf2cn4fqwbc foreign key (parent_id) references menu (id)
alter table role_menu add constraint FKfg4e2mb2318tph615gh44ll3 foreign key (menu_id) references menu (id)
alter table role_menu add constraint FKqyvxw2gg2qk0wld3bqfcb58vq foreign key (role_id) references role (id)
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id)
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id)
create table menu (id bigint not null auto_increment, component varchar(255), enabled varchar(255), icon_ls varchar(255), keep_alive varchar(255), name varchar(255), parent_id bigint, path varchar(255), require_auth varchar(255), url varchar(255), primary key (id)) engine=InnoDB
create table role (id bigint not null auto_increment, name varchar(255), name_zh varchar(255), primary key (id)) engine=InnoDB
create table role_menu (role_id bigint not null, menu_id bigint not null, primary key (role_id, menu_id)) engine=InnoDB
create table user (id bigint not null auto_increment, account_non_expired bit, account_non_locked bit, credentails_non_expired bit, enabled bit, password varchar(255), user_email varchar(255), user_nick_name varchar(255), user_phone varchar(255), username varchar(255), primary key (id)) engine=InnoDB
create table user_role (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table menu add constraint FKgeupubdqncc1lpgf2cn4fqwbc foreign key (parent_id) references menu (id)
alter table role_menu add constraint FKfg4e2mb2318tph615gh44ll3 foreign key (menu_id) references menu (id)
alter table role_menu add constraint FKqyvxw2gg2qk0wld3bqfcb58vq foreign key (role_id) references role (id)
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id)
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id)
create table menu (id bigint not null auto_increment, component varchar(255), enabled varchar(255), icon_ls varchar(255), keep_alive varchar(255), name varchar(255), parent_id bigint, path varchar(255), require_auth varchar(255), url varchar(255), primary key (id)) engine=InnoDB
create table role (id bigint not null auto_increment, name varchar(255), name_zh varchar(255), primary key (id)) engine=InnoDB
create table role_menu (role_id bigint not null, menu_id bigint not null, primary key (role_id, menu_id)) engine=InnoDB
create table user (id bigint not null auto_increment, account_non_expired bit, account_non_locked bit, credentails_non_expired bit, enabled bit, password varchar(255), user_email varchar(255), user_nick_name varchar(255), user_phone varchar(255), username varchar(255), primary key (id)) engine=InnoDB
create table user_role (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table menu add constraint FKgeupubdqncc1lpgf2cn4fqwbc foreign key (parent_id) references menu (id)
alter table role_menu add constraint FKfg4e2mb2318tph615gh44ll3 foreign key (menu_id) references menu (id)
alter table role_menu add constraint FKqyvxw2gg2qk0wld3bqfcb58vq foreign key (role_id) references role (id)
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id)
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id)
create table menu (id bigint not null auto_increment, component varchar(255), enabled varchar(255), icon_ls varchar(255), keep_alive varchar(255), name varchar(255), parent_id bigint, path varchar(255), require_auth varchar(255), url varchar(255), primary key (id)) engine=InnoDB
create table role (id bigint not null auto_increment, name varchar(255), name_zh varchar(255), primary key (id)) engine=InnoDB
create table role_menu (role_id bigint not null, menu_id bigint not null, primary key (role_id, menu_id)) engine=InnoDB
create table user (id bigint not null auto_increment, account_non_expired bit, account_non_locked bit, credentails_non_expired bit, enabled bit, password varchar(255), user_email varchar(255), user_nick_name varchar(255), user_phone varchar(255), username varchar(255), primary key (id)) engine=InnoDB
create table user_role (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table menu add constraint FKgeupubdqncc1lpgf2cn4fqwbc foreign key (parent_id) references menu (id)
alter table role_menu add constraint FKfg4e2mb2318tph615gh44ll3 foreign key (menu_id) references menu (id)
alter table role_menu add constraint FKqyvxw2gg2qk0wld3bqfcb58vq foreign key (role_id) references role (id)
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id)
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id)
create table menu (id bigint not null auto_increment, component varchar(255), enabled varchar(255), icon_ls varchar(255), keep_alive varchar(255), name varchar(255), parent_id bigint, path varchar(255), require_auth varchar(255), url varchar(255), primary key (id)) engine=InnoDB
create table role (id bigint not null auto_increment, name varchar(255), name_zh varchar(255), primary key (id)) engine=InnoDB
create table role_menu (role_id bigint not null, menu_id bigint not null, primary key (role_id, menu_id)) engine=InnoDB
create table user (id bigint not null auto_increment, account_non_expired bit, account_non_locked bit, credentails_non_expired bit, enabled bit, password varchar(255), user_email varchar(255), user_nick_name varchar(255), user_phone varchar(255), username varchar(255), primary key (id)) engine=InnoDB
create table user_role (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table menu add constraint FKgeupubdqncc1lpgf2cn4fqwbc foreign key (parent_id) references menu (id)
alter table role_menu add constraint FKfg4e2mb2318tph615gh44ll3 foreign key (menu_id) references menu (id)
alter table role_menu add constraint FKqyvxw2gg2qk0wld3bqfcb58vq foreign key (role_id) references role (id)
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id)
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id)
create table menu (id bigint not null auto_increment, component varchar(255), enabled varchar(255), icon_ls varchar(255), keep_alive varchar(255), name varchar(255), parent_id bigint, path varchar(255), require_auth varchar(255), url varchar(255), primary key (id)) engine=InnoDB
create table role (id bigint not null auto_increment, name varchar(255), name_zh varchar(255), primary key (id)) engine=InnoDB
create table role_menu (role_id bigint not null, menu_id bigint not null, primary key (role_id, menu_id)) engine=InnoDB
create table user (id bigint not null auto_increment, account_non_expired bit, account_non_locked bit, credentails_non_expired bit, enabled bit, password varchar(255), user_email varchar(255), user_nick_name varchar(255), user_phone varchar(255), username varchar(255), primary key (id)) engine=InnoDB
create table user_role (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table menu add constraint FKgeupubdqncc1lpgf2cn4fqwbc foreign key (parent_id) references menu (id)
alter table role_menu add constraint FKfg4e2mb2318tph615gh44ll3 foreign key (menu_id) references menu (id)
alter table role_menu add constraint FKqyvxw2gg2qk0wld3bqfcb58vq foreign key (role_id) references role (id)
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id)
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id)
create table menu (id bigint not null auto_increment, component varchar(255), enabled varchar(255), icon_ls varchar(255), keep_alive varchar(255), name varchar(255), parent_id bigint, path varchar(255), require_auth varchar(255), url varchar(255), primary key (id)) engine=InnoDB
create table role (id bigint not null auto_increment, name varchar(255), name_zh varchar(255), primary key (id)) engine=InnoDB
create table role_menu (role_id bigint not null, menu_id bigint not null, primary key (role_id, menu_id)) engine=InnoDB
create table user (id bigint not null auto_increment, account_non_expired bit, account_non_locked bit, credentails_non_expired bit, enabled bit, password varchar(255), user_email varchar(255), user_nick_name varchar(255), user_phone varchar(255), username varchar(255), primary key (id)) engine=InnoDB
create table user_role (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table menu add constraint FKgeupubdqncc1lpgf2cn4fqwbc foreign key (parent_id) references menu (id)
alter table role_menu add constraint FKfg4e2mb2318tph615gh44ll3 foreign key (menu_id) references menu (id)
alter table role_menu add constraint FKqyvxw2gg2qk0wld3bqfcb58vq foreign key (role_id) references role (id)
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id)
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id)
create table menu (id bigint not null auto_increment, component varchar(255), enabled varchar(255), icon_ls varchar(255), keep_alive varchar(255), name varchar(255), parent_id bigint, path varchar(255), require_auth varchar(255), url varchar(255), primary key (id)) engine=InnoDB
create table role (id bigint not null auto_increment, name varchar(255), name_zh varchar(255), primary key (id)) engine=InnoDB
create table role_menu (role_id bigint not null, menu_id bigint not null, primary key (role_id, menu_id)) engine=InnoDB
create table user (id bigint not null auto_increment, account_non_expired bit, account_non_locked bit, credentails_non_expired bit, enabled bit, password varchar(255), user_email varchar(255), user_nick_name varchar(255), user_phone varchar(255), username varchar(255), primary key (id)) engine=InnoDB
create table user_role (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table menu add constraint FKgeupubdqncc1lpgf2cn4fqwbc foreign key (parent_id) references menu (id)
alter table role_menu add constraint FKfg4e2mb2318tph615gh44ll3 foreign key (menu_id) references menu (id)
alter table role_menu add constraint FKqyvxw2gg2qk0wld3bqfcb58vq foreign key (role_id) references role (id)
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id)
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id)

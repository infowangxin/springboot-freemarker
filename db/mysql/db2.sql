drop table if exists `t_news`;
create table `t_news` (
  `id` varchar(255) not null,
  `address` varchar(255) default null,
  `create_time` datetime default null,
  `description` varchar(255) default null,
  `news_time` datetime default null,
  `title` varchar(255) default null,
  primary key (`id`)
) engine=innodb default charset=utf8mb4;

insert into t_news(id,address,create_time,description,news_time,title) values('2018052000000000001','测试多数据源2',now(),'测试多数据源2',now(),'测试多数据源2');
create table t_news (
	id varchar not null,
	address varchar,
	create_time timestamp,
	description varchar,
	news_time timestamp,
	title varchar,
	primary key (id)
);

insert into t_news(id,address,create_time,description,news_time,title) values('2018052000000000001','测试多数据源2',datetime('now'),'测试多数据源2',datetime('now'),'测试多数据源2');

select * from t_news;
/*
 Navicat Premium Data Transfer

 Source Server         : db1
 Source Server Type    : SQLite
 Source Server Version : 3008008
 Source Database       : main

 Target Server Type    : SQLite
 Target Server Version : 3008008
 File Encoding         : utf-8

 Date: 05/20/2018 12:15:00 PM
*/

PRAGMA foreign_keys = false;

-- ----------------------------
--  Table structure for t_news
-- ----------------------------
DROP TABLE IF EXISTS "t_news";
CREATE TABLE t_news (
	id varchar not null,
	address varchar,
	create_time timestamp,
	description varchar,
	news_time timestamp,
	title varchar,
	primary key (id)
);

-- ----------------------------
--  Records of t_news
-- ----------------------------
BEGIN;
INSERT INTO "t_news" VALUES (2018052000000000001, '测试多数据源1', X'323031382d30352d32302030333a33353a3530', '测试多数据源1', X'323031382d30352d32302030333a33353a3530', '测试多数据源1');
COMMIT;

-- ----------------------------
--  Table structure for t_sys_permission
-- ----------------------------
DROP TABLE IF EXISTS "t_sys_permission";
CREATE TABLE t_sys_permission (
  id varchar not null ,
  name varchar ,
  css_class varchar ,
  url varchar ,
  skey varchar ,
  parent_key varchar ,
  hide int(11) ,
  lev int(11) ,
  sort int(11) ,
  primary key (id)
);

-- ----------------------------
--  Records of t_sys_permission
-- ----------------------------
BEGIN;
INSERT INTO "t_sys_permission" VALUES (182827778310418432, '管理首页', 'fa-home', 'index', 'glsy', null, 1, 1, 1);
INSERT INTO "t_sys_permission" VALUES (182827778503356416, '站内新闻', '', null, 'znxy', null, 1, 1, 10);
INSERT INTO "t_sys_permission" VALUES (182827778541105152, '新闻发布', '', 'news/add', 'znxy_xwfb', 'znxy', 1, 2, 11);
INSERT INTO "t_sys_permission" VALUES (182827778570465280, '新闻列表', '', 'news/list', 'znxy_xwlb', 'znxy', 1, 2, 12);
INSERT INTO "t_sys_permission" VALUES (182827778620796928, '默认数据库', '', 'news/list', 'znxy_mrsjk', 'znxy', 1, 2, 13);
INSERT INTO "t_sys_permission" VALUES (182827778671128576, '数据库1', '', 'news/list1', 'znxy_sjk1', 'znxy', 1, 2, 14);
INSERT INTO "t_sys_permission" VALUES (182827778721460224, '数据库2', '', 'news/list2', 'znxy_sjk2', 'znxy', 1, 2, 15);
INSERT INTO "t_sys_permission" VALUES (182827778759208960, '系统配置', 'fa-gear', 'view/sysconfig/setconfig', 'xtpz', null, 1, 1, 20);
INSERT INTO "t_sys_permission" VALUES (182827778792763392, '电商管理', 'fa-desktop', 'view/tenant/tenant-list', 'dxgl', null, 1, 1, 30);
INSERT INTO "t_sys_permission" VALUES (182827778843095040, '电商配置', 'fa-gears', 'view/tenantConfig/list', 'dspz', null, 1, 1, 40);
INSERT INTO "t_sys_permission" VALUES (182827778880843776, '地区城市管理', 'fa-map-marker', null, 'dccsgl', null, 1, 1, 50);
INSERT INTO "t_sys_permission" VALUES (182827778914398208, '添加城市', null, 'view/city/add2', 'dccsgl_tjcs', 'dccsgl', 1, 2, 51);
INSERT INTO "t_sys_permission" VALUES (182827778956341248, '城市列表', null, 'view/city/list', 'dccsgl_cslb', 'dccsgl', 1, 2, 51);
INSERT INTO "t_sys_permission" VALUES (182827779006672896, '账号管理', 'fa-user', 'view/user/user_list', 'chgl', null, 1, 1, 60);
INSERT INTO "t_sys_permission" VALUES (182827779057004544, '楼盘管理', 'fa-building', 'view/project/list', 'lpgl', null, 1, 1, 70);
INSERT INTO "t_sys_permission" VALUES (182827779111530496, '开通楼盘', 'fa-plus', 'view/project/openProject', 'lpgl_ktlp', 'lpgl', 1, 2, 71);
INSERT INTO "t_sys_permission" VALUES (182827779166056448, '楼盘审核', 'fa-pencil', 'view/project/list', 'lpgl_lpsh', 'lpgl', 1, 2, 72);
INSERT INTO "t_sys_permission" VALUES (182827779212193792, '楼盘管理', 'fa-building', 'view/project/manager_list', 'lpgl_lpgl', 'lpgl', 1, 2, 73);
INSERT INTO "t_sys_permission" VALUES (182827779254136832, '合作楼盘', 'fa-slideshare', 'view/project/edit_list', 'lpgl_hzlp', 'lpgl', 1, 2, 74);
INSERT INTO "t_sys_permission" VALUES (182827779296079872, '添加楼盘', 'fa-plus', 'view/project/add', 'lpgl_tjlp', 'lpgl', 1, 2, 75);
INSERT INTO "t_sys_permission" VALUES (182827779329634304, '基本信息', 'fa-file-text-o', 'view/project/add', 'lpgl_tjlp_jbxx', 'lpgl_tjlp', 1, 3, 76);
INSERT INTO "t_sys_permission" VALUES (182827779388354560, '户型管理', 'fa-puzzle-piece', 'view/project/add2', 'lpgl_tjlp_hxgl', 'lpgl_tjlp', 1, 3, 77);
INSERT INTO "t_sys_permission" VALUES (182827779430297600, '楼盘相册', 'fa-picture-o', 'view/project/add3', 'lpgl_tjlp_lpxc', 'lpgl_tjlp', 1, 3, 78);
INSERT INTO "t_sys_permission" VALUES (182827779476434944, '销控管理', 'fa-sort-numeric-asc', 'view/project/add4', 'lpgl_tjlp_xkgl', 'lpgl_tjlp', 1, 3, 79);
INSERT INTO "t_sys_permission" VALUES (182827779543543808, '合作信息', 'fa-slideshare', 'view/project/add5', 'lpgl_tjlp_hzxx', 'lpgl_tjlp', 1, 3, 80);
INSERT INTO "t_sys_permission" VALUES (182827779593875456, '产品维护', 'fa-share-alt', 'view/project/add6', 'lpgl_tjlp_cpwh', 'lpgl_tjlp', 1, 3, 81);
INSERT INTO "t_sys_permission" VALUES (182827779631624192, '拥金维护', 'fa-dollar', 'view/project/add7', 'lpgl_tjlp_rjwh', 'lpgl_tjlp', 1, 3, 82);
INSERT INTO "t_sys_permission" VALUES (182827779669372928, '楼盘动态', 'fa-list-alt', 'view/project/add8', 'lpgl_tjlp_lpdt', 'lpgl_tjlp', 1, 3, 83);
INSERT INTO "t_sys_permission" VALUES (182827779719704576, '优惠活动', 'fa-heart', 'view/project/add9', 'lpgl_tjlp_yhhd', 'lpgl_tjlp', 1, 3, 84);
INSERT INTO "t_sys_permission" VALUES (182827779765841920, '经济公司/经纪人', 'fa-group', null, 'jjgsjjr', null, 1, 1, 90);
INSERT INTO "t_sys_permission" VALUES (182827779807784960, '经纪公司维护', 'fa-vine', 'view/firm/list', 'jjgsjjr_jjgswh', 'jjgsjjr', 1, 2, 91);
INSERT INTO "t_sys_permission" VALUES (182827779845533696, '经纪人管理', 'fa-group', 'view/agent/list', 'jjgsjjr_jjrgl', 'jjgsjjr', 1, 2, 92);
INSERT INTO "t_sys_permission" VALUES (182827779879088128, '经纪人实名认证', 'fa-newspaper-o', 'view/agent/list', 'jjgsjjr_jjrsmrz', 'jjgsjjr', 1, 2, 93);
INSERT INTO "t_sys_permission" VALUES (182827779925225472, '经纪人银行卡认证', 'fa-credit-card', 'view/agent/list', 'jjgsjjr_jjryhkrz', 'jjgsjjr', 1, 2, 94);
INSERT INTO "t_sys_permission" VALUES (182827779962974208, '置业顾问管理', 'fa-user-md', null, 'zygwgl', null, 1, 1, 100);
INSERT INTO "t_sys_permission" VALUES (182827780004917248, '置业顾问挂靠审核', 'fa-stumbleupon', 'view/adviserProject/adviserAuditList', 'zygwgl_zygwgksh', 'zygwgl', 1, 2, 101);
INSERT INTO "t_sys_permission" VALUES (182827780042665984, '置业顾问管理', 'fa-user-md', 'view/adviser/list', 'zygwgl_zygwgl', 'zygwgl', 1, 2, 102);
INSERT INTO "t_sys_permission" VALUES (182827780080414720, '置业顾问实名认证', 'fa-newspaper-o', 'view/agent/list', 'zygwgl_zygwsmrz', 'zygwgl', 1, 2, 103);
INSERT INTO "t_sys_permission" VALUES (182827780118163456, '置业顾问银行卡认证', 'fa-credit-card', 'view/agent/list', 'zygwgl_zygwyhkrz', 'zygwgl', 1, 2, 104);
INSERT INTO "t_sys_permission" VALUES (182827780189466624, '置业顾问元宝提现', 'fa-database', 'view/agent/list', 'zygwgl_zygwybtx', 'zygwgl', 1, 2, 105);
INSERT INTO "t_sys_permission" VALUES (182827780243992576, 'POS交易管理', 'fa-credit-card', null, 'posjygl', null, 1, 1, 110);
INSERT INTO "t_sys_permission" VALUES (182827780285935616, 'POS机绑定', 'fa-unlock-alt', 'view/pos/bind', 'posjygl_posjbd', 'posjygl', 1, 2, 111);
INSERT INTO "t_sys_permission" VALUES (182827780340461568, 'POS绑定信息', 'fa-link', 'view/pos/list', 'posjygl_posbdxx', 'posjygl', 1, 2, 112);
INSERT INTO "t_sys_permission" VALUES (182827780403376128, 'POS交易信息', 'fa-legal', 'view/pos/poslog', 'posjygl_posjyxx', 'posjygl', 1, 2, 113);
INSERT INTO "t_sys_permission" VALUES (182827780453707776, '数据统计', 'fa-pie-chart', null, 'sjtj', null, 1, 1, 120);
INSERT INTO "t_sys_permission" VALUES (182827780495650816, '用户统计', 'fa-user', 'view/data/statIncome_data', 'sjtj_yhtj', 'sjtj', 1, 2, 121);
INSERT INTO "t_sys_permission" VALUES (182827780533399552, '客户统计', 'fa-group', 'view/data/statIncome_data', 'sjtj_khtj', 'sjtj', 1, 2, 122);
INSERT INTO "t_sys_permission" VALUES (182827780579536896, '收入统计', 'fa-line-chart', 'view/data/statIncome_data', 'sjtj_sytj', 'sjtj', 1, 2, 123);
INSERT INTO "t_sys_permission" VALUES (182827780621479936, '佣金统计', 'fa-pie-chart', 'view/data/statIncome_data', 'sjtj_yjtj', 'sjtj', 1, 2, 124);
INSERT INTO "t_sys_permission" VALUES (182827780671811584, '合同管理', 'fa-edit', null, 'htgl', null, 1, 1, 130);
INSERT INTO "t_sys_permission" VALUES (182827780726337536, '添加/管理列表', 'fa-plus', 'view/agreement/list', 'htgl_tjgllb', 'htgl', 1, 2, 131);
INSERT INTO "t_sys_permission" VALUES (182827780789252096, '转认购', 'fa-mail-forward', 'view/agreement/rengou', 'htgl_zrg', 'htgl', 1, 2, 132);
INSERT INTO "t_sys_permission" VALUES (182827780831195136, '签约', 'fa-check-square-o', 'view/agreement/qianyue', 'htgl_qy', 'htgl', 1, 2, 133);
INSERT INTO "t_sys_permission" VALUES (182827780868943872, '合同明细/编辑', 'fa-edit', 'view/agreement/edit', 'htgl_htmxbj', 'htgl', 1, 2, 134);
INSERT INTO "t_sys_permission" VALUES (182827780923469824, '合同详情', 'fa-building-o', 'view/agreement/view', 'htgl_htxq', 'htgl', 1, 2, 135);
INSERT INTO "t_sys_permission" VALUES (182827780965412864, '总经理', 'fa-sitemap', null, 'zjl', null, 1, 1, 140);
INSERT INTO "t_sys_permission" VALUES (182827781007355904, '客户统计', 'fa-group', 'view/data/statIncome_data', 'zjl_khtj', 'zjl', 1, 2, 141);
INSERT INTO "t_sys_permission" VALUES (182827781045104640, '收入统计', 'fa-line-chart', 'view/data/statIncome_data', 'zjl_sytj', 'zjl', 1, 2, 143);
INSERT INTO "t_sys_permission" VALUES (182827781082853376, '佣金统计', 'fa-pie-chart', 'view/data/statIncome_data', 'zjl_yjtj', 'zjl', 1, 2, 144);
INSERT INTO "t_sys_permission" VALUES (182827781137379328, '经济公司管理员', 'fa-sitemap', null, 'jjgsgly', null, 1, 1, 150);
INSERT INTO "t_sys_permission" VALUES (182827781196099584, '合作', 'fa-slideshare', 'view/firm/verify', 'jjgsgly_hz', 'jjgsgly', 1, 2, 151);
INSERT INTO "t_sys_permission" VALUES (182827781233848320, '门店列表', 'fa-slideshare', 'view/firm/list2', 'jjgsgly_mdlb', 'jjgsgly', 1, 2, 152);
INSERT INTO "t_sys_permission" VALUES (182827781275791360, '账号管理', 'fa-slideshare', 'view/user/user_list', 'jjgsgly_zhgl', 'jjgsgly', 1, 2, 153);
INSERT INTO "t_sys_permission" VALUES (182827781317734400, '挂靠审核', 'fa-slideshare', 'view/firm/verify', 'jjgsgly_ghsh', 'jjgsgly', 1, 2, 154);
INSERT INTO "t_sys_permission" VALUES (182827781351288832, '对公账号', 'fa-slideshare', 'view/firm/view', 'jjgsgly_dgzh', 'jjgsgly', 1, 2, 155);
INSERT INTO "t_sys_permission" VALUES (182827781389037568, '经纪人列表', 'fa-slideshare', 'view/agent/list', 'jjgsgly_jjrlb', 'jjgsgly', 1, 2, 156);
INSERT INTO "t_sys_permission" VALUES (182827781422592000, '客户列表', 'fa-slideshare', 'view/agent/custAgent', 'jjgsgly_khlb', 'jjgsgly', 1, 2, 157);
INSERT INTO "t_sys_permission" VALUES (182827781464535040, '佣金信息', 'fa-slideshare', 'view/commission/agentCommission', 'jjgsgly_yjxx', 'jjgsgly', 1, 2, 158);
INSERT INTO "t_sys_permission" VALUES (182827781498089472, '额外佣金', 'fa-slideshare', 'view/commission/commissionExt', 'jjgsgly_ewyj', 'jjgsgly', 1, 2, 159);
INSERT INTO "t_sys_permission" VALUES (182827781548421120, '客户统计', 'fa-group', 'view/data/statIncome_data', 'jjgsgly_khtj', 'jjgsgly', 1, 2, 160);
INSERT INTO "t_sys_permission" VALUES (182827781598752768, '收入统计', 'fa-line-chart', 'view/data/statIncome_data', 'jjgsgly_sytj', 'jjgsgly', 1, 2, 161);
INSERT INTO "t_sys_permission" VALUES (182827781636501504, '佣金统计', 'fa-pie-chart', 'view/data/statIncome_data', 'jjgsgly_yjtj', 'jjgsgly', 1, 2, 162);
INSERT INTO "t_sys_permission" VALUES (182827781686833152, '门店管理员', 'fa-sitemap', null, 'mdgly', null, 1, 1, 170);
INSERT INTO "t_sys_permission" VALUES (182827781741359104, '挂靠审核', 'fa-slideshare', 'view/firm/verify', 'mdgly_ghsh', 'mdgly', 1, 2, 171);
INSERT INTO "t_sys_permission" VALUES (182827781779107840, '经纪人列表', 'fa-slideshare', 'view/agent/list', 'mdgly_jjrlb', 'mdgly', 1, 2, 172);
INSERT INTO "t_sys_permission" VALUES (182827781829439488, '客户列表', 'fa-slideshare', 'view/agent/custAgent', 'mdgly_khlb', 'mdgly', 1, 2, 173);
INSERT INTO "t_sys_permission" VALUES (182827781871382528, '用户统计', 'fa-user', 'view/data/statIncome_data', 'mdgly_yhtj2', 'mdgly', 1, 2, 174);
INSERT INTO "t_sys_permission" VALUES (182827781913325568, '用户统计', 'fa-user', 'view/data/statIncome_data', 'mdgly_yhtj3', 'mdgly', 1, 2, 175);
INSERT INTO "t_sys_permission" VALUES (182827781959462912, '用户统计', 'fa-user', 'view/data/statIncome_data', 'mdgly_yhtj4', 'mdgly', 1, 2, 176);
INSERT INTO "t_sys_permission" VALUES (182827782009794560, '客户统计', 'fa-group', 'view/data/statIncome_data', 'mdgly_khtj', 'mdgly', 1, 2, 177);
INSERT INTO "t_sys_permission" VALUES (182827782047543296, '案场经理', 'fa-sitemap', null, 'acjl', null, 1, 1, 180);
INSERT INTO "t_sys_permission" VALUES (182827782081097728, '楼盘管理', null, null, 'acjl_lpgl', 'acjl', 1, 2, 181);
INSERT INTO "t_sys_permission" VALUES (182827782118846464, '楼盘列表', null, 'view/project/list', 'acjl_lpgl_lpgl', 'acjl_lpgl', 1, 3, 182);
INSERT INTO "t_sys_permission" VALUES (182827782156595200, '编辑添加', null, 'view/project/add', 'acjl_lpgl_bjtj', 'acjl_lpgl', 1, 3, 183);
INSERT INTO "t_sys_permission" VALUES (182827782190149632, '置业顾问挂靠审核', 'fa-stumbleupon', 'view/adviserProject/adviserAuditList', 'acjl_zygwgksh', 'acjl', 1, 2, 184);
INSERT INTO "t_sys_permission" VALUES (182827782223704064, '置业顾问管理', 'fa-user-md', 'view/adviser/list', 'acjl_zygwgl', 'acjl', 1, 2, 185);
INSERT INTO "t_sys_permission" VALUES (182827782257258496, '客户审核', null, 'view/custintent/custAuditList', 'acjl_khsh', 'acjl', 1, 2, 186);
INSERT INTO "t_sys_permission" VALUES (182827782299201536, '项目总监', null, null, 'xmzj', null, 1, 1, 190);
INSERT INTO "t_sys_permission" VALUES (182827782336950272, '客户统计', 'fa-group', 'view/data/statIncome_data', 'xmzj_khtj', 'xmzj', 1, 2, 191);
INSERT INTO "t_sys_permission" VALUES (182827782378893312, '收入统计', 'fa-line-chart', 'view/data/statIncome_data', 'xmzj_sytj', 'xmzj', 1, 2, 192);
INSERT INTO "t_sys_permission" VALUES (182827782416642048, '佣金统计', 'fa-pie-chart', 'view/data/statIncome_data', 'xmzj_yjtj', 'xmzj', 1, 2, 193);
INSERT INTO "t_sys_permission" VALUES (182827782471168000, '项目经理', 'fa-sitemap', null, 'xmjl', null, 1, 1, 200);
INSERT INTO "t_sys_permission" VALUES (182827782508916736, '开通楼盘', 'fa-plus', 'view/project/openProject', 'xmjl_ktlp', 'xmjl', 1, 2, 201);
INSERT INTO "t_sys_permission" VALUES (182827782546665472, '账号管理', 'fa-slideshare', 'view/user/user_list', 'xmjl_zhgl', 'xmjl', 1, 2, 202);
INSERT INTO "t_sys_permission" VALUES (182827782584414208, '佣金审核', null, 'view/commission/list', 'xmjl_yjsh', 'xmjl', 1, 2, 203);
INSERT INTO "t_sys_permission" VALUES (182827782622162944, '开发商补贴', null, 'view/devpSubsidy/list', 'xmjl_kfsbt', 'xmjl', 1, 2, 204);
INSERT INTO "t_sys_permission" VALUES (182827782668300288, '推送管理', null, 'view/push/list', 'xmjl_tsgl', 'xmjl', 1, 2, 205);
INSERT INTO "t_sys_permission" VALUES (182827782710243328, '客户统计', 'fa-group', 'view/data/statIncome_data', 'xmjl_khtj', 'xmjl', 1, 2, 206);
INSERT INTO "t_sys_permission" VALUES (182827782752186368, '收入统计', 'fa-line-chart', 'view/data/statIncome_data', 'xmjl_sytj', 'xmjl', 1, 2, 207);
INSERT INTO "t_sys_permission" VALUES (182827782785740800, '佣金统计', 'fa-pie-chart', 'view/data/statIncome_data', 'xmjl_yjtj', 'xmjl', 1, 2, 208);
INSERT INTO "t_sys_permission" VALUES (182827782823489536, '项目助理', 'fa-sitemap', null, 'xmzl', null, 1, 1, 210);
INSERT INTO "t_sys_permission" VALUES (182827782882209792, '确认到访', null, 'view/code/code', 'xmzl_qrdf', 'xmzl', 1, 2, 211);
INSERT INTO "t_sys_permission" VALUES (182827782924152832, '发送语音验证码', null, 'view/code/telcode', 'xmzl_fsyyyzm', 'xmzl', 1, 2, 212);
INSERT INTO "t_sys_permission" VALUES (182827782957707264, 'POS机绑定', 'fa-unlock-alt', 'view/pos/bind', 'xmzl_posjbd', 'xmzl', 1, 2, 213);
INSERT INTO "t_sys_permission" VALUES (182827782991261696, 'POS交易记录', 'fa-link', 'view/pos/list', 'xmzl_posbdxx', 'xmzl', 1, 2, 214);
INSERT INTO "t_sys_permission" VALUES (182827783045787648, '客户意向查询', null, 'view/custintent/custAuditList', 'xmzl_khyxqx', 'xmzl', 1, 2, 215);
INSERT INTO "t_sys_permission" VALUES (182827783083536384, '合同管理', null, 'view/agreement/list', 'xmzl_htgl', 'xmzl', 1, 2, 216);
INSERT INTO "t_sys_permission" VALUES (182827783117090816, '运营专员', 'fa-sitemap', null, 'yyzy', null, 1, 1, 220);
INSERT INTO "t_sys_permission" VALUES (182827783154839552, '签到规则配置', null, 'view/sysconfig/signin', 'yyzy_qdgzpz', 'yyzy', 1, 2, 221);
INSERT INTO "t_sys_permission" VALUES (182827783188393984, '楼盘管理', 'fa-building', 'view/project/manager_list', 'yyzy_lpgl', 'yyzy', 1, 2, 222);
INSERT INTO "t_sys_permission" VALUES (182827783230337024, '城市管理', null, 'view/city/add2', 'yyzy_tjcs', 'yyzy', 1, 2, 223);
INSERT INTO "t_sys_permission" VALUES (182827783289057280, '账号管理', 'fa-slideshare', 'view/user/user_list', 'yyzy_zhgl', 'yyzy', 1, 2, 224);
INSERT INTO "t_sys_permission" VALUES (182827783335194624, '推送管理', null, 'view/push/list', 'yyzy_tsgl', 'yyzy', 1, 2, 225);
INSERT INTO "t_sys_permission" VALUES (182827783381331968, '广告位管理', null, 'view/adv/list', 'yyzy_ggwgl', 'yyzy', 1, 2, 226);
INSERT INTO "t_sys_permission" VALUES (182827783419080704, '客户意向查询', null, 'view/custintent/custAuditList', 'yyzy_khyxqx', 'yyzy', 1, 2, 227);
INSERT INTO "t_sys_permission" VALUES (182827783477800960, 'POS机绑定', 'fa-unlock-alt', 'view/pos/bind', 'yyzy_posjbd', 'yyzy', 1, 2, 228);
INSERT INTO "t_sys_permission" VALUES (182827783519744000, 'POS交易记录', 'fa-link', 'view/pos/list', 'yyzy_posjyjl', 'yyzy', 1, 2, 229);
INSERT INTO "t_sys_permission" VALUES (182827783561687040, '签约经纪公司', null, 'view/pos/list', 'yyzy_qyjjgs', 'yyzy', 1, 2, 230);
INSERT INTO "t_sys_permission" VALUES (182827783599435776, '经纪人管理', 'fa-group', 'view/agent/list', 'yyzy_jjrgl', 'yyzy', 1, 2, 231);
INSERT INTO "t_sys_permission" VALUES (182827783653961728, '用户统计', 'fa-user', 'view/data/statIncome_data', 'yyzy_yhtj', 'yyzy', 1, 2, 232);
INSERT INTO "t_sys_permission" VALUES (182827783708487680, '客户统计', 'fa-group', 'view/data/statIncome_data', 'yyzy_khtj', 'yyzy', 1, 2, 233);
INSERT INTO "t_sys_permission" VALUES (182827783746236416, '收入统计', 'fa-line-chart', 'view/data/statIncome_data', 'yyzy_sytj', 'yyzy', 1, 2, 234);
INSERT INTO "t_sys_permission" VALUES (182827783783985152, '佣金统计', 'fa-pie-chart', 'view/data/statIncome_data', 'yyzy_yjtj', 'yyzy', 1, 2, 235);
INSERT INTO "t_sys_permission" VALUES (182827783821733888, '佣金专员', 'fa-sitemap', null, 'yjzy', null, 1, 1, 240);
INSERT INTO "t_sys_permission" VALUES (182827783872065536, '佣金规则审核', null, 'view/commission/auditList', 'yjzy_yjgzsh', 'yjzy', 1, 2, 241);
INSERT INTO "t_sys_permission" VALUES (182827783909814272, '经纪人实名认证', 'fa-newspaper-o', 'view/agent/list', 'yjzy_jjrsmrz', 'yjzy', 1, 2, 242);
INSERT INTO "t_sys_permission" VALUES (182827783943368704, '经纪人银行卡认证', 'fa-credit-card', 'view/agent/list', 'yjzy_jjryhkrz', 'yjzy', 1, 2, 243);
INSERT INTO "t_sys_permission" VALUES (182827783981117440, '经纪人元宝提现', 'fa-credit-card', 'view/agent/grain', 'yjzy_jjrybtx', 'yjzy', 1, 2, 244);
INSERT INTO "t_sys_permission" VALUES (182827784014671872, '置业顾问实名认证', 'fa-newspaper-o', 'view/agent/list', 'yjzy_zygwsmrz', 'yjzy', 1, 2, 245);
INSERT INTO "t_sys_permission" VALUES (182827784060809216, '置业顾问银行卡认证', 'fa-credit-card', 'view/agent/list', 'yjzy_zygwyhkrz', 'yjzy', 1, 2, 246);
INSERT INTO "t_sys_permission" VALUES (182827784115335168, '置业顾问元宝提现', 'fa-database', 'view/agent/list', 'yjzy_zygwybtx', 'yjzy', 1, 2, 247);
INSERT INTO "t_sys_permission" VALUES (182827784161472512, '对公账号审核', 'fa-database', 'view/firm/account', 'yjzy_dgzhsh', 'yjzy', 1, 2, 248);
INSERT INTO "t_sys_permission" VALUES (182827784211804160, '退款审核', null, 'view/refund/list', 'yjzy_tksh', 'yjzy', 1, 2, 249);
INSERT INTO "t_sys_permission" VALUES (182827784257941504, '佣金审核', null, 'view/commission/list', 'yjzy_yjsh', 'yjzy', 1, 2, 250);
INSERT INTO "t_sys_permission" VALUES (182827784295690240, '合同管理', null, 'view/agreement/list', 'yjzy_htgl', 'yjzy', 1, 2, 251);
INSERT INTO "t_sys_permission" VALUES (182827784341827584, '额外佣金审核', null, 'view/commission/Ext', 'yjzy_ewyjsh', 'yjzy', 1, 2, 252);
INSERT INTO "t_sys_permission" VALUES (182827784400547840, '出纳专员', 'fa-sitemap', null, 'cnzy', null, 1, 1, 260);
INSERT INTO "t_sys_permission" VALUES (182827784476045312, '经纪人元宝提现', 'fa-credit-card', 'view/agent/grain', 'cnzy_jjrybtx', 'cnzy', 1, 2, 261);
INSERT INTO "t_sys_permission" VALUES (182827784530571264, '置业顾问元宝提现', 'fa-database', 'view/agent/list', 'cnzy_zygwybtx', 'cnzy', 1, 2, 262);
INSERT INTO "t_sys_permission" VALUES (182827784606068736, '退款审核', null, 'view/refund/list', 'cnzy_tksh', 'cnzy', 1, 2, 263);
INSERT INTO "t_sys_permission" VALUES (182827784648011776, '佣金审核', null, 'view/commission/list', 'cnzy_yjsh', 'cnzy', 1, 2, 264);
INSERT INTO "t_sys_permission" VALUES (182827784706732032, '额外佣金审核', null, 'view/commission/Ext', 'cnzy_ewyjsh', 'cnzy', 1, 2, 265);
INSERT INTO "t_sys_permission" VALUES (182827784752869376, '财务专员', null, null, 'cwzy', null, 1, 1, 270);
INSERT INTO "t_sys_permission" VALUES (182827784794812416, '经纪人元宝提现', 'fa-credit-card', 'view/agent/grain', 'cwzy_jjrybtx', 'cwzy', 1, 2, 271);
INSERT INTO "t_sys_permission" VALUES (182827784840949760, '置业顾问元宝提现', 'fa-database', 'view/agent/list', 'cwzy_zygwybtx', 'cwzy', 1, 2, 272);
INSERT INTO "t_sys_permission" VALUES (182827784882892800, '开发商补贴确认', null, 'view/devpSubsidy/list2', 'cwzy_kfsbt', 'cwzy', 1, 2, 273);
INSERT INTO "t_sys_permission" VALUES (182827784958390272, '退款审核', null, 'view/refund/list', 'cwzy_tksh', 'cwzy', 1, 2, 274);
INSERT INTO "t_sys_permission" VALUES (182827785008721920, '佣金审核', null, 'view/commission/list', 'cwzy_yjsh', 'cwzy', 1, 2, 275);
INSERT INTO "t_sys_permission" VALUES (182827785054859264, 'POS交易记录', 'fa-link', 'view/pos/list', 'cwzy_posbdxx', 'cwzy', 1, 2, 276);
INSERT INTO "t_sys_permission" VALUES (182827785113579520, '额外佣金审核', null, 'view/commission/Ext', 'cwzy_ewyjsh', 'cwzy', 1, 2, 277);
INSERT INTO "t_sys_permission" VALUES (182827785159716864, '经纪服务专员测试', 'fa-sitemap', null, 'jjfwzycs', null, 1, 1, 280);
INSERT INTO "t_sys_permission" VALUES (182827785197465600, '经纪公司维护', null, 'view/firm/list2', 'jjfwzycs_jjgswh', 'jjfwzycs', 1, 2, 281);
INSERT INTO "t_sys_permission" VALUES (182827785235214336, '客服专员', 'fa-sitemap', null, 'kfzy', null, 1, 1, 290);
INSERT INTO "t_sys_permission" VALUES (182827785272963072, '客户意向审核', 'fa-sitemap', 'view/custintent/custSupport', 'kfzy_khyxsh', 'kfzy', 1, 2, 291);
COMMIT;

-- ----------------------------
--  Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS "t_sys_role";
CREATE TABLE t_sys_role (
  id varchar not null ,
  name varchar  ,
  code varchar  ,
  remark varchar ,
  primary key (id)
);

-- ----------------------------
--  Records of t_sys_role
-- ----------------------------
BEGIN;
INSERT INTO "t_sys_role" VALUES (182827778218143744, '超级管理员', 'admin_role', '超级管理员');
INSERT INTO "t_sys_role" VALUES (182827778255892480, '普通用户', 'common_role', '普通用户');
COMMIT;

-- ----------------------------
--  Table structure for t_sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS "t_sys_role_permission";
CREATE TABLE t_sys_role_permission (
  id varchar not null  ,
  permission_id varchar ,
  role_id varchar ,
  primary key (id)
);

-- ----------------------------
--  Records of t_sys_role_permission
-- ----------------------------
BEGIN;
INSERT INTO "t_sys_role_permission" VALUES (182827785822416896, 182827778310418432, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827785910497280, 182827778310418432, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827786011160576, 182827778503356416, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827786111823872, 182827778503356416, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827786204098560, 182827778541105152, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827786296373248, 182827778541105152, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827786409619456, 182827778570465280, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827786485116928, 182827778570465280, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827786577391616, 182827778620796928, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827786690637824, 182827778620796928, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827786766135296, 182827778671128576, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827786862604288, 182827778671128576, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827786954878976, 182827778721460224, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827787042959360, 182827778721460224, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827787118456832, 182827778759208960, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827787214925824, 182827778759208960, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827787290423296, 182827778792763392, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827787391086592, 182827778792763392, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827787474972672, 182827778843095040, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827787571441664, 182827778843095040, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827787655327744, 182827778880843776, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827787735019520, 182827778880843776, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827787823099904, 182827778914398208, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827787944734720, 182827778914398208, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827788045398016, 182827778956341248, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827788141867008, 182827778956341248, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827788225753088, 182827779006672896, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827788347387904, 182827779006672896, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827788422885376, 182827779057004544, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827788519354368, 182827779057004544, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827788599046144, 182827779111530496, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827788678737920, 182827779111530496, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827788775206912, 182827779166056448, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827788846510080, 182827779166056448, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827788917813248, 182827779212193792, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827788993310720, 182827779212193792, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827789102362624, 182827779254136832, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827789203025920, 182827779254136832, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827789286912000, 182827779296079872, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827789362409472, 182827779296079872, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827789450489856, 182827779329634304, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827789530181632, 182827779329634304, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827789626650624, 182827779388354560, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827789702148096, 182827779388354560, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827789769256960, 182827779430297600, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827789853143040, 182827779430297600, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827789924446208, 182827779476434944, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827789999943680, 182827779476434944, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827790071246848, 182827779543543808, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827790134161408, 182827779543543808, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827790209658880, 182827779593875456, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827790297739264, 182827779593875456, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827790385819648, 182827779631624192, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827790478094336, 182827779631624192, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827790578757632, 182827779669372928, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827790671032320, 182827779669372928, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827790754918400, 182827779719704576, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827790847193088, 182827779719704576, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827790931079168, 182827779765841920, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827791031742464, 182827779765841920, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827791124017152, 182827779807784960, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827791203708928, 182827779807784960, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827791291789312, 182827779845533696, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827791363092480, 182827779845533696, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827791451172864, 182827779879088128, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827791543447552, 182827779879088128, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827791673470976, 182827779925225472, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827791774134272, 182827779925225472, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827791866408960, 182827779962974208, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827791975460864, 182827779962974208, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827792105484288, 182827780004917248, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827792197758976, 182827780004917248, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827792285839360, 182827780042665984, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827792386502656, 182827780042665984, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827792508137472, 182827780080414720, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827792579440640, 182827780080414720, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827792671715328, 182827780118163456, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827792755601408, 182827780118163456, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827792860459008, 182827780189466624, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827792990482432, 182827780189466624, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827793091145728, 182827780243992576, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827793166643200, 182827780243992576, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827793263112192, 182827780285935616, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827793351192576, 182827780285935616, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827793435078656, 182827780340461568, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827793514770432, 182827780340461568, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827793581879296, 182827780403376128, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827793669959680, 182827780403376128, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827793737068544, 182827780453707776, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827793808371712, 182827780453707776, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827793867091968, 182827780495650816, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827793946783744, 182827780495650816, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827794009698304, 182827780533399552, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827794089390080, 182827780533399552, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827794173276160, 182827780579536896, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827794240385024, 182827780579536896, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827794315882496, 182827780621479936, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827794374602752, 182827780621479936, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827794424934400, 182827780671811584, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827794504626176, 182827780671811584, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827794571735040, 182827780726337536, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827794643038208, 182827780726337536, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827794705952768, 182827780789252096, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827794777255936, 182827780789252096, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827794840170496, 182827780831195136, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827794898890752, 182827780831195136, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827794970193920, 182827780868943872, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827795041497088, 182827780868943872, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827795104411648, 182827780923469824, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827795163131904, 182827780923469824, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827795238629376, 182827780965412864, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827795293155328, 182827780965412864, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827795347681280, 182827781007355904, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827795448344576, 182827781007355904, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827795528036352, 182827781045104640, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827795595145216, 182827781045104640, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827795649671168, 182827781082853376, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827795716780032, 182827781082853376, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827795796471808, 182827781137379328, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827795880357888, 182827781137379328, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827795943272448, 182827781196099584, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827795997798400, 182827781196099584, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827796056518656, 182827781233848320, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827796140404736, 182827781233848320, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827796194930688, 182827781275791360, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827796287205376, 182827781275791360, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827796354314240, 182827781317734400, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827796413034496, 182827781317734400, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827796471754752, 182827781351288832, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827796555640832, 182827781351288832, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827796614361088, 182827781389037568, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827796677275648, 182827781389037568, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827796735995904, 182827781422592000, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827796815687680, 182827781422592000, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827796874407936, 182827781464535040, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827796945711104, 182827781464535040, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827797012819968, 182827781498089472, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827797071540224, 182827781498089472, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827797147037696, 182827781548421120, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827797205757952, 182827781548421120, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827797260283904, 182827781598752768, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827797314809856, 182827781598752768, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827797390307328, 182827781636501504, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827797444833280, 182827781636501504, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827797503553536, 182827781686833152, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827797579051008, 182827781686833152, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827797633576960, 182827781741359104, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827797688102912, 182827781741359104, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827797746823168, 182827781779107840, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827797805543424, 182827781779107840, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827797885235200, 182827781829439488, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827797948149760, 182827781829439488, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827798023647232, 182827781871382528, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827798073978880, 182827781871382528, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827798128504832, 182827781913325568, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827798204002304, 182827781913325568, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827798266916864, 182827781959462912, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827798338220032, 182827781959462912, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827798409523200, 182827782009794560, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827798468243456, 182827782009794560, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827798526963712, 182827782047543296, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827798602461184, 182827782047543296, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827798665375744, 182827782081097728, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827798724096000, 182827782081097728, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827798791204864, 182827782118846464, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827798854119424, 182827782118846464, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827798933811200, 182827782156595200, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827798996725760, 182827782156595200, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827799084806144, 182827782190149632, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827799147720704, 182827782190149632, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827799239995392, 182827782223704064, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827799302909952, 182827782223704064, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827799361630208, 182827782257258496, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827799411961856, 182827782257258496, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827799487459328, 182827782299201536, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827799546179584, 182827782299201536, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827799630065664, 182827782336950272, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827799705563136, 182827782336950272, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827799764283392, 182827782378893312, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827799818809344, 182827782378893312, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827799881723904, 182827782416642048, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827799978192896, 182827782416642048, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827800070467584, 182827782471168000, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827800145965056, 182827782471168000, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827800213073920, 182827782508916736, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827800280182784, 182827782508916736, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827800347291648, 182827782546665472, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827800401817600, 182827782546665472, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827800473120768, 182827782584414208, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827800552812544, 182827782584414208, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827800611532800, 182827782622162944, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827800666058752, 182827782622162944, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827800720584704, 182827782668300288, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827800783499264, 182827782668300288, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827800863191040, 182827782710243328, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827800938688512, 182827782710243328, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827801014185984, 182827782752186368, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827801077100544, 182827782752186368, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827801123237888, 182827782785740800, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827801177763840, 182827782785740800, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827801228095488, 182827782823489536, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827801299398656, 182827782823489536, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827801358118912, 182827782882209792, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827801433616384, 182827782882209792, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827801500725248, 182827782924152832, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827801555251200, 182827782924152832, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827801613971456, 182827782957707264, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827801672691712, 182827782957707264, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827801748189184, 182827782991261696, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827801815298048, 182827782991261696, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827801874018304, 182827783045787648, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827801924349952, 182827783045787648, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827802008236032, 182827783083536384, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827802062761984, 182827783083536384, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827802121482240, 182827783117090816, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827802201174016, 182827783117090816, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827802259894272, 182827783154839552, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827802310225920, 182827783154839552, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827802381529088, 182827783188393984, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827802457026560, 182827783188393984, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827802536718336, 182827783230337024, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827802599632896, 182827783230337024, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827802675130368, 182827783289057280, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827802738044928, 182827783289057280, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827802796765184, 182827783335194624, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827802855485440, 182827783335194624, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827802922594304, 182827783381331968, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827803006480384, 182827783381331968, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827803065200640, 182827783419080704, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827803123920896, 182827783419080704, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827803207806976, 182827783477800960, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827803270721536, 182827783477800960, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827803329441792, 182827783519744000, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827803446882304, 182827783519744000, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827803513991168, 182827783561687040, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827803572711424, 182827783561687040, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827803648208896, 182827783599435776, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827803715317760, 182827783599435776, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827803778232320, 182827783653961728, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827803857924096, 182827783653961728, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827803916644352, 182827783708487680, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827803979558912, 182827783708487680, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827804038279168, 182827783746236416, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827804088610816, 182827783746236416, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827804168302592, 182827783783985152, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827804235411456, 182827783783985152, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827804294131712, 182827783821733888, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827804369629184, 182827783821733888, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827804424155136, 182827783872065536, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827804478681088, 182827783872065536, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827804545789952, 182827783909814272, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827804617093120, 182827783909814272, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827804684201984, 182827783943368704, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827804810031104, 182827783943368704, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827804881334272, 182827783981117440, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827805044912128, 182827783981117440, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827805124603904, 182827784014671872, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827805200101376, 182827784014671872, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827805296570368, 182827784060809216, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827805363679232, 182827784060809216, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827805434982400, 182827784115335168, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827805531451392, 182827784115335168, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827805623726080, 182827784161472512, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827805703417856, 182827784161472512, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827805787303936, 182827784211804160, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827805883772928, 182827784211804160, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827805959270400, 182827784257941504, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827806051545088, 182827784257941504, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827806127042560, 182827784295690240, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827806399672320, 182827784295690240, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827806483558400, 182827784341827584, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827806559055872, 182827784341827584, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827806659719168, 182827784400547840, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827806793936896, 182827784400547840, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827806873628672, 182827784476045312, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827806936543232, 182827784476045312, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827807007846400, 182827784530571264, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827807104315392, 182827784530571264, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827807179812864, 182827784606068736, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827807255310336, 182827784606068736, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827807347585024, 182827784648011776, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827807431471104, 182827784648011776, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827807498579968, 182827784706732032, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827807565688832, 182827784706732032, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827807636992000, 182827784752869376, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827807708295168, 182827784752869376, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827807897038848, 182827784794812416, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827808043839488, 182827784794812416, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827808115142656, 182827784840949760, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827808173862912, 182827784840949760, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827808253554688, 182827784882892800, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827808316469248, 182827784882892800, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827808375189504, 182827784958390272, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827808438104064, 182827784958390272, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827808509407232, 182827785008721920, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827808589099008, 182827785008721920, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827808668790784, 182827785054859264, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827808744288256, 182827785054859264, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827808815591424, 182827785113579520, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827808886894592, 182827785113579520, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827808962392064, 182827785159716864, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827809025306624, 182827785159716864, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827809084026880, 182827785197465600, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827809163718656, 182827785197465600, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827809235021824, 182827785235214336, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827809306324992, 182827785235214336, 182827778255892480);
INSERT INTO "t_sys_role_permission" VALUES (182827809373433856, 182827785272963072, 182827778218143744);
INSERT INTO "t_sys_role_permission" VALUES (182827809427959808, 182827785272963072, 182827778255892480);
COMMIT;

-- ----------------------------
--  Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS "t_sys_user";
CREATE TABLE t_sys_user (
  id varchar not null  ,
  username varchar   ,
  password varchar  ,
  salt varchar ,
  true_name varchar   ,
  email varchar  ,
  organize_id varchar ,
  status int(11) ,
  last_login_time timestamp  ,
  create_time timestamp  ,
  modify_time timestamp ,
  primary key (id)
);

-- ----------------------------
--  Records of t_sys_user
-- ----------------------------
BEGIN;
INSERT INTO "t_sys_user" VALUES (182827785478483968, 'admin', '48ba3c3026aafdc4c6169318e1dfb4f934415b56', 'dfc8852ab8c585a2', '管理员', 'admin@163.com', 182827778218143744, 1, null, X'31353236373839353430383334', null);
INSERT INTO "t_sys_user" VALUES (182827785616896000, 'wangxin', '23342e04b03f9eef80d1456e2db09622eb1cfa65', '101c5222088934eb', '王鑫', 'wangxin@139.com', 182827778255892480, 1, null, X'31353236373839353430383637', null);
COMMIT;

-- ----------------------------
--  Table structure for t_sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS "t_sys_user_role";
CREATE TABLE t_sys_user_role (
  id varchar not null  ,
  role_id varchar  ,
  user_id varchar ,
  primary key (id)
);

-- ----------------------------
--  Records of t_sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO "t_sys_user_role" VALUES (182827785516232704, 182827778218143744, 182827785478483968);
INSERT INTO "t_sys_user_role" VALUES (182827785637867520, 182827778255892480, 182827785616896000);
COMMIT;

PRAGMA foreign_keys = true;

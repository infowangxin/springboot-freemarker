package cn.springboot.web.shiro.vo;

import cn.springboot.framework.constant.Constants;
import cn.springboot.model.auth.Permission;

import java.util.ArrayList;
import java.util.List;


/**
 * 菜单测试数据
 *
 * @author 胡桃夹子
 * @date 2022/3/15 11:03
 */
public enum PermissionEnumUtil {

    /**
     * 管理首页
     */
    GLSY("管理首页", "fa-home", "glsy", null, "index", 1, 1),

    //-----------------------------------------------------------------------------------------------------
    /**
     * 站内新闻
     */
    ZNXY("站内新闻", null, "znxy", null, null, 1, 10),
    /**
     * 新闻发布
     */
    ZNXY_XWFB("新闻发布", null, "znxy_xwfb", "znxy", "news/add", 2, 11),
    /**
     * 新闻列表
     */
    ZNXY_XWLB("新闻列表", null, "znxy_xwlb", "znxy", "news/list", 2, 12),
    /**
     * 默认数据库
     */
    ZNXY_MRSJK("默认数据库", null, "znxy_mrsjk", "znxy", "news/list", 2, 13),
    /**
     * 数据库1
     */
    ZNXY_SJK1("数据库1", null, "znxy_sjk1", "znxy", "news/list1", 2, 14),
    /**
     * 数据库2
     */
    ZNXY_SJK2("数据库2", null, "znxy_sjk2", "znxy", "news/list2", 2, 15),

    //-----------------------------------------------------------------------------------------------------
    /**
     * 系统配置
     */
    XTPZ("系统配置", "fa-gear", "xtpz", null, "view/sysconfig/setconfig", 1, 20),

    //-----------------------------------------------------------------------------------------------------
    /**
     * 电商管理
     */
    DXGL("电商管理", "fa-desktop", "dxgl", null, "view/tenant/tenant-list", 1, 30),

    //-----------------------------------------------------------------------------------------------------
    /**
     * 电商配置
     */
    DSPZ("电商配置", "fa-gears", "dspz", null, "view/tenantConfig/list", 1, 40),

    //-----------------------------------------------------------------------------------------------------
    /**
     * 地区城市管理
     */
    DCCSGL("地区城市管理", "fa-map-marker", "dccsgl", null, null, 1, 50),
    /**
     * 添加城市
     */
    DCCSGL_TJCS("添加城市", null, "dccsgl_tjcs", "dccsgl", "view/city/add2", 2, 51),
    /**
     * 城市列表
     */
    DCCSGL_CSLB("城市列表", null, "dccsgl_cslb", "dccsgl", "view/city/list", 2, 51),

    //-----------------------------------------------------------------------------------------------------
    /**
     * 账号管理
     */
    CHGL("账号管理", "fa-user", "chgl", null, "view/user/user_list", 1, 60),

    //-----------------------------------------------------------------------------------------------------
    /**
     * 楼盘管理
     */
    LPGL("楼盘管理", "fa-building", "lpgl", null, "view/project/list", 1, 70),
    /**
     * 开通楼盘
     */
    LPGL_KTLP("开通楼盘", "fa-plus", "lpgl_ktlp", "lpgl", "view/project/openProject", 2, 71),
    /**
     * 楼盘审核
     */
    LPGL_LPSH("楼盘审核", "fa-pencil", "lpgl_lpsh", "lpgl", "view/project/list", 2, 72),
    /**
     * 楼盘管理
     */
    LPGL_LPGL("楼盘管理", "fa-building", "lpgl_lpgl", "lpgl", "view/project/manager_list", 2, 73),
    /**
     * 合作楼盘
     */
    LPGL_HZLP("合作楼盘", "fa-slideshare", "lpgl_hzlp", "lpgl", "view/project/edit_list", 2, 74),
    /**
     * 添加楼盘
     */
    LPGL_TJLP("添加楼盘", "fa-plus", "lpgl_tjlp", "lpgl", "view/project/add", 2, 75),
    /**
     * 基本信息
     */
    LPGL_TJLP_JBXX("基本信息", "fa-file-text-o", "lpgl_tjlp_jbxx", "lpgl_tjlp", "view/project/add", 3, 76),
    /**
     * 户型管理
     */
    LPGL_TJLP_HXGL("户型管理", "fa-puzzle-piece", "lpgl_tjlp_hxgl", "lpgl_tjlp", "view/project/add2", 3, 77),
    /**
     * 楼盘相册
     */
    LPGL_TJLP_LPXC("楼盘相册", "fa-picture-o", "lpgl_tjlp_lpxc", "lpgl_tjlp", "view/project/add3", 3, 78),
    /**
     * 销控管理
     */
    LPGL_TJLP_XKGL("销控管理", "fa-sort-numeric-asc", "lpgl_tjlp_xkgl", "lpgl_tjlp", "view/project/add4", 3, 79),
    /**
     * 合作信息
     */
    LPGL_TJLP_HZXX("合作信息", "fa-slideshare", "lpgl_tjlp_hzxx", "lpgl_tjlp", "view/project/add5", 3, 80),
    /**
     * 产品维护
     */
    LPGL_TJLP_CPWH("产品维护", "fa-share-alt", "lpgl_tjlp_cpwh", "lpgl_tjlp", "view/project/add6", 3, 81),
    /**
     * 拥金维护
     */
    LPGL_TJLP_RJWH("拥金维护", "fa-dollar", "lpgl_tjlp_rjwh", "lpgl_tjlp", "view/project/add7", 3, 82),
    /**
     * 楼盘动态
     */
    LPGL_TJLP_LPDT("楼盘动态", "fa-list-alt", "lpgl_tjlp_lpdt", "lpgl_tjlp", "view/project/add8", 3, 83),
    /**
     * 优惠活动
     */
    LPGL_TJLP_YHHD("优惠活动", "fa-heart", "lpgl_tjlp_yhhd", "lpgl_tjlp", "view/project/add9", 3, 84),

    //-----------------------------------------------------------------------------------------------------
    /**
     * 经济公司/经纪人
     */
    JJGSJJR("经济公司/经纪人", "fa-group", "jjgsjjr", null, null, 1, 90),
    /**
     * 经纪公司维护
     */
    JJGSJJR_JJGSWH("经纪公司维护", "fa-vine", "jjgsjjr_jjgswh", "jjgsjjr", "view/firm/list", 2, 91),
    /**
     * 经纪人管理
     */
    JJGSJJR_JJRGL("经纪人管理", "fa-group", "jjgsjjr_jjrgl", "jjgsjjr", "view/agent/list", 2, 92),
    /**
     * 经纪人实名认证
     */
    JJGSJJR_JJRSMRZ("经纪人实名认证", "fa-newspaper-o", "jjgsjjr_jjrsmrz", "jjgsjjr", "view/agent/list", 2, 93),
    /**
     * 经纪人银行卡认证
     */
    JJGSJJR_JJRYHKRZ("经纪人银行卡认证", "fa-credit-card", "jjgsjjr_jjryhkrz", "jjgsjjr", "view/agent/list", 2, 94),

    //-----------------------------------------------------------------------------------------------------
    /**
     * 置业顾问管理
     */
    ZYGWGL("置业顾问管理", "fa-user-md", "zygwgl", null, null, 1, 100),
    /**
     * 置业顾问挂靠审核
     */
    ZYGWGL_ZYGWGKSH("置业顾问挂靠审核", "fa-stumbleupon", "zygwgl_zygwgksh", "zygwgl", "view/adviserProject/adviserAuditList", 2, 101),
    /**
     * 置业顾问管理
     */
    ZYGWGL_ZYGWGL("置业顾问管理", "fa-user-md", "zygwgl_zygwgl", "zygwgl", "view/adviser/list", 2, 102),
    /**
     * 置业顾问实名认证
     */
    ZYGWGL_ZYGWSMRZ("置业顾问实名认证", "fa-newspaper-o", "zygwgl_zygwsmrz", "zygwgl", "view/agent/list", 2, 103),
    /**
     * 置业顾问银行卡认证
     */
    ZYGWGL_ZYGWYHKRZ("置业顾问银行卡认证", "fa-credit-card", "zygwgl_zygwyhkrz", "zygwgl", "view/agent/list", 2, 104),
    /**
     * 置业顾问元宝提现
     */
    ZYGWGL_ZYGWYBTX("置业顾问元宝提现", "fa-database", "zygwgl_zygwybtx", "zygwgl", "view/agent/list", 2, 105),

    //-----------------------------------------------------------------------------------------------------
    /**
     * POS交易管理
     */
    POSJYGL("POS交易管理", "fa-credit-card", "posjygl", null, null, 1, 110),
    /**
     * POS机绑定
     */
    POSJYGL_POSJBD("POS机绑定", "fa-unlock-alt", "posjygl_posjbd", "posjygl", "view/pos/bind", 2, 111),
    /**
     * POS绑定信息
     */
    POSJYGL_POSBDXX("POS绑定信息", "fa-link", "posjygl_posbdxx", "posjygl", "view/pos/list", 2, 112),
    /**
     * POS交易信息
     */
    POSJYGL_POSJYXX("POS交易信息", "fa-legal", "posjygl_posjyxx", "posjygl", "view/pos/poslog", 2, 113),
    /**
     * 数据统计
     */
    SJTJ("数据统计", "fa-pie-chart", "sjtj", null, null, 1, 120),
    /**
     * 用户统计
     */
    SJTJ_YHTJ("用户统计", "fa-user", "sjtj_yhtj", "sjtj", "view/data/statIncome_data", 2, 121),
    /**
     * 客户统计
     */
    SJTJ_KHTJ("客户统计", "fa-group", "sjtj_khtj", "sjtj", "view/data/statIncome_data", 2, 122),
    /**
     * 收入统计
     */
    SJTJ_SYTJ("收入统计", "fa-line-chart", "sjtj_sytj", "sjtj", "view/data/statIncome_data", 2, 123),
    /**
     * 佣金统计
     */
    SJTJ_YJTJ("佣金统计", "fa-pie-chart", "sjtj_yjtj", "sjtj", "view/data/statIncome_data", 2, 124),

    //-----------------------------------------------------------------------------------------------------
    /**
     * 合同管理
     */
    HTGL("合同管理", "fa-edit", "htgl", null, null, 1, 130),
    /**
     * 添加/管理列表
     */
    HTGL_TJGLLB("添加/管理列表", "fa-plus", "htgl_tjgllb", "htgl", "view/agreement/list", 2, 131),
    /**
     * 转认购
     */
    HTGL_ZRG("转认购", "fa-mail-forward", "htgl_zrg", "htgl", "view/agreement/rengou", 2, 132),
    /**
     * 签约
     */
    HTGL_QY("签约", "fa-check-square-o", "htgl_qy", "htgl", "view/agreement/qianyue", 2, 133),
    /**
     * 合同明细/编辑
     */
    HTGL_HTMXBJ("合同明细/编辑", "fa-edit", "htgl_htmxbj", "htgl", "view/agreement/edit", 2, 134),
    /**
     * 合同详情
     */
    HTGL_HTXQ("合同详情", "fa-building-o", "htgl_htxq", "htgl", "view/agreement/view", 2, 135),

    //-----------------------------------------------------------------------------------------------------
    /**
     * 总经理
     */
    ZJL("总经理", "fa-sitemap", "zjl", null, null, 1, 140),
    /**
     * 客户统计
     */
    ZJL_KHTJ("客户统计", "fa-group", "zjl_khtj", "zjl", "view/data/statIncome_data", 2, 141),
    /**
     * 收入统计
     */
    ZJL_SYTJ("收入统计", "fa-line-chart", "zjl_sytj", "zjl", "view/data/statIncome_data", 2, 143),
    /**
     * 佣金统计
     */
    ZJL_YJTJ("佣金统计", "fa-pie-chart", "zjl_yjtj", "zjl", "view/data/statIncome_data", 2, 144),

    //-----------------------------------------------------------------------------------------------------
    /**
     * 经济公司管理员
     */
    JJGSGLY("经济公司管理员", "fa-sitemap", "jjgsgly", null, null, 1, 150),
    /**
     * 合作
     */
    JJGSGLY_HZ("合作", "fa-slideshare", "jjgsgly_hz", "jjgsgly", "view/firm/verify", 2, 151),
    /**
     * 门店列表
     */
    JJGSGLY_MDLB("门店列表", "fa-slideshare", "jjgsgly_mdlb", "jjgsgly", "view/firm/list2", 2, 152),
    /**
     * 账号管理
     */
    JJGSGLY_ZHGL("账号管理", "fa-slideshare", "jjgsgly_zhgl", "jjgsgly", "view/user/user_list", 2, 153),
    /**
     * 挂靠审核
     */
    JJGSGLY_GHSH("挂靠审核", "fa-slideshare", "jjgsgly_ghsh", "jjgsgly", "view/firm/verify", 2, 154),
    /**
     * 对公账号
     */
    JJGSGLY_DGZH("对公账号", "fa-slideshare", "jjgsgly_dgzh", "jjgsgly", "view/firm/view", 2, 155),
    /**
     * 经纪人列表
     */
    JJGSGLY_JJRLB("经纪人列表", "fa-slideshare", "jjgsgly_jjrlb", "jjgsgly", "view/agent/list", 2, 156),
    /**
     * 客户列表
     */
    JJGSGLY_KHLB("客户列表", "fa-slideshare", "jjgsgly_khlb", "jjgsgly", "view/agent/custAgent", 2, 157),
    /**
     * 佣金信息
     */
    JJGSGLY_YJXX("佣金信息", "fa-slideshare", "jjgsgly_yjxx", "jjgsgly", "view/commission/agentCommission", 2, 158),
    /**
     * 额外佣金
     */
    JJGSGLY_EWYJ("额外佣金", "fa-slideshare", "jjgsgly_ewyj", "jjgsgly", "view/commission/commissionExt", 2, 159),
    /**
     * 客户统计
     */
    JJGSGLY_KHTJ("客户统计", "fa-group", "jjgsgly_khtj", "jjgsgly", "view/data/statIncome_data", 2, 160),
    /**
     * 收入统计
     */
    JJGSGLY_SYTJ("收入统计", "fa-line-chart", "jjgsgly_sytj", "jjgsgly", "view/data/statIncome_data", 2, 161),
    /**
     * 佣金统计
     */
    JJGSGLY_YJTJ("佣金统计", "fa-pie-chart", "jjgsgly_yjtj", "jjgsgly", "view/data/statIncome_data", 2, 162),

    //-----------------------------------------------------------------------------------------------------
    /**
     * 门店管理员
     */
    MDGLY("门店管理员", "fa-sitemap", "mdgly", null, null, 1, 170),
    /**
     * 挂靠审核
     */
    MDGLY_GHSH("挂靠审核", "fa-slideshare", "mdgly_ghsh", "mdgly", "view/firm/verify", 2, 171),
    /**
     * 经纪人列表
     */
    MDGLY_JJRLB("经纪人列表", "fa-slideshare", "mdgly_jjrlb", "mdgly", "view/agent/list", 2, 172),
    /**
     * 客户列表
     */
    MDGLY_KHLB("客户列表", "fa-slideshare", "mdgly_khlb", "mdgly", "view/agent/custAgent", 2, 173),
    /**
     * 用户统计
     */
    MDGLY_YHTJ2("用户统计", "fa-user", "mdgly_yhtj2", "mdgly", "view/data/statIncome_data", 2, 174),
    /**
     * 用户统计
     */
    MDGLY_YHTJ3("用户统计", "fa-user", "mdgly_yhtj3", "mdgly", "view/data/statIncome_data", 2, 175),
    /**
     * 用户统计
     */
    MDGLY_YHTJ4("用户统计", "fa-user", "mdgly_yhtj4", "mdgly", "view/data/statIncome_data", 2, 176),
    /**
     * 客户统计
     */
    MDGLY_KHTJ("客户统计", "fa-group", "mdgly_khtj", "mdgly", "view/data/statIncome_data", 2, 177),

    //-----------------------------------------------------------------------------------------------------
    /**
     * 案场经理
     */
    ACJL("案场经理", "fa-sitemap", "acjl", null, null, 1, 180),
    /**
     * 楼盘管理
     */
    ACJL_LPGL("楼盘管理", null, "acjl_lpgl", "acjl", null, 2, 181),
    /**
     * 楼盘列表
     */
    ACJL_LPGL_LPGL("楼盘列表", null, "acjl_lpgl_lpgl", "acjl_lpgl", "view/project/list", 3, 182),
    /**
     * 编辑添加
     */
    ACJL_LPGL_BJTJ("编辑添加", null, "acjl_lpgl_bjtj", "acjl_lpgl", "view/project/add", 3, 183),
    /**
     * 置业顾问挂靠审核
     */
    ACJL_ZYGWGKSH("置业顾问挂靠审核", "fa-stumbleupon", "acjl_zygwgksh", "acjl", "view/adviserProject/adviserAuditList", 2, 184),
    /**
     * 置业顾问管理
     */
    ACJL_ZYGWGL("置业顾问管理", "fa-user-md", "acjl_zygwgl", "acjl", "view/adviser/list", 2, 185),
    /**
     * 客户审核
     */
    ACJL_KHSH("客户审核", null, "acjl_khsh", "acjl", "view/custintent/custAuditList", 2, 186),

    //-----------------------------------------------------------------------------------------------------
    /**
     * 项目总监
     */
    XMZJ("项目总监", null, "xmzj", null, null, 1, 190),
    /**
     * 客户统计
     */
    XMZJ_KHTJ("客户统计", "fa-group", "xmzj_khtj", "xmzj", "view/data/statIncome_data", 2, 191),
    /**
     * 收入统计
     */
    XMZJ_SYTJ("收入统计", "fa-line-chart", "xmzj_sytj", "xmzj", "view/data/statIncome_data", 2, 192),
    /**
     * 佣金统计
     */
    XMZJ_YJTJ("佣金统计", "fa-pie-chart", "xmzj_yjtj", "xmzj", "view/data/statIncome_data", 2, 193),

    //-----------------------------------------------------------------------------------------------------
    /**
     * 项目经理
     */
    XMJL("项目经理", "fa-sitemap", "xmjl", null, null, 1, 200),
    /**
     * 开通楼盘
     */
    XMJL_KTLP("开通楼盘", "fa-plus", "xmjl_ktlp", "xmjl", "view/project/openProject", 2, 201),
    /**
     * 账号管理
     */
    XMJL_ZHGL("账号管理", "fa-slideshare", "xmjl_zhgl", "xmjl", "view/user/user_list", 2, 202),
    /**
     * 佣金审核
     */
    XMJL_YJSH("佣金审核", null, "xmjl_yjsh", "xmjl", "view/commission/list", 2, 203),
    /**
     * 开发商补贴
     */
    XMJL_KFSBT("开发商补贴", null, "xmjl_kfsbt", "xmjl", "view/devpSubsidy/list", 2, 204),
    /**
     * 推送管理
     */
    XMJL_TSGL("推送管理", null, "xmjl_tsgl", "xmjl", "view/push/list", 2, 205),
    /**
     * 客户统计
     */
    XMJL_KHTJ("客户统计", "fa-group", "xmjl_khtj", "xmjl", "view/data/statIncome_data", 2, 206),
    /**
     * 收入统计
     */
    XMJL_SYTJ("收入统计", "fa-line-chart", "xmjl_sytj", "xmjl", "view/data/statIncome_data", 2, 207),
    /**
     * 佣金统计
     */
    XMJL_YJTJ("佣金统计", "fa-pie-chart", "xmjl_yjtj", "xmjl", "view/data/statIncome_data", 2, 208),

    //-----------------------------------------------------------------------------------------------------
    /**
     * 项目助理
     */
    XMZL("项目助理", "fa-sitemap", "xmzl", null, null, 1, 210),
    /**
     * 确认到访
     */
    XMZL_QRDF("确认到访", null, "xmzl_qrdf", "xmzl", "view/code/code", 2, 211),
    /**
     * 发送语音验证码
     */
    XMZL_FSYYYZM("发送语音验证码", null, "xmzl_fsyyyzm", "xmzl", "view/code/telcode", 2, 212),
    /**
     * POS机绑定
     */
    XMZL_POSJBD("POS机绑定", "fa-unlock-alt", "xmzl_posjbd", "xmzl", "view/pos/bind", 2, 213),
    /**
     * POS交易记录
     */
    XMZL_POSBDXX("POS交易记录", "fa-link", "xmzl_posbdxx", "xmzl", "view/pos/list", 2, 214),
    /**
     * 客户意向查询
     */
    XMZL_KHYXQX("客户意向查询", null, "xmzl_khyxqx", "xmzl", "view/custintent/custAuditList", 2, 215),
    /**
     * 合同管理
     */
    XMZL_HTGL("合同管理", null, "xmzl_htgl", "xmzl", "view/agreement/list", 2, 216),

    //-----------------------------------------------------------------------------------------------------
    /**
     * 运营专员
     */
    YYZY("运营专员", "fa-sitemap", "yyzy", null, null, 1, 220),
    /**
     * 签到规则配置
     */
    YYZY_QDGZPZ("签到规则配置", null, "yyzy_qdgzpz", "yyzy", "view/sysconfig/signin", 2, 221),
    /**
     * 楼盘管理
     */
    YYZY_LPGL("楼盘管理", "fa-building", "yyzy_lpgl", "yyzy", "view/project/manager_list", 2, 222),
    /**
     * 城市管理
     */
    YYZY_TJCS("城市管理", null, "yyzy_tjcs", "yyzy", "view/city/add2", 2, 223),
    /**
     * 账号管理
     */
    YYZY_ZHGL("账号管理", "fa-slideshare", "yyzy_zhgl", "yyzy", "view/user/user_list", 2, 224),
    /**
     * 推送管理
     */
    YYZY_TSGL("推送管理", null, "yyzy_tsgl", "yyzy", "view/push/list", 2, 225),
    /**
     * 广告位管理
     */
    YYZY_GGWGL("广告位管理", null, "yyzy_ggwgl", "yyzy", "view/adv/list", 2, 226),
    /**
     * 客户意向查询
     */
    YYZY_KHYXQX("客户意向查询", null, "yyzy_khyxqx", "yyzy", "view/custintent/custAuditList", 2, 227),
    /**
     * POS机绑定
     */
    YYZY_POSJBD("POS机绑定", "fa-unlock-alt", "yyzy_posjbd", "yyzy", "view/pos/bind", 2, 228),
    /**
     * POS交易记录
     */
    YYZY_POSJYJL("POS交易记录", "fa-link", "yyzy_posjyjl", "yyzy", "view/pos/list", 2, 229),
    /**
     * 签约经纪公司
     */
    YYZY_QYJJGS("签约经纪公司", null, "yyzy_qyjjgs", "yyzy", "view/pos/list", 2, 230),
    /**
     * 经纪人管理
     */
    YYZY_JJRGL("经纪人管理", "fa-group", "yyzy_jjrgl", "yyzy", "view/agent/list", 2, 231),
    /**
     * 用户统计
     */
    YYZY_YHTJ("用户统计", "fa-user", "yyzy_yhtj", "yyzy", "view/data/statIncome_data", 2, 232),
    /**
     * 客户统计
     */
    YYZY_KHTJ("客户统计", "fa-group", "yyzy_khtj", "yyzy", "view/data/statIncome_data", 2, 233),
    /**
     * 收入统计
     */
    YYZY_SYTJ("收入统计", "fa-line-chart", "yyzy_sytj", "yyzy", "view/data/statIncome_data", 2, 234),
    /**
     * 佣金统计
     */
    YYZY_YJTJ("佣金统计", "fa-pie-chart", "yyzy_yjtj", "yyzy", "view/data/statIncome_data", 2, 235),

    //-----------------------------------------------------------------------------------------------------
    /**
     * 佣金专员
     */
    YJZY("佣金专员", "fa-sitemap", "yjzy", null, null, 1, 240),
    /**
     * 佣金规则审核
     */
    YJZY_YJGZSH("佣金规则审核", null, "yjzy_yjgzsh", "yjzy", "view/commission/auditList", 2, 241),
    /**
     * 经纪人实名认证
     */
    YJZY_JJRSMRZ("经纪人实名认证", "fa-newspaper-o", "yjzy_jjrsmrz", "yjzy", "view/agent/list", 2, 242),
    /**
     * 经纪人银行卡认证
     */
    YJZY_JJRYHKRZ("经纪人银行卡认证", "fa-credit-card", "yjzy_jjryhkrz", "yjzy", "view/agent/list", 2, 243),
    /**
     * 经纪人元宝提现
     */
    YJZY_JJRYBTX("经纪人元宝提现", "fa-credit-card", "yjzy_jjrybtx", "yjzy", "view/agent/grain", 2, 244),
    /**
     * 置业顾问实名认证
     */
    YJZY_ZYGWSMRZ("置业顾问实名认证", "fa-newspaper-o", "yjzy_zygwsmrz", "yjzy", "view/agent/list", 2, 245),
    /**
     * 置业顾问银行卡认证
     */
    YJZY_ZYGWYHKRZ("置业顾问银行卡认证", "fa-credit-card", "yjzy_zygwyhkrz", "yjzy", "view/agent/list", 2, 246),
    /**
     * 置业顾问元宝提现
     */
    YJZY_ZYGWYBTX("置业顾问元宝提现", "fa-database", "yjzy_zygwybtx", "yjzy", "view/agent/list", 2, 247),
    /**
     * 对公账号审核
     */
    YJZY_DGZHSH("对公账号审核", "fa-database", "yjzy_dgzhsh", "yjzy", "view/firm/account", 2, 248),
    /**
     * 退款审核
     */
    YJZY_TKSH("退款审核", null, "yjzy_tksh", "yjzy", "view/refund/list", 2, 249),
    /**
     * 佣金审核
     */
    YJZY_YJSH("佣金审核", null, "yjzy_yjsh", "yjzy", "view/commission/list", 2, 250),
    /**
     * 合同管理
     */
    YJZY_HTGL("合同管理", null, "yjzy_htgl", "yjzy", "view/agreement/list", 2, 251),
    /**
     * 额外佣金审核
     */
    YJZY_EWYJSH("额外佣金审核", null, "yjzy_ewyjsh", "yjzy", "view/commission/Ext", 2, 252),

    //-----------------------------------------------------------------------------------------------------
    /**
     * 出纳专员
     */
    CNZY("出纳专员", "fa-sitemap", "cnzy", null, null, 1, 260),
    /**
     * 经纪人元宝提现
     */
    CNZY_JJRYBTX("经纪人元宝提现", "fa-credit-card", "cnzy_jjrybtx", "cnzy", "view/agent/grain", 2, 261),
    /**
     * 置业顾问元宝提现
     */
    CNZY_ZYGWYBTX("置业顾问元宝提现", "fa-database", "cnzy_zygwybtx", "cnzy", "view/agent/list", 2, 262),
    /**
     * 退款审核
     */
    CNZY_TKSH("退款审核", null, "cnzy_tksh", "cnzy", "view/refund/list", 2, 263),
    /**
     * 佣金审核
     */
    CNZY_YJSH("佣金审核", null, "cnzy_yjsh", "cnzy", "view/commission/list", 2, 264),
    /**
     * 额外佣金审核
     */
    CNZY_EWYJSH("额外佣金审核", null, "cnzy_ewyjsh", "cnzy", "view/commission/Ext", 2, 265),

    //-----------------------------------------------------------------------------------------------------
    /**
     * 财务专员
     */
    CWZY("财务专员", null, "cwzy", null, null, 1, 270),
    /**
     * 经纪人元宝提现
     */
    CWZY_JJRYBTX("经纪人元宝提现", "fa-credit-card", "cwzy_jjrybtx", "cwzy", "view/agent/grain", 2, 271),
    /**
     * 置业顾问元宝提现
     */
    CWZY_ZYGWYBTX("置业顾问元宝提现", "fa-database", "cwzy_zygwybtx", "cwzy", "view/agent/list", 2, 272),
    /**
     * 开发商补贴确认
     */
    CWZY_KFSBT("开发商补贴确认", null, "cwzy_kfsbt", "cwzy", "view/devpSubsidy/list2", 2, 273),
    /**
     * 退款审核
     */
    CWZY_TKSH("退款审核", null, "cwzy_tksh", "cwzy", "view/refund/list", 2, 274),
    /**
     * 佣金审核
     */
    CWZY_YJSH("佣金审核", null, "cwzy_yjsh", "cwzy", "view/commission/list", 2, 275),
    /**
     * POS交易记录
     */
    CWZY_POSBDXX("POS交易记录", "fa-link", "cwzy_posbdxx", "cwzy", "view/pos/list", 2, 276),
    /**
     * 额外佣金审核
     */
    CWZY_EWYJSH("额外佣金审核", null, "cwzy_ewyjsh", "cwzy", "view/commission/Ext", 2, 277),

    //-----------------------------------------------------------------------------------------------------
    /**
     * 经纪服务专员测试
     */
    JJFWZYCS("经纪服务专员测试", "fa-sitemap", "jjfwzycs", null, null, 1, 280),
    /**
     * 经纪公司维护
     */
    JJFWZYCS_JJGSWH("经纪公司维护", null, "jjfwzycs_jjgswh", "jjfwzycs", "view/firm/list2", 2, 281),

    //-----------------------------------------------------------------------------------------------------
    /**
     * 客服专员
     */
    KFZY("客服专员", "fa-sitemap", "kfzy", null, null, 1, 290),
    /**
     * 客户意向审核
     */
    KFZY_KHYXSH("客户意向审核", "fa-sitemap", "kfzy_khyxsh", "kfzy", "view/custintent/custSupport", 2, 291),

    ;

    PermissionEnumUtil(String name, String cssClass, String key, String parentKey, String url, Integer lev, Integer sort) {
        this.name = name;
        this.cssClass = cssClass;
        this.key = key;
        this.lev = lev;
        this.sort = sort;
        this.url = url;
        this.hide = Constants.STATUS_VALID;
        this.parentKey = parentKey;
    }

    public static List<Permission> getPermissions() {
        List<Permission> list = new ArrayList<>();
        PermissionEnumUtil[] pers = PermissionEnumUtil.values();
        Permission per = null;
        for (PermissionEnumUtil p : pers) {
            per = new Permission();
            per.setName(p.getName());
            per.setCssClass(p.getCssClass());
            per.setSkey(p.getKey());
            per.setHide(p.getHide());
            per.setUrl(p.getUrl());
            per.setLev(p.getLev());
            per.setSort(p.getSort());
            per.setParentKey(p.getParentKey());
            list.add(per);
        }
        return list;
    }

    private String name;
    private String cssClass;
    private String key;
    private Integer hide;
    private String url;
    private Integer lev;
    private Integer sort;
    private String parentKey;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getHide() {
        return hide;
    }

    public void setHide(Integer hide) {
        this.hide = hide;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getLev() {
        return lev;
    }

    public void setLev(Integer lev) {
        this.lev = lev;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getParentKey() {
        return parentKey;
    }

    public void setParentKey(String parentKey) {
        this.parentKey = parentKey;
    }

}

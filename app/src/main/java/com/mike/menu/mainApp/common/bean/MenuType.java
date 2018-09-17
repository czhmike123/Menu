package com.mike.menu.mainApp.common.bean;

import com.google.gson.annotations.SerializedName;
import com.mike.commonlib.acmodel.BaseData;
import com.mike.commonlib.acmodel.SendData;

import java.io.Serializable;
import java.util.List;

/**
 * 项目名称: Menu
 * 类描述:MenuType
 * 作者: Mike
 * 创建时间: 2018/9/5 12:12
 * 邮箱:2468139903@qq.com
 */
public class MenuType  implements BaseData {
    //"showapi_res_error": "",
//"showapi_res_id": "3fa3ae78d34f49f1b970c7173e7633f7",
//"showapi_res_code": 0,
//"showapi_res_body": {
//"水产": {
//"贝": ["蛤蜊", "干贝", "鲍鱼", "牡蛎", "青口", "蛏子", "鲜贝", "北极贝", "河蚌"],
//"虾": ["虾仁", "海米", "虾皮", "明虾", "基围虾", "龙虾", "小龙虾", "河虾", "虾", "海虾", "皮皮虾", "北极虾", "虾干", "青虾", "草虾", "海白虾"],
//"鱼": ["海水鱼", "淡水鱼", "三文鱼", "鲫鱼", "金枪鱼", "黄鱼", "带鱼", "鳕鱼", "鱼", "鱼头", "鱼干", "鱼籽", "鱼肚"],
//"螃蟹": ["梭子蟹", "大闸蟹", "蟹肉", "螃蟹", "蟹黄"]
//},
//"汤粥主食": {
//"汤羹": ["汤羹"],
//"饭": ["饭", "焖", "饭团", "盖浇饭", "煲仔饭", "焗饭", "烩饭"],
//"面": ["面", "炒面", "汤面", "凉面", "焖面"],
//"饼": ["饼"]
//},
//"热门专题": {
//"菜式": ["家常菜", "快手菜", "下饭菜", "素菜", "大鱼大肉", "下酒菜", "小清新", "创意菜"],
//"特殊场合": ["早餐", "下午茶", "便当", "圣诞节", "年夜饭", "深夜食堂", "情人节", "宵夜"],
//"功效": ["减肥", "美容", "润肺抗燥", "补血", "清热祛火"],
//"特色食品": ["小吃", "酱", "沙拉", "凉菜", "零食", "三明治", "月饼", "蒸蛋", "寿司", "粽子"],
//"人群": ["儿童", "婴幼儿", "老人", "孕产妇"]
//},
//"肉类": {
//"鸭": ["鸭", "鸭肉", "老鸭", "鸭胗", "鸭血", "鸭掌", "鸭翅", "鸭舌", "鸭肠", "鸭脖", "鸭肝"],
//"鸽子": ["鸽子"],
//"牛": ["牛肉", "牛腩", "牛排", "肥牛", "牛里脊", "牛腱", "牛", "牛尾", "牛肉末", "牛筋", "牛百叶", "牛骨"],
//"羊": ["羊", "羊排", "羊腿", "羊肉片", "羊蝎子"],
//"牛蛙": ["牛蛙"],
//"猪": ["猪肉", "排骨", "猪肉末", "五花肉", "猪蹄", "肉丝", "肋排", "瘦肉", "猪", "里脊", "猪肝", "猪排", "猪肚", "猪皮", "猪骨", "肥肠", "猪油", "猪腰", "猪耳朵", "猪心", "猪血", "猪肺"],
//"鸡": ["鸡翅", "鸡胸", "鸡腿", "鸡翅中", "鸡腿肉", "鸡爪", "鸡", "鸡肉", "乌鸡", "鸡胗", "土鸡", "仔鸡", "三黄鸡", "鸡肝", "老母鸡", "鸡心", "柴鸡"]
//},
//"米面干果腌咸": {
//"干果类": ["芝麻", "花生", "杏仁", "红豆", "白芝麻", "黑芝麻", "枣", "核桃", "板栗", "蔓越莓", "绿豆", "黄豆", "薏米", "葡萄干", "莲子", "橄榄", "黑豆", "蜜豆", "芸豆", "腰果", "桃胶", "乌梅", "松仁", "银杏果", "话梅", "榛子", "鹰嘴豆", "罗汉果", "芡实", "开心果", "干山楂", "南瓜子", "瓜子仁", "眉豆", "红腰豆"],
//"米面类": ["面粉", "面条", "大米", "高筋面粉", "意大利面", "糯米", "低筋面粉", "年糕", "西米", "糯米粉", "粉丝", "燕麦", "米粉", "酒酿", "燕麦片", "乌冬面", "小米", "玉米面", "全麦粉", "黑米", "魔芋", "方便面", "粉条", "米线", "荞麦面", "油条", "黄豆面", "消化饼干", "面筋", "粘米粉", "凉粉", "糙米", "河粉", "紫米", "烤麸", "小麦胚芽", "澄面", "粉皮", "蕨根粉", "藕粉", "红曲米", "莜面", "黄米", "荞麦", "大麦", "高粱米"],
//"腌咸制品": ["火腿", "香肠", "培根", "火腿肠", "腊肉", "酸菜", "泡菜", "肉松", "梅干菜", "雪里蕻", "榨菜", "辣白菜", "笋干", "鱼丸", "橄榄菜", "咸菜", "萝卜干", "咸肉", "酸豇豆", "肉丸", "午餐肉", "蟹棒", "叉烧肉", "芽菜", "纳豆", "大头菜", "酸笋", "木鱼花", "冬菜", "玉兰片", "泡萝卜", "咸黄瓜"]
//},
//"蔬菜水果": {
//"水果": ["水果", "椰子", "草莓", "橙", "牛油果", "木瓜", "山楂", "蓝莓", "西瓜", "柚子", "火龙果", "樱桃", "榴莲", "西柚", "桃", "葡萄", "金橘", "黄桃", "百香果", "杨梅", "桔子", "荔枝", "无花果", "石榴", "杏子", "桑葚", "哈密瓜", "柿子", "李子", "青梅", "枇杷", "香瓜", "甘蔗", "覆盆子", "杨桃"],
//"菌菇类": ["香菇", "杏鲍菇", "银耳", "木耳", "金针菇", "蘑菇", "茶树菇", "平菇", "松茸", "鸡腿菇", "草菇", "竹荪", "蟹味菇", "花菇", "猴头菇", "牛肝菌", "灵芝", "榛蘑", "白玉菇", "姬松茸", "滑子菇", "发菜", "白灵菇", "袖珍菇", "双孢菇"],
//"果实类蔬菜": ["彩椒", "番茄", "南瓜", "玉米", "红椒", "茄子", "黄瓜", "玉米粒", "豇豆", "青椒", "苦瓜", "冬瓜", "丝瓜", "秋葵", "西葫芦", "毛豆", "豌豆", "四季豆", "荷兰豆", "蚕豆", "圣女果", "扁豆", "刀豆", "瓠瓜", "玉米笋"],
//"花朵植物类": ["桂花", "玫瑰", "薄荷", "菊花", "洛神花", "茉莉花", "槐花", "金银花"],
//"根茎蔬菜": ["土豆", "萝卜", "紫薯", "红薯", "胡萝卜", "山药", "藕", "芋头", "笋", "茭白", "马蹄", "牛蒡", "菱角"],
//"叶类蔬菜": ["芹菜", "白菜", "韭菜", "菠菜", "西兰花", "圆白菜", "花椰菜", "莴苣", "青菜", "娃娃菜", "生菜", "甘蓝", "蒜薹", "紫甘蓝", "空心菜", "油菜", "荠菜", "香椿", "茼蒿", "菜心", "芥兰", "黄花菜", "韭黄", "苋菜", "紫苏", "芥菜", "油麦菜", "豌豆苗", "苦菊", "青蒜", "鱼腥草", "马兰", "蕨菜", "西洋菜", "水芹", "儿菜", "豌豆尖", "芝麻菜", "芦蒿", "穿心莲", "孢子甘蓝", "萝卜苗", "红菜苔", "牛至", "蒿子杆"]
//},
//"烘焙甜品饮料": {
//"甜品": ["布丁", "冷饮", "果酱", "糖水", "冰淇淋", "果冻", "甜品"],
//"饮品": ["咖啡", "豆浆", "奶茶", "酒", "果汁", "花草茶", "饮品"],
//"烘焙": ["蛋糕", "面包", "饼干", "吐司", "乳酪蛋糕", "曲奇", "烘焙", "披萨", "派", "蛋挞", "司康", "塔", "泡芙", "奶油霜"]
//},
//"口味特色": {
//"异国风味": ["日式", "韩式", "西式", "东南亚"],
//"口味": ["辣", "咖喱", "糖醋", "蒜香", "酸甜", "奶香", "孜然", "鱼香", "五香", "清淡"],
//"器具": ["烤箱", "烤箱菜", "电饭煲", "微波炉", "平底锅", "塔吉锅"],
//"烹调方法": ["煎", "蒸", "炖", "红烧", "炸", "卤", "干锅", "火锅", "免烤"]
//},
//"flag": true,
//"ret_code": 0,
//"蛋奶豆制品": {
//"蛋类": ["鸡蛋", "咸蛋", "皮蛋", "咸蛋黄", "鹌鹑蛋", "土鸡蛋", "鸭蛋"],
//"豆制品": ["豆腐", "香干", "豆渣", "千张", "北豆腐", "腐竹", "素鸡", "油豆皮"],
//"奶制品": ["牛奶", "黄油", "巧克力", "奶酪", "酸奶", "无盐黄油", "黑巧克力", "淡奶油", "奶油奶酪", "炼乳", "奶粉", "马苏里拉...", "白巧克力", "酸奶油", "酥油"]
//},
//"其他": {
//"其他": ["其他"]
//}
//}
//}
    public boolean flag;
    public int ret_code;
    @SerializedName("水产")
    public ShuiChan ShuiChan;

    public class ShuiChan {
        @SerializedName("贝")
        public List<String> Bei;
        @SerializedName("虾")
        public List<String> Xia;
        @SerializedName("鱼")
        public List<String> Yu;
        @SerializedName("螃蟹")
        public List<String> PangXie;
    }

    @SerializedName("汤粥主食")
    public TangZhouZhuShi TangZhouZhuShi;

    public class TangZhouZhuShi {
        @SerializedName("汤羹")
        public List<String> TangGeng;
        @SerializedName("饭")
        public List<String> Fan;
        @SerializedName("面")
        public List<String> Mian;
        @SerializedName("饼")
        public List<String> Bing;
    }

    @SerializedName("热门专题")
    public ReMenZhuanTi ReMenZhuanTi;

    public class ReMenZhuanTi {
        @SerializedName("菜式")
        public List<String> CaiShi;
        @SerializedName("特殊场合")
        public List<String> TeShuChangHe;
        @SerializedName("功效")
        public List<String> GongXiao;
        @SerializedName("特色食品")
        public List<String> TeSeShiPin;
        @SerializedName("人群")
        public List<String> RenQun;
    }

    @SerializedName("肉类")
    public RouLei RouLei;

    public class RouLei {
        @SerializedName("鸭")
        public List<String> Ya;
        @SerializedName("鸽子")
        public List<String> GeZi;
        @SerializedName("牛")
        public List<String> Niu;
        @SerializedName("羊")
        public List<String> Yang;
        @SerializedName("牛蛙")
        public List<String> NiuWa;
        @SerializedName("猪")
        public List<String> Zhu;
        @SerializedName("鸡")
        public List<String> Ji;
    }

    @SerializedName("米面干果腌咸")
    public MiMianGanGuoAXian MiMianGanGuoAXian;

    public class MiMianGanGuoAXian {
        @SerializedName("干果类")
        public List<String> GanGuoLei;
        @SerializedName("米面类")
        public List<String> MiMianLei;
        @SerializedName("腌咸制品")
        public List<String> AXianZhiPin;
    }

    @SerializedName("蔬菜水果")
    public ShuCaiShuiGuo ShuCaiShuiGuo;

    public class ShuCaiShuiGuo {
        @SerializedName("水果")
        public List<String> ShuiGuo;
        @SerializedName("菌菇类")
        public List<String> JunGuLei;
        @SerializedName("果实类蔬菜")
        public List<String> GuoShiLeiShuCai;
        @SerializedName("花朵植物类")
        public List<String> HuaDuoZhiWuLei;
        @SerializedName("根茎蔬菜")
        public List<String> GenJingShuCai;
        @SerializedName("叶类蔬菜")
        public List<String> YeLeiShuCai;
    }

    @SerializedName("烘焙甜品饮料")
    public HongBeiTianPinYinLiao HongBeiTianPinYinLiao;

    public class HongBeiTianPinYinLiao {
        @SerializedName("甜品")
        public List<String> TianPin;
        @SerializedName("饮品")
        public List<String> YinPin;
        @SerializedName("烘焙")
        public List<String> HongBei;
    }

    @SerializedName("口味特色")
    public KouWeiTeSe KouWeiTeSe;

    public class KouWeiTeSe {
        @SerializedName("异国风味")
        public List<String> YiGuoFengWei;
        @SerializedName("口味")
        public List<String> KouWei;
        @SerializedName("器具")

        public List<String> QiJu;
        @SerializedName("烹调方法")
        public List<String> PengDiaoFangFa;
    }

    @SerializedName("蛋奶豆制品")
    public DanNaiDouZhiPin DanNaiDouZhiPin;

    public class DanNaiDouZhiPin {
        @SerializedName("蛋类")
        public List<String> DanLei;
        @SerializedName("豆制品")
        public List<String> DouZhiPin;
        @SerializedName("奶制品")
        public List<String> NaiZhiPin;
    }

    @SerializedName("其他")
    public QiTa QiTa;

    public class QiTa {
        @SerializedName("其他")
        public List<String> QiTa;
    }

    public static class Send implements SendData {}
}


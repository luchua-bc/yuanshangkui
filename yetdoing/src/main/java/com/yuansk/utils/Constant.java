package com.yuansk.utils;

/**
 * Created with IntelliJ IDEA.
 * User: YuanSK
 * Date: 2020/6/11 / 15:47
 * Description: 常量类
 */
public final class Constant {

    //登录成功
    public static final int LOGIN_SUCCESS = 0;

    //登陆失败
    public static final int LOGIN_FAILED = 1;

    //手机号错误
    public static final int LOGIN_FAILED_FOR_PHONE_NUMBER = 2;

    //密码错误
    public static final int LOGIN_FAILED_FOR_PASSWORD = 3;

    //手机号已注册
    public static final boolean PHONE_NUMBER_CANNOT_REGISTERED = false;

    //手机号未注册
    public static final boolean PHONE_NUMBER_CAN_REGISTERED = true;

    //注册成功
    public static final boolean REGISTER_SUCCESS = true;

    //注册失败
    public static final boolean REGISTER_FAILURE = false;

    //c3p0 配置文件名称
    public static final String C3P0_CONFIG_NAME = "YetDoingC3P0";

    //用户表名
    public static final String USERS_TABLE_NAME = "users";

    //手机号字段
    public static final String PHONE_NUMBER = "phoneNumber";

    //用户名
    public static final String USERNAME = "username";

    //密码
    public static final String PASSWORD = "password";

    //性别
    public static final String SEX = "sex";

    //头像文件名称
    public static final String HEAD_IMAGE_NAME = "headImageName";

    //用户头像文件父路径
//    public static final String HEAD_IMAGE_PARENT_PATH = "F:\\codes\\YetDoing\\userHeadImages\\";
    public static final String HEAD_IMAGE_PARENT_PATH = "C:\\Users\\Administrator.iZgewmm9t2m8vkZ\\my\\YetDoing\\userHeadImages\\";

    //头像文件后缀
    public static final String HEAD_IMAGE_PATTERN = ".png";
}

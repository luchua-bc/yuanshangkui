package com.yuansk.service;

/**
 * Created with IntelliJ IDEA.
 * User: YuanSK
 * Date: 2020/6/11 / 22:19
 * Description: 用户登录业务层接口
 */
public interface IUserLoginService {

    /**
     * 用户登录
     * @param phoneNumber 手机号
     * @param password 用户名
     * @return 登录结果
     */
    int login(String phoneNumber,String password);

}

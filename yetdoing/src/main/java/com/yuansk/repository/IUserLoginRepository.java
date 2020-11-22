package com.yuansk.repository;

/**
 * Created with IntelliJ IDEA.
 * User: YuanSK
 * Date: 2020/6/11 / 22:22
 * Description:
 */
public interface IUserLoginRepository {

    /**
     * 检测用户信息是否正确
     * @param phoneNumber 手机号
     * @param password 密码
     * @return 返回登录结果
     */
    int checkUserInfoFromDB(String phoneNumber, String password);

}

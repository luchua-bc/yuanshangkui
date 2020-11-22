package com.yuansk.service.impl;

import com.yuansk.repository.IUserLoginRepository;
import com.yuansk.repository.impl.UserLoginRepository;
import com.yuansk.service.IUserLoginService;
import com.yuansk.utils.Constant;

/**
 * Created with IntelliJ IDEA.
 * User: YuanSK
 * Date: 2020/6/11 / 22:19
 * Description:
 */
public class UserLoginServiceImpl implements IUserLoginService {
    /**
     * 用户登录
     *
     * @param phoneNumber 手机号
     * @param password    用户名
     * @return 登录结果
     */
    @Override
    public int login(String phoneNumber, String password) {

        if (phoneNumber == null || password == null) {
            return Constant.LOGIN_FAILED_FOR_PHONE_NUMBER;
        } else {
            IUserLoginRepository loginRepository = new UserLoginRepository();
            return loginRepository.checkUserInfoFromDB(phoneNumber, password);
        }

    }

    public static void main(String[] args) {
        int i = new UserLoginServiceImpl().login("18673233318","20020214ysk");
        System.out.println(i);
    }
}

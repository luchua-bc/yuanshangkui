package com.yuansk.service.impl;

import com.yuansk.repository.IRegisterRepository;
import com.yuansk.repository.impl.RegisterRepositoryImpl;
import com.yuansk.service.IRegisterService;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: YuanSK
 * Date: 2020/6/11 / 16:35
 * Description:
 */
public class RegisterServiceImpl implements IRegisterService {

    private IRegisterRepository databaseChecker;

    /**
     * 检测手机号是否已经注册
     *
     * @param phoneNumber 手机号
     * @return 检测结果
     */
    @Override
    public boolean checkPhoneNumber(String phoneNumber) {

        if (databaseChecker == null) {
            databaseChecker = new RegisterRepositoryImpl();
        }

        return databaseChecker.checkPhoneNumberFromDatabase(phoneNumber);
    }

    /**
     * 创建用户信息
     *
     * @param userInfo 用户信息
     * @return 注册结果
     */
    @Override
    public boolean submitUserInformation(Map<String, String> userInfo) {

        if (databaseChecker == null) {
            databaseChecker = new RegisterRepositoryImpl();
        }

        return databaseChecker.saveIntoDatabase(userInfo);
    }
}

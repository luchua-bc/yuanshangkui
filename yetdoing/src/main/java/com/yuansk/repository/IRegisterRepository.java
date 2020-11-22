package com.yuansk.repository;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: YuanSK
 * Date: 2020/6/11 / 16:35
 * Description:
 */
public interface IRegisterRepository {
    /**
     * 检测手机号是否已经注册
     * @param phoneNumber 手机号
     * @return 检测结果
     */
    boolean checkPhoneNumberFromDatabase(String phoneNumber);

    /**
     * 用户信息写入数据库
     * @param userInfo 用户信息
     * @return
     */
    boolean saveIntoDatabase(Map<String, String> userInfo);
}

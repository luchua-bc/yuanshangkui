package com.yuansk.service;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: YuanSK
 * Date: 2020/6/11 / 16:28
 * Description:检查手机号是否注册的业务层
 */
public interface IRegisterService {

    /**
     * 检测手机号是否已经注册
     * @param phoneNumber 手机号
     * @return 检测结果
     */
    boolean checkPhoneNumber(String phoneNumber);

    /**
     * 创建用户信息
     * @param userInfo 用户信息
     * @return
     */
    boolean submitUserInformation(Map<String, String> userInfo);
}

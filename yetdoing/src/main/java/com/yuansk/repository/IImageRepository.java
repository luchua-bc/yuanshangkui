package com.yuansk.repository;

/**
 * Created with IntelliJ IDEA.
 * User: YuanSK
 * Date: 2020/6/12 / 1:29
 * Description:
 */
public interface IImageRepository {

    /**
     * 更新用户头像名称
     * @param phoneNumber 用户手机号
     */
    void updateUserHeadImageName(String phoneNumber);

}

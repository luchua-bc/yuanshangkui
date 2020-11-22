package com.yuansk.service;

/**
 * Created with IntelliJ IDEA.
 * User: YuanSK
 * Date: 2020/6/12 / 1:18
 * Description:
 */
public interface IImageService {

    /**
     * 更新头像文件名
     * @param phoneNumber 用户手机号
     * @return 修改成功与否
     */
    void updateHeadImageName(String phoneNumber);

}

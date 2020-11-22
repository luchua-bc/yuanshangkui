package com.yuansk.service.impl;

import com.yuansk.repository.IImageRepository;
import com.yuansk.repository.impl.ImageRepositoryImpl;
import com.yuansk.service.IImageService;

/**
 * Created with IntelliJ IDEA.
 * User: YuanSK
 * Date: 2020/6/12 / 1:23
 * Description:
 */
public class ImageServiceImpl implements IImageService {
    /**
     * 更新头像文件名
     *
     * @param phoneNumber 用户手机号
     * @return 修改成功与否
     */
    @Override
    public void updateHeadImageName(String phoneNumber) {
        new ImageRepositoryImpl().updateUserHeadImageName(phoneNumber);
    }

}

package com.yuansk.repository.impl;

import com.yuansk.repository.IImageRepository;
import com.yuansk.utils.Constant;
import com.yuansk.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: YuanSK
 * Date: 2020/6/12 / 1:31
 * Description:
 */
public class ImageRepositoryImpl implements IImageRepository {
    /**
     * 更新用户头像名称
     *
     * @param phoneNumber 用户手机号
     */
    @Override
    public void updateUserHeadImageName(String phoneNumber) {

        Connection connection = JdbcUtils.getConnection();
        QueryRunner runner = new QueryRunner();
        String sql = "update users set headImageName=? where phoneNumber=?";
        try {
            runner.update(connection,sql,phoneNumber,phoneNumber);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

    }

}

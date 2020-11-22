package com.yuansk.repository.impl;

import com.yuansk.repository.IUserLoginRepository;
import com.yuansk.utils.Constant;
import com.yuansk.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: YuanSK
 * Date: 2020/6/11 / 22:25
 * Description: 登录数据层实现
 */
public class UserLoginRepository implements IUserLoginRepository {
    /**
     * 检测用户信息是否正确
     *
     * @param phoneNumber 手机号
     * @param password    密码
     * @return 返回登录结果
     */
    @Override
    public int checkUserInfoFromDB(String phoneNumber, String password) {

        int loginResult = Constant.LOGIN_SUCCESS;

        Connection connection = JdbcUtils.getConnection();
        QueryRunner runner = new QueryRunner();


        String sql = "select " + Constant.PASSWORD + " from " + Constant.USERS_TABLE_NAME + " where " + Constant.PHONE_NUMBER + "=?";
        try {
            String passwordTemplate = runner.query(connection, sql, new ScalarHandler<>(), phoneNumber);
            if (passwordTemplate == null) {
                loginResult = Constant.LOGIN_FAILED_FOR_PHONE_NUMBER;
            } else if (!password.equals(passwordTemplate)) {
                loginResult = Constant.LOGIN_FAILED_FOR_PASSWORD;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
            runner = null;
            connection = null;
        }

        return loginResult;
    }

}

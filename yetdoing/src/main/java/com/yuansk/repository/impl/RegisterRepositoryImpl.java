package com.yuansk.repository.impl;

import com.yuansk.repository.IRegisterRepository;
import com.yuansk.utils.Constant;
import com.yuansk.utils.JdbcUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: YuanSK
 * Date: 2020/6/11 / 16:39
 * Description:
 */
public class RegisterRepositoryImpl implements IRegisterRepository {

    /**
     * 检测手机号是否已经注册
     *
     * @param phoneNumber 手机号
     * @return 检测结果
     */
    @Override
    public boolean checkPhoneNumberFromDatabase(String phoneNumber) {
        QueryRunner runner = new QueryRunner();


        String sql = "select count(*) from " + Constant.USERS_TABLE_NAME + " where " + Constant.PHONE_NUMBER + "=?";
        Connection connection = JdbcUtils.getConnection();
        try {
            long count = runner.query(connection, sql, new ScalarHandler<>(), phoneNumber);
            if (count == 0) {
                return Constant.PHONE_NUMBER_CAN_REGISTERED;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return Constant.PHONE_NUMBER_CANNOT_REGISTERED;
    }

    /**
     * 用户信息写入数据库
     *
     * @param userInfo 用户信息
     * @return
     */
    @Override
    public boolean saveIntoDatabase(Map<String, String> userInfo) {

        if (!checkPhoneNumberFromDatabase(userInfo.get(Constant.PHONE_NUMBER))) {
            return Constant.REGISTER_FAILURE;
        }

        QueryRunner runner = new QueryRunner();

        String sql = "insert into " + Constant.USERS_TABLE_NAME + " (" + Constant.PHONE_NUMBER + "," + Constant.USERNAME + ", " + Constant.PASSWORD + "," + Constant.SEX + ") VALUES (?,?,?,?)";

        Connection connection = JdbcUtils.getConnection();
        try {
            int updateRol = runner.update(connection, sql,
                    userInfo.get(Constant.PHONE_NUMBER),
                    userInfo.get(Constant.USERNAME),
                    userInfo.get(Constant.PASSWORD),
                    userInfo.get(Constant.SEX));
            if (updateRol == 1) {
                return Constant.REGISTER_SUCCESS;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return Constant.REGISTER_FAILURE;
    }
}

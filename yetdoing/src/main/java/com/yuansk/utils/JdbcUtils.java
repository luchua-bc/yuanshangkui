package com.yuansk.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: YuanSK
 * Date: 2020/6/11 / 17:30
 * Description: 数据库连接
 */

public final class JdbcUtils {

    public static final DataSource dataSource;

    static {
        dataSource = new ComboPooledDataSource(Constant.C3P0_CONFIG_NAME);
    }

    /**
     * 获取数据库连接
     * @return connection
     */
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭流
     * @param c
     */
    public static void close(Connection c) {
        try {
            DbUtils.close(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

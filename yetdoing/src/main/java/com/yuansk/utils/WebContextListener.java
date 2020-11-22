package com.yuansk.utils;

import com.mchange.v2.c3p0.DataSources;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * User: YuanSK
 * Date: 2020/6/15 / 13:14
 * Description:
 */
@Deprecated
public class WebContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DataSource dataSource = JdbcUtils.dataSource;

        try {
            //调用c3p0的关闭数据库连接的方法
            DataSources.destroy(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //等待连接池关闭线程退出，避免Tomcat报线程未关闭导致memory leak的错误
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

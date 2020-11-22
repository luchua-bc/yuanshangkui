package com.yuansk.servlet;

import com.yuansk.service.IUserLoginService;
import com.yuansk.service.impl.UserLoginServiceImpl;
import com.yuansk.utils.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: YuanSK
 * Date: 2020/6/11 / 22:14
 * Description: 登录
 */
public class userLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String phoneNumber = req.getParameter(Constant.PHONE_NUMBER);
        String password = req.getParameter(Constant.PASSWORD);

        IUserLoginService loginService = new UserLoginServiceImpl();
        //获取登录结果
        int loginResult = loginService.login(phoneNumber, password);

        {
            System.out.println("userLoginServlet.doGet");
            System.out.println("phoneNumber = " + phoneNumber);
            System.out.println("password = " + password);
            System.out.println("loginResult = " + loginResult);
        }

        resp.getWriter().print(loginResult);

    }
}

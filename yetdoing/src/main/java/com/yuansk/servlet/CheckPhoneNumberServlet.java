package com.yuansk.servlet;

import com.yuansk.service.IRegisterService;
import com.yuansk.service.impl.RegisterServiceImpl;
import com.yuansk.utils.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: YuanSK
 * Date: 2020/6/11 / 15:47
 * Description: 验证手机号
 */
public class CheckPhoneNumberServlet extends HttpServlet {

    private IRegisterService checker;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        checker = new RegisterServiceImpl();

        String phoneNumber = req.getParameter(Constant.PHONE_NUMBER);

        boolean canRegister = Constant.PHONE_NUMBER_CANNOT_REGISTERED;
        if (phoneNumber != null) {
            canRegister = checker.checkPhoneNumber(phoneNumber);
        }

        {
            System.out.println("CheckPhoneNumberServlet.doPost");
            System.out.println("phoneNumber = " + phoneNumber);
            System.out.println("canRegister = " + canRegister);
        }

        resp.getWriter().print(canRegister);
    }

}

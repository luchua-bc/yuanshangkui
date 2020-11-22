package com.yuansk.servlet;

import com.yuansk.service.IRegisterService;
import com.yuansk.service.impl.RegisterServiceImpl;
import com.yuansk.utils.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: YuanSK
 * Date: 2020/6/11 / 19:19
 * Description:
 */
public class submitUserInformationServlet extends HttpServlet {

    private IRegisterService service;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        //存储用户信息
        Map<String, String> userInfo = new HashMap<>();
        service = new RegisterServiceImpl();

        //获取用户信息
        userInfo.put(Constant.USERNAME, req.getParameter(Constant.USERNAME));
        userInfo.put(Constant.PASSWORD, req.getParameter(Constant.PASSWORD));
        userInfo.put(Constant.PHONE_NUMBER, req.getParameter(Constant.PHONE_NUMBER));
        userInfo.put(Constant.SEX, req.getParameter(Constant.SEX));

        //如果有条目为空，注册失败
        if (userInfo.containsValue(null)) {
            resp.getWriter().print(Constant.REGISTER_FAILURE);
            return;
        }

        boolean submitSuccess = service.submitUserInformation(userInfo);

        {
            System.out.println("submitUserInformationServlet.doPost");
            System.out.println("userInfo = " + userInfo);
            System.out.println("submitSuccess = " + submitSuccess);
        }

        //返回注册结果
        resp.getWriter().print(submitSuccess);
    }
}

package com.yuansk.servlet;

import com.yuansk.utils.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: YuanSK
 * Date: 2020/6/11 / 23:02
 * Description:
 */
public class getUserHeadImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //使用用户手机号作为头像名称
        String imageName = req.getParameter(Constant.HEAD_IMAGE_NAME);

        String path = Constant.HEAD_IMAGE_PARENT_PATH + imageName + Constant.HEAD_IMAGE_PATTERN;

        System.out.print("imageName=" + imageName);

        File headImage = new File(path);
        System.out.print("  " + headImage.getAbsolutePath());
        if (headImage.exists()) {
            System.out.println(" exist!");
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(headImage));
            BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
            int len;
            byte[] buffer = new byte[1024];
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer,0,len);
            }
            bos.flush();
            bos.close();
            bis.close();
        } else {
            System.out.println(" not exist!");
        }
    }
}

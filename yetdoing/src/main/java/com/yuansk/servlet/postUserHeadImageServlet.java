package com.yuansk.servlet;

import com.yuansk.service.IImageService;
import com.yuansk.service.impl.ImageServiceImpl;
import com.yuansk.utils.Constant;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YuanSK
 * Date: 2020/6/12 / 1:08
 * Description:
 */
public class postUserHeadImageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String phoneNumber = req.getParameter(Constant.PHONE_NUMBER);

        IImageService imageService = new ImageServiceImpl();
        imageService.updateHeadImageName(phoneNumber);

        System.out.println("postUserHeadImageServlet.doPost  phoneNumber=" + phoneNumber);

        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        List<FileItem> fileItems;
        try {
            fileItems = servletFileUpload.parseRequest(req);
            if (fileItems != null) {
                for (FileItem fileItem : fileItems) {
                    System.out.println("fileItem = " + fileItem);

                    if (!fileItem.isFormField()) {
                        String fileName = fileItem.getName();
                        System.out.println("post image <" + fileName + ">...");
                        writeHeadImage(fileName, fileItem.getInputStream());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void writeHeadImage(String name, InputStream inputStream) {
        File image = new File(Constant.HEAD_IMAGE_PARENT_PATH + name + Constant.HEAD_IMAGE_PATTERN);
        try (BufferedInputStream bis = new BufferedInputStream(inputStream);
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(image))) {

            if (image.exists()) {
                image.delete();
            }
            image.createNewFile();

            int len;
            byte[] buffer = new byte[1024];
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

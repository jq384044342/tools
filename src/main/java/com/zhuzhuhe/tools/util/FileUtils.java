package com.zhuzhuhe.tools.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUtils {
    /*
    * 返回上传路径
    * */
    public static String uploadFile(MultipartFile file){
        if(!file.isEmpty()){
            String uploadPath = "/tmp/uploadFile";
            // 如果目录不存在则创建
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String OriginalFilename = file.getOriginalFilename();//获取原文件名
            String suffixName = OriginalFilename.substring(OriginalFilename.lastIndexOf("."));//获取文件后缀名
            //重新随机生成名字
            String filename = UUID.randomUUID().toString() +suffixName;
            File localFile = new File(uploadPath+"\\"+filename);
            try {
                file.transferTo(localFile); //把上传的文件保存至本地
                /**
                 * 这里应该把filename保存到数据库,供前端访问时使用
                 */
                return filename;//上传成功，返回保存的文件地址
            }catch (IOException e){
                e.printStackTrace();
                System.out.println("上传失败");
                return "";
            }
        }else{
            System.out.println("文件为空");
            return "";
        }
    }

    /*
    * 返回随机路径
    * */
    public static String randomFilePath(String filePath){
        if(StringUtils.isBlank(filePath)){
            return null;
        }
        String uploadPath = "/tmp/uploadFile";
        String suffixName = filePath.substring(filePath.lastIndexOf("."));//获取文件后缀名

        return uploadPath+UUID.randomUUID().toString() +suffixName;
    }
}

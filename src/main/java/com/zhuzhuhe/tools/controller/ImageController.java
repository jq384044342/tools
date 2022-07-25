package com.zhuzhuhe.tools.controller;

import com.zhuzhuhe.tools.util.ImageUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/*
* 图片处理类. 负责接受图片的压缩请求
* */
public class ImageController {

    private static final long SIZE_DEFUALT = 300*1024;

    @RequestMapping(value = "/getImage", method = RequestMethod.POST)
    @ResponseBody
    public byte[] getidcart(@RequestParam(value = "front", required = false) MultipartFile front) throws Exception {
        byte[] IdCartFront;
        /**
         *  图片字节
         *  判断压缩 >300kb就压缩到300kb以下 300000k=300kb 设置宽高px--->转小kb
         */
        if (front.getSize() > SIZE_DEFUALT) {
            IdCartFront = ImageUtils.imageSet(front.getBytes());
        } else {
            IdCartFront = front.getBytes();
        }
        return IdCartFront;
    }
}

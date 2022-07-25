package com.zhuzhuhe.tools.controller;

import com.zhuzhuhe.tools.service.impl.ThumbnailsServiceImpl;
import com.zhuzhuhe.tools.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("image")
public class ThumbnailsController {
    @Resource
    private ThumbnailsServiceImpl thumbnailsService;

    /**
     * 指定大小缩放
     *
     * @param resource
     * @param width
     * @param height
     * @return
     */
    @GetMapping("/changeSize")
    public String changeSize(MultipartFile resource, int width, int height) {
        String filePath = FileUtils.uploadFile(resource);
        String tofilePath = FileUtils.randomFilePath(filePath);
        return thumbnailsService.changeSize(filePath, width, height, tofilePath);
    }

    /**
     * 指定比例缩放
     *
     * @param resource
     * @param scale
     * @return
     */
    @GetMapping("/changeScale")
    public String changeScale(MultipartFile resource, double scale) {
        String filePath = FileUtils.uploadFile(resource);
        String tofilePath = FileUtils.randomFilePath(filePath);
        return thumbnailsService.changeScale(filePath, scale, tofilePath);
    }

    /**
     * 添加水印 watermark(位置,水印,透明度)
     *
     * @param resource
     * @param p
     * @param shuiyin
     * @param opacity
     * @return
     */
    @GetMapping("/watermark")
    public String watermark(MultipartFile resource, Positions p, MultipartFile shuiyin, float opacity) {
        String filePath = FileUtils.uploadFile(resource);
        String tofilePath = FileUtils.randomFilePath(filePath);
        String shuiyinPath = FileUtils.uploadFile(shuiyin);
        return thumbnailsService.watermark(filePath, Positions.CENTER, shuiyinPath, opacity, tofilePath);
    }

    /**
     * 图片旋转 rotate(度数),顺时针旋转
     *
     * @param resource
     * @param rotate
     * @return
     */
    @GetMapping("/rotate")
    public String rotate(MultipartFile resource, double rotate) {
        String filePath = FileUtils.uploadFile(resource);
        String tofilePath = FileUtils.randomFilePath(filePath);
        return thumbnailsService.rotate(filePath, rotate, tofilePath);
    }

    /**
     * 图片裁剪
     *
     * @param resource
     * @param p
     * @param width
     * @param height
     * @return
     */
    @GetMapping("/region")
    public String region(MultipartFile resource, Positions p, int width, int height) {
        String filePath = FileUtils.uploadFile(resource);
        String tofilePath = FileUtils.randomFilePath(filePath);
        return thumbnailsService.region(filePath, Positions.CENTER, width, height, tofilePath);
    }
}
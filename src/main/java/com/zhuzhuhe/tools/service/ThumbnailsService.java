package com.zhuzhuhe.tools.service;

import net.coobird.thumbnailator.geometry.Positions;

public interface ThumbnailsService {
    String changeSize(String resource, int width, int height, String tofile);

    String changeScale(String resource, double scale, String tofile);

    String watermark(String resource, Positions p, String shuiyin, float opacity, String tofile);

    String rotate(String resource, double rotate, String tofile);

    String region(String resource, Positions p, int width, int height, String tofile);

}

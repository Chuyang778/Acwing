package com.xuechuyang.Lambda;

import cn.hutool.core.bean.BeanUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author ChuYang
 * @version 1.0
 */
public class ImageModelVoAdapter {
    public static ImageModelVo adapt(ImageModel imageModel) {
        ImageModelVo imageModelVo = BeanUtil.copyProperties(imageModel, ImageModelVo.class);
        LocalDateTime creationTime = imageModel.getCreationTime();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeFormatter = dateTimeFormatter.format(creationTime);
        imageModelVo.setCreationTime(timeFormatter);
        return imageModelVo;
    }
}

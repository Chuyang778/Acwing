package com.xuechuyang.Lambda;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.func.Func;
import com.google.common.collect.Lists;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author ChuYang
 * @version 1.0
 */
public class Collector {
    public static void main(String[] args) {
        ImageModel imageModel1 = new ImageModel(1L, "/path/to/file1.jpg", 800, 600, "file1.jpg", "JPEG",
                LocalDateTime.of(2024, 1, 17, 10, 30, 18), "John Doe", "Description for image 1",
                new String[]{"tag1", "tag2"});

        ImageModel imageModel2 = new ImageModel(2L, "/path/to/file2.jpg", 1024, 768, "file2.jpg", "PNG",
                LocalDateTime.of(2024, 1, 18, 11, 45, 41), "Jane Smith", "Description for image 2",
                new String[]{"tag3", "tag4"});
        ImageModel imageModel3 = new ImageModel(3L, "/path/to/file3.jpg", 1920, 1080, "file3.jpg", "JPEG",
                LocalDateTime.of(2024, 1, 19, 15, 0, 22), "Alice Wonderland", "Description for image 3",
                new String[]{"tag5", "tag6"});

        ImageModel imageModel4 = new ImageModel(4L, "/path/to/file4.jpg", 1280, 720, "file4.jpg", "JPEG",
                LocalDateTime.of(2024, 2, 20, 12, 30, 12), "Bob Builder", "Description for image 4",
                new String[]{"tag7", "tag8"});
        List<ImageModel> imageModelList = new ArrayList<ImageModel>() {
            {
                add(imageModel1);
                add(imageModel2);
                add(imageModel3);
                add(imageModel4);
            }
        };
        Map<Long, ImageModelVo> imageModelVoMap = List2Map(imageModelList);
        imageModelVoMap.forEach((k, v) -> {
            System.out.println("ID = " + k + " ImageModelVo = " + v);
        });
    }

    public static Map<Long, ImageModelVo> List2Map(List<ImageModel> imageModels) {
        Assert.notNull(imageModels);
        return imageModels.stream().map(ImageModelVoAdapter::adapt).
                collect(Collectors.toMap(ImageModelVo::getId, Function.identity(), (k1, k2) -> k1));
    }
}

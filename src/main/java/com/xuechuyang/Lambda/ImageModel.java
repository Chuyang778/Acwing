package com.xuechuyang.Lambda;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * @author ChuYang
 * @version 1.0
 */
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageModel {

    private Long Id;
    private String filePath;
    private int width;
    private int height;
    private String fileName;
    private String format;
    private LocalDateTime creationTime;
    private String author;
    private String description;
    private String[] tags;
}

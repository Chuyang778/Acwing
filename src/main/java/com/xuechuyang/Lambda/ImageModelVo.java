package com.xuechuyang.Lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author ChuYang
 * @version 1.0
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ImageModelVo {

    private Long Id;
    private String filePath;
    private int width;
    private int height;
    private String fileName;
    private String format;
    private String creationTime;
    private String author;
    private String description;
    private String[] tags;
}

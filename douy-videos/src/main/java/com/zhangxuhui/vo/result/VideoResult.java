package com.zhangxuhui.vo.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zhangxuhui.vo.Uploader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/26 8:30 上午
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class VideoResult {
     String id;

    /**
     * 标题
     */
     String title;

    /**
     * 简介
     */
     String intro;

    /**
     * up主id
     */
     String uid;

    /**
     * 视频封面链接
     */
     String cover;

    /**
     * 视频播放链接
     */
     String link;

    /**
     * 分类id
     */
    @JsonProperty("category_id")
     String categoryId;

    /**
     * 类别名称
     */
    String category;

    Uploader uploader;



}

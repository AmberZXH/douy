package com.zhangxuhui.controller;

import com.zhangxuhui.entity.Page.Pagination;
import com.zhangxuhui.service.VideoService;
import com.zhangxuhui.vo.param.VideoQuery;
import com.zhangxuhui.vo.result.VideoResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nullable;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/6 5:02 下午
 * @Description:
 */
@RestController
@RequestMapping("videos")
public class VideoController {

    private static final Logger log = LoggerFactory.getLogger(VideoController.class);

    @Autowired
    VideoService videoService;

    /**
     * 获取视频列表
     * @param page
     * @param per_page
     * @param query
     * @return
     */
    @GetMapping
    public Pagination<VideoResult> videosList(Integer page,
                                              Integer per_page,
                                              @Nullable VideoQuery query){
        return videoService.selectedByPages(page, per_page, query);

    }



}

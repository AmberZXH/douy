package com.zhangxuhui.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhangxuhui.entity.Page.Pagination;
import com.zhangxuhui.mapper.VideoMapper;
import com.zhangxuhui.service.VideoService;
import com.zhangxuhui.vo.param.VideoQuery;
import com.zhangxuhui.vo.result.VideoResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/26 8:25 上午
 * @Description:
 */
@Service
@Transactional
public class VideoServiceImpl implements VideoService {
    private static final Logger log = LoggerFactory.getLogger(VideoServiceImpl.class);

    @Autowired
    VideoMapper videoMapper;


    @Override
    public Pagination<VideoResult> selectedByPages(Integer page, Integer per_page, VideoQuery query) {
        IPage<VideoResult> pageInfo = new Page<>(page,per_page);
        Pagination<VideoResult> pagination = new Pagination<>();
        List<VideoResult> results = videoMapper.selectByPages(pageInfo, query);
        pagination.setTotal_count(pageInfo.getTotal()).setItems(results);
        log.info("当前数据总条数：{}",pageInfo.getTotal());
        log.info("当前页条数：{}",pageInfo.getSize());
        log.info("当前页：{}",pageInfo.getCurrent());
        log.info("页面大小：{}",pageInfo.getPages());
        return pagination;

    }
}

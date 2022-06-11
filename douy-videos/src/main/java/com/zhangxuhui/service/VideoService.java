package com.zhangxuhui.service;

import com.zhangxuhui.entity.Page.Pagination;
import com.zhangxuhui.vo.param.VideoQuery;
import com.zhangxuhui.vo.result.VideoResult;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/26 8:25 上午
 * @Description:
 */

public interface VideoService {
    Pagination<VideoResult> selectedByPages(Integer page, Integer per_page, VideoQuery query);
}

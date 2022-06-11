package com.zhangxuhui.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhangxuhui.entity.Video;
import com.zhangxuhui.vo.param.VideoQuery;
import com.zhangxuhui.vo.result.VideoResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/26 8:23 上午
 * @Description: $description
*/
@Mapper
public interface VideoMapper extends BaseMapper<Video> {
    List<VideoResult> selectByPages(IPage<VideoResult> iPage, @Param("query") VideoQuery query);
}

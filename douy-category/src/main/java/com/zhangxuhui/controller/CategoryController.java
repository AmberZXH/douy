package com.zhangxuhui.controller;

import cn.hutool.json.JSONUtil;
import com.zhangxuhui.entity.Category;
import com.zhangxuhui.service.CategoryService;
import com.zhangxuhui.vo.CategoryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/6 5:00 下午
 * @Description:
 */
@RestController
@RequestMapping("categories")
public class CategoryController {

    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
    @Autowired
    private CategoryService categoryService;

    /**
     * 删除类别
     *
     * @param id
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        log.info("删除的类别Id：{}", id);
        categoryService.deleteById(id);
    }

    /**
     * 添加类别
     *
     * @param category
     * @return
     */
    @PostMapping
    public Category save(@RequestBody Category category) {
        log.info("添加的类别信息，{}", JSONUtil.toJsonStr(category));
        return categoryService.insert(category);
    }

    /**
     * 更新类别
     *
     * @param id
     * @param category
     * @return
     */
    @PatchMapping("/{id}")
    public Category update(@PathVariable Integer id, @RequestBody Category category) {
        log.info("更新类别id：{}", id);
        log.info("更新类别信息：{}", JSONUtil.toJsonStr(category));
        // 更新
        category.setId(id);
        return categoryService.update(category);
    }

    /**
     * 获取类别
     *
     * @return
     */
    @GetMapping
    public List<CategoryVO> categoryList() {
        return categoryService.queryByFirstLevel();
    }


}

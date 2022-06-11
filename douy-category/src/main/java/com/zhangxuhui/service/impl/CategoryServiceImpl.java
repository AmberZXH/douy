package com.zhangxuhui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.zhangxuhui.entity.Category;
import com.zhangxuhui.mapper.CategoryMapper;
import com.zhangxuhui.service.CategoryService;
import com.zhangxuhui.vo.CategoryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/9 8:12 下午
 * @Description:
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryVO> queryByFirstLevel() {
//        List<CategoryVO> result = new ArrayList<>();
//        List<Category> db_categoryList = categoryMapper.selectList(new LambdaQueryWrapper<Category>().isNull(Category::getParentId));
//        //组装vo
//        db_categoryList.forEach(c -> {
//            CategoryVO categoryVO = new CategoryVO();
//            categoryVO.setId(c.getId().toString()).setName(c.getName());
//            List<Category> categoryList = categoryMapper.selectList(new LambdaQueryWrapper<Category>().isNotNull(Category::getParentId).eq(Category::getId, c.getParentId()));
//            categoryVO.setCategoryList(categoryList);
//            result.add(categoryVO);
//        });
        return categoryMapper.queryByFirstLevel();


    }

    @Override
    public Category update(Category category) {
        category.setUpdatedAt(new Date());
        categoryMapper.updateById(category);
        return categoryMapper.selectOne(new LambdaQueryWrapper<Category>().eq(Category::getId, category.getId()));
    }

    @Override
    public Category insert(Category category) {
        Date currentTime = new Date();
        category.setCreatedAt(currentTime).setUpdatedAt(currentTime);
        int success = categoryMapper.insert(category);
        if(success == 1){
            log.info("新增成功");
        }else{
            log.info("新增失败");
        }
        log.info("新增类别的Id：{}",category.getId());
        return categoryMapper.selectOne(new LambdaQueryWrapper<Category>().eq(Category::getId,category.getId()));
    }

    @Override
    public void deleteById(Integer id) {
        Date deleteTime = new Date();
        Category category = new Category();
        category.setId(id).setUpdatedAt(deleteTime).setDeletedAt(deleteTime);
        int success = categoryMapper.updateById(category);
        if (success == 1) {
            log.info("删除成功");
        } else {
            log.info("删除失败");
        }
    }
}

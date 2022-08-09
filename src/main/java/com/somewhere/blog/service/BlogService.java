package com.somewhere.blog.service;

import com.somewhere.blog.po.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    //根据id查询
    Blog getBlog(Long id);
    //打印
    Page<Blog> listType(Pageable pageable);

    Page<Blog> listBlog(Pageable pageable);
    //新增
    Blog saveBlog(Blog blog);

    //修改编辑
    Blog updateBlog(Long id, Blog blog);


    //删除
    void deleteBlog(Long id);
}

package com.somewhere.blog.service;


import com.somewhere.blog.NotFoundException;
import com.somewhere.blog.dao.BlogRepository;
import com.somewhere.blog.po.Blog;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

//Service层
@Service
public class BlogServiceImplementation implements BlogService{

    @Autowired
    private BlogRepository blogRepository;
    //注入

    @Transactional
    @Override
    public Blog getBlog(Long id) {
        return blogRepository.findById(id).get();
    }

    @Transactional
    @Override
    public Page<Blog> listType(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    public Page<Blog> listBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }



    @Transactional
    @Override
    public Blog saveBlog(Blog blog){
        if(blog.getId()==null) {
            blog.setCreatTime(new Date());
            blog.setViews(0);
        }
        else{
            blog.setCreatTime(new Date());
        }
        return blogRepository.save(blog);
    }


    @Transactional
    @Override
    public Blog updateBlog(Long id, Blog blog) {
        Blog b = blogRepository.findById(id).get();
        if(b==null){
            throw new NotFoundException("该博客不存在");
        }
        BeanUtils.copyProperties(blog,b);
        return blogRepository.save(b);
    }

    @Transactional
    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }

}

package com.somewhere.blog.dao;

import com.somewhere.blog.po.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {

}




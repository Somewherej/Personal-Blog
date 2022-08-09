package com.somewhere.blog.service;
import com.somewhere.blog.po.User;


public interface userService {
    User checkUser(String username,String password);
}

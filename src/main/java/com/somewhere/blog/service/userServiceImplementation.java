package com.somewhere.blog.service;
import com.somewhere.blog.dao.UserRepository;
import com.somewhere.blog.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImplementation implements userService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username,String password){
        User user = userRepository.findByUserNameAndPassword(username,password);
        return user;
    }
}

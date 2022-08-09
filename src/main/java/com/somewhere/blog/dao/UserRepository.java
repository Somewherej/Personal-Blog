package com.somewhere.blog.dao;
import com.somewhere.blog.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserNameAndPassword(String userName,String password);
}

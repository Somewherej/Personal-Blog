package com.somewhere.blog.service;

import com.somewhere.blog.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface TypeService {
    //新增保存
    Type saveType(Type type);
    //根据id来查询类型

    Type getType(Long id);
    //分页查询
    Page<Type> listType(Pageable pageable);

    List<Type> listTypeTop(Integer size);

    //修改类型  (id,类型)  based id update type
    Type updateType(Long id,Type type);
    //删除类型
    void deleteType(Long id);


    List<Type> listType();

}

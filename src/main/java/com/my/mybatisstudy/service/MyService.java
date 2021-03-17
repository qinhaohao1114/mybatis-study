package com.my.mybatisstudy.service;

import com.my.mybatisstudy.dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Autowired
    private StudentMapper studentMapper;


}

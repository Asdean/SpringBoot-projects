package com.example.springbootmybatis.service.impl;

import com.example.springbootmybatis.mapper.StudentMapper;
import com.example.springbootmybatis.model.Student;
import com.example.springbootmybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    // 开启事务注解
    // @Transactional
    @Override
    public Student queryStudentById(Integer id) {
        // int i = 10/0;
        return studentMapper.selectByPrimaryKey(id);
    }
}

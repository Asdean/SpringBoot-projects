package com.example.springbootmybatis.service;


import com.example.springbootmybatis.model.Student;

public interface StudentService {

    /**
     * 根据学生ID查询详情
     * @param id
     * @return
     */
    Student queryStudentById(Integer id);
}

package com.example.springbootdubbossminterface.service;


import com.example.springbootdubbossminterface.model.Student;

public interface StudentService {

    /**
     * 根据学生ID查询详情
     * @param id
     * @return
     */
    Student queryStudentById(Integer id);

    /**
     * 获取学生总人数
     * @return
     */
    Integer queryAllStudentCount();

}

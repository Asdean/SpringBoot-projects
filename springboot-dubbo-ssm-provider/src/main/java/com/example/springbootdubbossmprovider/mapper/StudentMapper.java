package com.example.springbootdubbossmprovider.mapper;

import com.example.springbootdubbossminterface.model.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    /**
     * 获取学生总人数
     * @return
     */
    Integer selectAllStudentCount();
}
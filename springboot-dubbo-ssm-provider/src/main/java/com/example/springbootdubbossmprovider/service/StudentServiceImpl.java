package com.example.springbootdubbossmprovider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.springbootdubbossminterface.model.Student;
import com.example.springbootdubbossminterface.service.StudentService;
import com.example.springbootdubbossmprovider.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Service(interfaceName = "com.example.springbootdubbossminterface.service.StudentService", version = "1.0.0", timeout = 15000)
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;


    @Override
    public Student queryStudentById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer queryAllStudentCount() {
        //提升系统性能,用户体验提升
        //首先去redis缓存中查询,如果有:直接使用,如果没有:去数据库查询并存放到redis缓存中
        Integer allStudentCount = (Integer) redisTemplate.opsForValue().get("allStudentCount");

        //判断是否有值
        if (null == allStudentCount) {

            //去数据库查询
            allStudentCount = studentMapper.selectAllStudentCount();

            //并存放到redis缓存中
            redisTemplate.opsForValue().set("allStudentCount",allStudentCount,60, TimeUnit.SECONDS);
        }

        return allStudentCount;
    }
}

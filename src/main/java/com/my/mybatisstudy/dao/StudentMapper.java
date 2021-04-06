package com.my.mybatisstudy.dao;

import com.my.mybatisstudy.pojo.ClassInfo;
import com.my.mybatisstudy.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {


    List<Student> selectByNameAndId(@Param("id") Integer id,@Param("name") String name);

    Student insert();

    ClassInfo findStudentByClassId(@Param("id") Integer id);

    List<Student> selectByClassId(@Param("id") Integer id);
}

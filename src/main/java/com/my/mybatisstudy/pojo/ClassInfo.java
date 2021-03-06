package com.my.mybatisstudy.pojo;

import java.util.List;

/**
 * @Author: QinHaoHao
 * @Description:
 * @Date: Created in 17:37 2021/3/17
 * @Modifed By:
 */

public class ClassInfo {

    private Integer id;

    private String name;

    private List<Student> students;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

package com.lujiahao.entity;

import java.io.Serializable;

/**
 * @author lujiahao
 * @date 2018-07-09 上午11:56
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 8920597824668331209L;

    private Integer id;

    private Integer studentId;

    private String name;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", studentId=" + studentId + ", name=" + name + ", age=" + age + "]";
    }

}

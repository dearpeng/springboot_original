package com.honeypeng.entity;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Employee {
    /**
     * 
     */
    private Integer id;

    /**
     * 名字
     */
    private String lastName;

    /**
     * 性别(1:男 0:女)
     */
    private Integer gender;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 部门id
     */
    private Integer departmentId;


    private String departmentName;

    /**
     * 生日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date birth;

    /**
     * 获取
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * 获取名字
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 设置名字
     */
    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    /**
     * 获取性别(1:男 0:女)
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置性别(1:男 0:女)
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取部门id
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * 设置部门id
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 获取生日
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * 设置生日
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", departmentId=" + departmentId +
                ", birth=" + birth +
                '}';
    }

}
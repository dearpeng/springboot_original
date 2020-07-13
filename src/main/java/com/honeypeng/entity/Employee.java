package com.honeypeng.entity;

import lombok.Data;

import java.util.Date;


public class Employee {

    private void init(){
        System.out.println(this.getClass().getName()+"开始初始化...");
    }

    private void destory(){
        System.out.println(this.getClass().getName()+"开始销毁");
    }


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

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 生日
     */
    private Date birth;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

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
     * 获取部门名称
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * 设置部门名称
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
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

    /**
     * 获取密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置盐
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }
}
package org.lilacseeking.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;
@Entity
@Table(name = "UserPO")
public class UserPO {
    //唯一id
    @Id
    @Column(name="id", nullable=true)
    private Long id;
    //用户名
    @Column(name="username", nullable=true)
    private String username;
    //密码
    @Column(name="password", nullable=true)
    private String password;
    //密码加密盐值
    @Column(name="yanzhi", nullable=true)
    private String yanzhi;
    //姓名
    @Column(name="realname", nullable=true)
    private String realname;
    //年龄
    @Column(name="age", nullable=true)
    private Integer age;
    //出生日期
    @Column(name="birth", nullable=true)
    private Date birth;
    //性别
    @Column(name="gender", nullable=true)
    private Integer gender;
    //居住地
    @Column(name="address", nullable=true)
    private String address;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getYanzhi() {
        return yanzhi;
    }

    public String getRealname() {
        return realname;
    }

    public Integer getAge() {
        return age;
    }

    public Date getBirth() {
        return birth;
    }

    public Integer getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setYanzhi(String yanzhi) {
        this.yanzhi = yanzhi;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserPO(){

    }

    public UserPO(Long id, String username, String password, String yanzhi, String realname, Integer age, Date birth, Integer gender, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.yanzhi = yanzhi;
        this.realname = realname;
        this.age = age;
        this.birth = birth;
        this.gender = gender;
        this.address = address;
    }
}

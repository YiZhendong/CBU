package com.dong.cbu.model;

/**
 * Created by zhendong on 2016/4/20.
 * email:myyizhendong@gmail.com
 */
public class Member {
    private int id;
    private String name;
    private String password;
    private int sex;
    private String email;
    private String birthday;
    private int money;
    private int rank;

    /**
     * spring 注入时需要空的构造方法
     */
    public Member(){};
    public void setRank(int rank){
        this.rank = rank;
    }

    public int getRank(){
        return rank;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}

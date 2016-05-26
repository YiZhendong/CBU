package com.dong.cbu.model;

/**
 * Created by zhendong on 2016/4/20.
 * email:myyizhendong@gmail.com
 */
public class Actor{
    private int id;
    private String name;
    private int sex;
    private String country;
    private String birthday;        //此处有疑问 生日应该是什么类型
    private String introduction;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getSex(){
        return sex;
    }

    public void setSex(int sex){
        this.sex=sex;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country=country;
    }

    public String getBirthday(){
        return birthday;
    }

    public void setBirthday(String birthday){
        this.birthday=birthday;
    }

    public String getIntroduction(){
        return introduction;
    }

    public void setIntroduction(String introduction){
        this.introduction=introduction;
    }
}

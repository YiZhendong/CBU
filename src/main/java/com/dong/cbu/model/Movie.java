package com.dong.cbu.model;

/**
 * Created by zhendong on 2016/4/20.
 * email:myyizhendong@gmail.com
 */
public class Movie {
    private int id;
    private String introduction;
    private int status;
    private float score;
    private String name;

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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



}

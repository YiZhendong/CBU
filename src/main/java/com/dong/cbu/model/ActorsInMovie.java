package com.dong.cbu.model;

/**
 * Created by zhendong on 2016/4/20.
 * email:myyizhendong@gmail.com
 */
public class ActorsInMovie{
    private int id;
    private int actorId;
    private int movieId;

    public int getId( ){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public int getActorId( ){
        return actorId;
    }

    public void setActorId(int actorId){
        this.actorId=actorId;
    }

    public int getMovieId( ){
        return movieId;
    }

    public void setMovieId(int movieId){
        this.movieId=movieId;
    }
}

package com.dong.cbu.exception;

/**
 * Created by zhendong on 2016/4/29.
 * email:myyizhendong@gmail.com
 */
public class NotExistException extends Exception {
    public NotExistException(){
        super();
    }
    public NotExistException(String message){
        super(message);
    }
}

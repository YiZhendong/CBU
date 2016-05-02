package com.dong.cbu.exception;

/**
 * Created by zhendong on 2016/4/30.
 * email:myyizhendong@gmail.com
 */
public class UnknownException extends Exception {
    public UnknownException(){
        super();
    }
    public UnknownException(String Message){
        super(Message);
    }
    public UnknownException(String Message,Throwable Cause){
        super(Message,Cause);
    }
    public UnknownException(String Message,Throwable Cause,boolean enableSuppression,boolean writableStackTrace){
        super(Message,Cause,enableSuppression,writableStackTrace);
    }
    public UnknownException(Throwable Cause){
        super(Cause);
    }
}

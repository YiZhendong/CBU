package com.dong.cbu.exception;

/**
 * Created by zhendong on 2016/4/30.
 * email:myyizhendong@gmail.com
 */
public class MemberAlreadyExistException extends Exception {
    public MemberAlreadyExistException(){
        super();
    }
    public MemberAlreadyExistException(String Message) {
        super(Message);
    }
    public MemberAlreadyExistException(String Message,Throwable Cause){
        super(Message,Cause);
    }
    public MemberAlreadyExistException(String Message,Throwable Cause,boolean enableSuppression,boolean writeableSupression){
        super(Message,Cause,enableSuppression,writeableSupression);
    }
}

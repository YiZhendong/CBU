package com.dong.cbu.exception;

/**
 * Created by zhendong on 2016/5/5.
 * email:myyizhendong@gmail.com
 */
public class MoneyNotEnoughException extends Exception{
    public MoneyNotEnoughException(){
        super();
    }
    public MoneyNotEnoughException(String message){
        super(message);
    }
    public MoneyNotEnoughException(String message,Throwable cause){
        super(message,cause);
    }
    public MoneyNotEnoughException(Throwable cause){
        super(cause);
    }
}

package com.dong.cbu.commom;

/**
 * Created by zhendong on 2016/4/25.
 * email:myyizhendong@gmail.com
 */
public class Status {
    public static final int manager = 0;    //网站管理员
    public static final int boss = 1;       //老板
    public static final int customer_manager = 2; //客户经理
    public static final int member = 3;     //用户
    public static final int visitor = 4;    //游客
    public static final int action_success = 5; //操作成功
    public static final int action_fail = 6;    //操作失败
    public static final int not_exits = 7;      //用户不存在
    public static final int alreadyexits = 8;   //用户名已经存在
    public static final int password_not_correct = 9; //用户密码不正确
    public static final int login_success = 10; //登录成功
    public static final int no_records = 11;    //没有任何记录
}

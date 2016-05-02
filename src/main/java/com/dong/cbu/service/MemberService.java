package com.dong.cbu.service;

import com.dong.cbu.exception.MemberAlreadyExistException;
import com.dong.cbu.exception.NotExistException;
import com.dong.cbu.exception.PasswordNotMatchException;

import com.dong.cbu.exception.UnknownException;
import com.dong.cbu.model.Member;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhendong on 2016/4/29.
 * email:myyizhendong@gmail.com
 */
public interface MemberService {

    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Throwable.class)
    Member login(String name, String password) throws NotExistException,PasswordNotMatchException;

    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Throwable.class)
    void insert(Member member)throws MemberAlreadyExistException,UnknownException;
}

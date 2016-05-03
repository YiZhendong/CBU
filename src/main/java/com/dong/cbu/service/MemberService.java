package com.dong.cbu.service;

import com.dong.cbu.exception.MemberAlreadyExistException;
import com.dong.cbu.exception.NotExistException;
import com.dong.cbu.exception.PasswordNotMatchException;

import com.dong.cbu.exception.UnknownException;
import com.dong.cbu.model.Member;
import com.dong.cbu.model.Movie;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhendong on 2016/4/29.
 * email:myyizhendong@gmail.com
 */
public interface MemberService {

    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Throwable.class)
    Member login(String name, String password) throws NotExistException,PasswordNotMatchException;

    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Throwable.class)
    void insert(Member member)throws MemberAlreadyExistException,UnknownException;

    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Throwable.class)
    Member showOneMember(int id)throws UnknownException;

    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Throwable.class)
    void superUpdateMember(Member member)throws UnknownException;

    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Throwable.class)
    List<Movie> searchByScoreAndType(int score,int type,List<Movie> Movies)throws NotExistException;
}

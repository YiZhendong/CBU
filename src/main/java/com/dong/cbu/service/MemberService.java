package com.dong.cbu.service;

import com.dong.cbu.exception.*;

import com.dong.cbu.model.*;
import org.apache.poi.ss.formula.functions.T;
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
    List<Movie> searchByScoreAndStatus(int score,int status,List<Movie> movies)throws NotExistException;

    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Throwable.class)
    List<Movie> searchByScoreAndType(int score,int typeId,List<Movie> movies)throws NotExistException;

    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Throwable.class)
    List<Movie> searchByScore(int score,List<Movie> movies)throws NotExistException;

    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Throwable.class)
    List<Movie> searchByName(String name,List<Movie> movies)throws NotExistException;

    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Throwable.class)
    void order(OrderTable ordertable) throws MoneyNotEnoughException;

    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Throwable.class)
    List<Movie> showMovie()throws UnknownException;

    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Throwable.class)
    Movie searchById(int movieId) throws UnknownException;
}

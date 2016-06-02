package com.dong.cbu.serviceImpl;

import com.dong.cbu.commom.Status;
import com.dong.cbu.dao.CommentMapper;
import com.dong.cbu.dao.MemberMapper;
import com.dong.cbu.dao.OrderTableMapper;
import com.dong.cbu.exception.*;
import com.dong.cbu.model.*;
import com.dong.cbu.service.MemberService;
import com.dong.cbu.util.EncryptionUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhendong on 2016/4/29.
 * email:myyizhendong@gmail.com
 */
@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private OrderTableMapper ordertableMapper;

    private Log logger =LogFactory.getLog(MemberServiceImpl.class);


    @Override
    public Member login(String name,String password) throws NotExistException,PasswordNotMatchException{
        String message ="";
        Member member = memberMapper.searchMemberByName(name);
        if(member == null){
            message = "用户" + name + "尝试登陆，但该用户不存在";
            logger.debug(message);
            throw new NotExistException(message,Status.not_exits);
        }else{
            String encryptPassword = member.getPassword();
            if(!encryptPassword.equals(EncryptionUtil.encrypt(password))){
                throw new PasswordNotMatchException();
            }
        }
        return member;
    }

    @Override
    public void insert(Member member) throws MemberAlreadyExistException,UnknownException {
        if(memberMapper.isMemberExists(member)!=0){
            throw new MemberAlreadyExistException("Member is already exists");
        }
        String encryptPassword = EncryptionUtil.encrypt(member.getPassword());
        member.setPassword(encryptPassword);
        if(memberMapper.insertMember(member) == Status.action_fail){
            throw new UnknownException();
        }
    }
    @Override
    public Member showOneMember(int id) throws UnknownException{
        return memberMapper.showOneMember(id);
    }

    @Override
    public void superUpdateMember(Member member) throws UnknownException{
        memberMapper.superUpdateMember(member);
    }

    @Override
    public List<Movie> searchByScoreAndStatus(int score,int status,List<Movie> movies) throws NotExistException{
        System.out.print("hahahahhaah");
        movies = memberMapper.searchByScoreAndStatus(score,status);
        return movies;
    }

    @Override
    public List<Movie> searchByScoreAndType(int score,int typeId,List<Movie> movies) throws NotExistException{
        System.out.print("hahahahhaah");
        movies = memberMapper.searchByScoreAndType(score,typeId);
        return movies;
    }

    @Override
    public List<Movie> searchByScore(int score,List<Movie> movies) throws NotExistException{
        System.out.print("hahahahhaah");
        movies = memberMapper.searchByScore(score);
        return movies;
    }

    @Override
    public List<Movie> searchByName(String name,List<Movie> movies)throws NotExistException{
        movies = memberMapper.searchByName(name);
        return movies;
    }


    @Override
    public void order(OrderTable ordertable)throws MoneyNotEnoughException{
        if (ordertableMapper.order(ordertable)== Status.action_fail){
            throw new MoneyNotEnoughException();
        }
    }
}

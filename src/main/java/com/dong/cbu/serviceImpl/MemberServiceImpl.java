package com.dong.cbu.serviceImpl;

import com.dong.cbu.commom.Status;
import com.dong.cbu.dao.MemberMapper;
import com.dong.cbu.exception.MemberAlreadyExistException;
import com.dong.cbu.exception.NotExistException;
import com.dong.cbu.exception.PasswordNotMatchException;
import com.dong.cbu.exception.UnknownException;
import com.dong.cbu.model.Member;
import com.dong.cbu.model.Movie;
import com.dong.cbu.service.MemberService;
import com.dong.cbu.util.EncryptionUtil;
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

    @Override
    public Member login(String name,String password) throws NotExistException,PasswordNotMatchException{
        Member member = memberMapper.loginMember(name);
        if(member == null){
            throw new NotExistException("member"+name+"not exists");
        }else{
            String encryptPassword = member.getPassword();
            if(!encryptPassword.equals(EncryptionUtil.encrypt(password))){
                throw new PasswordNotMatchException();
            }
        }
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
    public List<Movie> searchByScoreAndType(int score,int type) throws NotExistException{

    }
}

package com.dong.cbu.serviceImpl;

import com.dong.cbu.dao.MemberMapper;
import com.dong.cbu.exception.NotExistException;
import com.dong.cbu.exception.PasswordNotMatchException;
import com.dong.cbu.model.Member;
import com.dong.cbu.util.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhendong on 2016/4/29.
 * email:myyizhendong@gmail.com
 */
@Service
public class MemberServiceImpl {
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Member login(String name,String password) throws NotExistException,PasswordNotMatchException{
        Member member = MemberMapper.loginMember(name);
        if(member == null){
            throw new NotExistException("member"+name+"not exists");
        }else{
            String encryptPassword = member.getPassword();
            if(!encryptPassword.equals(EncryptionUtil.encrypt(password))){
                throw new PasswordNotMatchException();
            }
        }
    }
}

package com.dong.cbu.controller;

import com.dong.cbu.commom.Response;
import com.dong.cbu.commom.Status;
import com.dong.cbu.exception.NotExistException;
import com.dong.cbu.exception.PasswordNotMatchException;
import com.dong.cbu.model.Member;
import com.dong.cbu.service.MemberService;
import com.dong.cbu.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import static com.dong.cbu.controller.MemberAction.ACTION_BASE_URL_HEADER;


/**
 * Created by zhendong on 2016/4/28.
 * email:myyizhendong@gmail.com
 */
@Controller
public class MemberAction {
    private static final String ACTION_BASE_URL_HEADER = "/member";

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = ACTION_BASE_URL_HEADER + "/login.do",method = RequestMethod.POST)
    @ResponseBody
    public Object loginMember(@RequestParam("name")String name, @RequestParam("password")String password, HttpServletRequest request) {
        int status;
        Member member = null;
        try{
            member = memberService.login(name,password);
            status = member.getId();
        }catch(NotExistException e){
            e.printStackTrace();
            status = Status.not_exits;
        }catch (PasswordNotMatchException e){
            e.printStackTrace();
            status = Status.password_not_correct;
        }
        SessionUtil.setLoginMember(request,member);
        return new Response(status,member);
    }


}

package com.dong.cbu.controller;

import com.dong.cbu.commom.Response;
import com.dong.cbu.commom.Status;
import com.dong.cbu.exception.*;
import com.dong.cbu.model.Comment;
import com.dong.cbu.model.Member;
import com.dong.cbu.model.Movie;
import com.dong.cbu.model.OrderTable;
import com.dong.cbu.service.MemberService;
import com.dong.cbu.util.SessionUtil;
import com.dong.cbu.validator.MemberAddValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

//import static com.dong.cbu.controller.MemberAction.ACTION_BASE_URL_HEADER;


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
        System.out.println("++++++++++++++++++++"+name);
        int status;
        Member member = null;
        try{
            member = memberService.login(name,password);
            status = member.getRank();
        }catch(NotExistException e){
            e.printStackTrace();
            status = Status.not_exits;
        }catch (PasswordNotMatchException e){
            e.printStackTrace();
            status = Status.password_not_correct;
        }
        SessionUtil.setLoginMember(request,member);
        System.out.println("null "+status+member);
        return new Response(status,member);
    }

    @RequestMapping(value = ACTION_BASE_URL_HEADER + "/register.do",method = RequestMethod.POST)
    @ResponseBody
    public Object registerMember(HttpServletRequest request, @Validated({MemberAddValidator.class})@RequestBody Member member){
        int status = Status.action_success;
        try{
            memberService.insert(member);
            System.out.println(member);
        }catch(MemberAlreadyExistException e){
            e.printStackTrace();
            status = Status.alreadyexits;
            member = null;
            return new Response(status,member);
        }catch(UnknownException e){
            e.printStackTrace();
            status = Status.action_fail;
            member = null;
            return new Response(status,member);
        }
        return new Response(status,member);
    }

    @RequestMapping(value = ACTION_BASE_URL_HEADER + "/showOneMember.do",method = RequestMethod.POST)
    @ResponseBody
    public Object showOneMember(@RequestParam int id){
        int status = Status.action_success;
        Member member = new Member();
        try {
            member = memberService.showOneMember(id);
            if(member == null){
                status = Status.not_exits;
            }
        }catch (UnknownException e){
            e.printStackTrace();
        }
        return new Response(status,member);
    }

    @RequestMapping(value = ACTION_BASE_URL_HEADER + "/superUpdateMember.do",method = RequestMethod.POST)
    @ResponseBody
    public Object superUpdateMember(@Validated({MemberAddValidator.class})@RequestBody Member member){
        int status = Status.action_success;
        try{
            memberService.superUpdateMember(member);
        }catch(UnknownException e){
            e.printStackTrace();
            status = Status.action_fail;
        }
        return new Response(status);
    }

    @RequestMapping(value = ACTION_BASE_URL_HEADER + "/searchByScoreAndType.do",method = RequestMethod.POST)
    @ResponseBody
    public Object searchByScoreAndType(@RequestParam("score")int score,@RequestParam("type")int type){
        int status = Status.action_success;
        List<Movie> movies = new ArrayList<Movie>();
        try{
            movies = memberService.searchByScoreAndType(score,type,movies);
        }catch (NotExistException e){
            e.printStackTrace();
            status = Status.action_fail;
        }
        return new Response(status,movies);
    }

    @RequestMapping(value = ACTION_BASE_URL_HEADER + "/comment.do",method = RequestMethod.POST)
    @ResponseBody
    public Object comment(HttpServletRequest request,@RequestBody Comment comment){
        int status = Status.action_success;
        try{
            memberService.comment(comment);
        }catch (UnknownException e){
            e.printStackTrace();
            status = Status.action_fail;
        }
        return new Response(status);
    }

    @RequestMapping(value = ACTION_BASE_URL_HEADER + "order.do",method = RequestMethod.POST)
    @ResponseBody
    public Object order(HttpServletRequest request, @RequestBody OrderTable ordertable){
        int status = Status.action_success;
        try{
            memberService.order(ordertable);
        }catch(MoneyNotEnoughException e){
            e.printStackTrace();;
            status = Status.action_fail;
        }
        return new Response(status);
    }
}

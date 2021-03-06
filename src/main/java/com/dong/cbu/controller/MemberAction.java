package com.dong.cbu.controller;

import com.dong.cbu.commom.Response;
import com.dong.cbu.commom.Status;
import com.dong.cbu.exception.*;
import com.dong.cbu.model.*;
import com.dong.cbu.service.MemberService;
import com.dong.cbu.util.Pagination;
import com.dong.cbu.util.SessionUtil;
import com.dong.cbu.validator.MemberAddValidator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by zhendong on 2016/4/28.
 * email:myyizhendong@gmail.com
 */
@Controller
public class MemberAction{
    private static final String ACTION_BASE_URL_HEADER="/member";

    @Autowired
    private MemberService memberService;
    private Log logger =LogFactory.getLog(MemberAction.class);

    @RequestMapping(value=ACTION_BASE_URL_HEADER+"/login.do", method=RequestMethod.POST)
    @ResponseBody
    public Object loginMember(@RequestParam("name") String name, @RequestParam("password") String password, HttpServletRequest request){
        System.out.println("++++++++++++++++++++"+name);
        int status;
        String username;
        Member member=null;
        try{
            member=memberService.login(name, password);
            username = member.getName();
            logger.info(username+"登陆成功;");
            System.out.print(member);
            status=member.getRank();
        }catch(NotExistException e){
            e.printStackTrace();
            status=Status.not_exits;
        }catch(PasswordNotMatchException e){
            e.printStackTrace();
            status=Status.password_not_correct;
        }
        SessionUtil.setLoginMember(request, member);
        System.out.println("null "+status+member);
        return new Response(status, member);
    }

    @RequestMapping(value=ACTION_BASE_URL_HEADER+"/register.do", method=RequestMethod.POST)
    @ResponseBody
    public Object registerMember(HttpServletRequest request, @Validated({MemberAddValidator.class}) @RequestBody Member member){
        int status=Status.action_success;
        try{
            memberService.insert(member);
            System.out.println(member);
        }catch(MemberAlreadyExistException e){
            e.printStackTrace();
            status=Status.alreadyexits;
            member=null;
            return new Response(status, member);
        }catch(UnknownException e){
            e.printStackTrace();
            status=Status.action_fail;
            member=null;
            return new Response(status, member);
        }
        return new Response(status, member);
    }

    @RequestMapping(value=ACTION_BASE_URL_HEADER+"/showOneMember.do", method=RequestMethod.POST)
    @ResponseBody
    public Object showOneMember(@RequestParam int id){
        int status=Status.action_success;
        Member member=new Member();
        try{
            member=memberService.showOneMember(id);
            if(member==null){
                status=Status.not_exits;
            }
        }catch(UnknownException e){
            e.printStackTrace();
        }
        return new Response(status, member);
    }

    @RequestMapping(value=ACTION_BASE_URL_HEADER+"/superUpdateMember.do", method=RequestMethod.POST)
    @ResponseBody
    public Object superUpdateMember(@Validated({MemberAddValidator.class}) @RequestBody Member member){
        int status=Status.action_success;
        try{
            memberService.superUpdateMember(member);
        }catch(UnknownException e){
            e.printStackTrace();
            status=Status.action_fail;
        }
        return new Response(status);
    }

    @RequestMapping(value=ACTION_BASE_URL_HEADER+"/movie/searchByScoreAndStatus.do", method=RequestMethod.POST)
    @ResponseBody
    public Object searchByScoreAndStatus(@RequestParam("score") int score, @RequestParam("status") int status, HttpServletRequest request){
        int status_origin=Status.action_success;
        System.out.print(score+"+++++++++++++"+status);
        List<Movie> movies=new ArrayList<Movie>();
        try{
            movies=memberService.searchByScoreAndStatus(score, status, movies);
        }catch(NotExistException e){
            e.printStackTrace();
            status_origin=Status.action_fail;
        }
        return new Response(status_origin, movies);
    }

    @RequestMapping(value=ACTION_BASE_URL_HEADER+"/movie/searchByScoreAndParameter.do", method=RequestMethod.POST)
    @ResponseBody
    public Object searchByScoreAndParameter(@RequestParam("score") int score, @RequestParam("typeId") int typeId,
                                            HttpServletRequest request){
        int status=Status.action_success;
        List<Movie> movies=new ArrayList<>();
        try{
            movies=memberService.searchByScoreAndType(score, typeId, movies);
            System.out.println(movies.get(0).getName());
            System.out.print("运行到这里了");
        }catch(NotExistException e){
            e.printStackTrace();
            status=Status.action_fail;
        }
        return new Response(status, movies);
    }

    @RequestMapping(value=ACTION_BASE_URL_HEADER+"/movie/searchByScore.do", method=RequestMethod.POST)
    @ResponseBody
    public Object searchByScore(@RequestParam("score") int score, HttpServletRequest request){
        int status=Status.action_success;
        System.out.print(score+"+++++++++++++");
        List<Movie> movies=new ArrayList<Movie>();
        try{
            movies=memberService.searchByScore(score, movies);
        }catch(NotExistException e){
            e.printStackTrace();
            status=Status.action_fail;
        }
        return new Response(status, movies);
    }

    @RequestMapping(value=ACTION_BASE_URL_HEADER+"/movie/searchByName.do", method=RequestMethod.POST)
    @ResponseBody
    public Object searchByName(HttpServletRequest request, @RequestParam("name") String name){
        int status=Status.action_success;
        System.out.println("this is a searchByName test"+name);
        List<Movie> movies=new ArrayList<>();
        try{
            movies=memberService.searchByName(name, movies);
        }catch(NotExistException e){
            e.printStackTrace();
            status=Status.action_fail;
            return new Response(status, movies);
        }
        return new Response(status, movies);
    }

    @RequestMapping(value=ACTION_BASE_URL_HEADER+"/order.do", method=RequestMethod.POST)
    @ResponseBody
    public Object order(HttpServletRequest request, @RequestBody OrderTable ordertable){
        int status=Status.action_success;
        try{
            memberService.order(ordertable);
        }catch(MoneyNotEnoughException e){
            e.printStackTrace();
            status=Status.action_fail;
        }
        return new Response(status);
    }

    @RequestMapping(value=ACTION_BASE_URL_HEADER+"/showFirstPageMovie.do",method = RequestMethod.GET)
    @ResponseBody
    public Object showMovie(@RequestParam int currentPage){
        int status = Status.action_success;
        List<Movie> movies = new ArrayList<>();
        MoviePage moviePage = new MoviePage();
        try{
            movies = memberService.showMovie();
            moviePage =Pagination.showMoviePage(movies,currentPage);
        }catch (UnknownException e){
            e.printStackTrace();
            status = Status.action_fail;
        }
        return new Response(status,moviePage);
    }

    @RequestMapping(value = ACTION_BASE_URL_HEADER+"/searchById.do",method = RequestMethod.POST)
    @ResponseBody
    public Object searchById(@RequestParam("movieId") int movieId,HttpServletRequest request){
        int status = Status.action_success;
        Movie movie = new Movie();
        try{
            movie = memberService.searchById(movieId);
        }catch (UnknownException e){
            e.printStackTrace();
            status = Status.action_fail;
        }
        return new Response(status,movie);
    }
}

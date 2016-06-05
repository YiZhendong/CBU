package com.dong.cbu.controller;

import com.dong.cbu.commom.Response;
import com.dong.cbu.commom.Status;
import com.dong.cbu.exception.UnknownException;
import com.dong.cbu.model.Comment;
import com.dong.cbu.model.CommentPage;
import com.dong.cbu.service.CommentService;
import com.dong.cbu.util.Pagination;
import com.dong.cbu.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

import static com.dong.cbu.controller.CommentAction.ACTION_BASE_URL_HEADER;

/**
 * Created by zhendong on 2016/5/21.
 * email:myyizhendong@gmail.com
 */
@Controller
public class CommentAction {
	public static final String ACTION_BASE_URL_HEADER = "/comment";

	@Autowired
	private CommentService commentService;

	@RequestMapping(value=ACTION_BASE_URL_HEADER+"/comment.do", method=RequestMethod.POST)
	@ResponseBody
	public Object comment(HttpServletRequest request, @RequestBody Comment comment){
		int status=Status.action_success;
		try{
			//comment.setOwnerId((SessionUtil.getLoginMember(request)).getId());
			System.out.println(comment);
			commentService.comment(comment);
		}catch(UnknownException e){
			e.printStackTrace();
			status=Status.action_fail;
		}
		return new Response(status);
	}

	@RequestMapping(value=ACTION_BASE_URL_HEADER+"/queryByMovieId.do",method=RequestMethod.POST)
	@ResponseBody
	public Object queryByMovieId(HttpServletRequest request, @RequestParam("movieId") int movieId){
		int status = Status.action_success;
		List<Comment> comments = new ArrayList<>();
		try{
			comments = commentService.queryByMovieId(movieId,comments);
		}catch(UnknownException e){
			e.printStackTrace();
			status = Status.action_fail;
		}
		return new Response(status,comments);
	}

	@RequestMapping(value=ACTION_BASE_URL_HEADER+"/queryByOwnerId.do",method=RequestMethod.POST)
	@ResponseBody
	public Object queryByOwnerId(HttpServletRequest request, @RequestParam("ownerId") int ownerId,
	@RequestParam("currentPage") int currentPage){
		int status = Status.action_success;
		List<Comment> comments = new ArrayList<>();
		CommentPage commentPage = new CommentPage();
		try{
			comments = commentService.queryByOwnerId(ownerId,comments);
			if(comments!=null){
				commentPage = Pagination.showCommentPage(comments,currentPage);
			}else{
				status = Status.action_fail;
			}
		}catch(UnknownException e){
			e.printStackTrace();
			status = Status.action_fail;
		}
		return new Response(status,commentPage);
	}
}

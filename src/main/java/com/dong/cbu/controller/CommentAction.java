package com.dong.cbu.controller;

import com.dong.cbu.commom.Response;
import com.dong.cbu.commom.Status;
import com.dong.cbu.exception.UnknownException;
import com.dong.cbu.model.Comment;
import com.dong.cbu.service.CommentService;
import com.dong.cbu.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
}

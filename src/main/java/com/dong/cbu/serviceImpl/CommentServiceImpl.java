package com.dong.cbu.serviceImpl;

import com.dong.cbu.dao.CommentMapper;
import com.dong.cbu.exception.UnknownException;
import com.dong.cbu.model.Comment;
import com.dong.cbu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhendong on 2016/5/26.
 * email:myyizhendong@gmail.com
 */
@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentMapper commentMapper;

	@Override
	public void comment(Comment comment) throws UnknownException{
		commentMapper.comment(comment);
	}

	@Override
	public List<Comment> queryByMovieId(int movieId,List<Comment> comments) throws UnknownException{
		comments = commentMapper.queryByMovieId(movieId);
		return comments;
	}

	@Override
	public List<Comment> queryByOwnerId(int ownerId,List<Comment> comments) throws UnknownException{
		comments = commentMapper.queryByOwnerId(ownerId);
		return comments;
	}
}

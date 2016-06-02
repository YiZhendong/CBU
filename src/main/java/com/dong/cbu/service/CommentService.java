package com.dong.cbu.service;

import com.dong.cbu.exception.UnknownException;
import com.dong.cbu.model.Comment;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhendong on 2016/5/21.
 * email:myyizhendong@gmail.com
 */
public interface CommentService {
	@Transactional(isolation =Isolation.READ_COMMITTED,rollbackFor = Throwable.class)
	void comment(Comment comment) throws UnknownException;

	@Transactional(isolation =Isolation.READ_COMMITTED,rollbackFor = Throwable.class)
	List<Comment> queryByMovieId(int movieId, List<Comment> comments)throws UnknownException;

	@Transactional(isolation =Isolation.READ_COMMITTED,rollbackFor = Throwable.class)
	List<Comment> queryByOwnerId(int ownerId, List<Comment> comments)throws UnknownException;
}

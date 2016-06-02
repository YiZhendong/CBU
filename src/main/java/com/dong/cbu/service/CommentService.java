package com.dong.cbu.service;

import com.dong.cbu.exception.UnknownException;
import com.dong.cbu.model.Comment;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhendong on 2016/5/21.
 * email:myyizhendong@gmail.com
 */
public interface CommentService {
	@Transactional(isolation =Isolation.READ_COMMITTED,rollbackFor = Throwable.class)
	void comment(Comment comment) throws UnknownException;
}

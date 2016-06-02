package com.dong.cbu.dao;

import com.dong.cbu.model.Comment;

import java.util.List;

/**
 * Created by zhendong on 2016/5/5.
 * email:myyizhendong@gmail.com
 */
public interface CommentMapper {
    void comment(Comment comment);

    List<Comment> queryByMovieId(int movieId);

    List<Comment> queryByOwnerId(int ownerId);
}

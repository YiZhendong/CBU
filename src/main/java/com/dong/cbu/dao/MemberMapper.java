package com.dong.cbu.dao;

import com.dong.cbu.model.Member;
import com.dong.cbu.model.Movie;

import java.util.List;

/**
 * Created by zhendong on 2016/4/29.
 * email:myyizhendong@gmail.com
 */
public interface MemberMapper {
    int insertMember(Member member);
    int isMemberExists(Member member);
    Member loginMember(String name);
    Member showOneMember(int id);
    void superUpdateMember(Member member);
    List<Movie> searchByScoreAndType(int score,int type);
    List<Movie> searchByName(String name);
}

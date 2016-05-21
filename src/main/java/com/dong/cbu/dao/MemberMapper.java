package com.dong.cbu.dao;

import com.dong.cbu.model.Member;
import com.dong.cbu.model.Movie;
import com.dong.cbu.model.OrderTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
    //传递两个参数需要使用@Param
    List<Movie> searchByScoreAndType(@Param("score") int score,@Param("typeId") int typeId);
    List<Movie> searchByScoreAndStatus(@Param("score") int score,@Param("status") int status);
    List<Movie> searchByScore(int score);

    List<Movie> searchByName(String name);
}

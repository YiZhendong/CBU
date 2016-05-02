package com.dong.cbu.dao;

import com.dong.cbu.model.Member;

/**
 * Created by zhendong on 2016/4/29.
 * email:myyizhendong@gmail.com
 */
public interface MemberMapper {
    int insertMember(Member member);
    int isMemberExists(Member member);
    Member loginMember(String name);
}

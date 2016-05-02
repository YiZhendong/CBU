package com.dong.cbu.util;




import com.dong.cbu.model.Member;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Rick  E-mail: maodai1990@163.com
 * @version 创建时间：2014-5-16 上午10:06:55
 * 类说明
 */
public class SessionUtil {
	
	private static final String LOGIN_STAFF = "LOGIN_STAFF";

	public static void setLoginMember(HttpServletRequest request, Member member){
		request.getSession().setAttribute(LOGIN_STAFF, member);
	}

	public static Member getLoginMember(HttpServletRequest request){
		return (Member) request.getSession().getAttribute(LOGIN_STAFF);
	}

	public static void removeSession(HttpServletRequest request, Member staff){
		request.getSession().removeAttribute(staff.getName());
		request.getSession().invalidate();
	}
}
 
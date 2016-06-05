package com.dong.cbu.util;

import com.dong.cbu.model.Comment;
import com.dong.cbu.model.CommentPage;
import com.dong.cbu.model.Movie;
import com.dong.cbu.model.MoviePage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhendong on 2016/6/5.
 * email:myyizhendong@gmail.com
 */
public class Pagination{
	private static int defaultPage = 1;
	private static int pageSize = 6;
	private static int totalPage = 0;
	private static int totalRecords = 0;
	private static int finalPage = 0;

	public static MoviePage showMoviePage(List<Movie> movies, int currentPage){
		totalRecords = movies.size();
		if(totalRecords % pageSize == 0){
			totalPage = totalRecords / pageSize;
		}else {
			totalPage = totalRecords / pageSize + 1;
		}
		if(currentPage > totalPage){
			finalPage = totalPage;
			currentPage = finalPage;
		}else if(currentPage <= 0){
			currentPage = defaultPage;
		}
		List<Movie> pageMovie = new ArrayList<Movie>();
		int i, startIndex = (currentPage-1)*pageSize,endIndex = currentPage*pageSize;
		if(endIndex > totalRecords){
			endIndex = totalRecords;
		}
		for(i=startIndex;i<endIndex;i++){
			pageMovie.add(movies.get(i));
		}
		MoviePage moviePage = new MoviePage();
		moviePage.setCurrentPage(currentPage);
		moviePage.setTotalPage(totalPage);
		moviePage.setMovies(pageMovie);
		moviePage.setTotalRecords(totalRecords);
		return moviePage;
	}

	public static CommentPage showCommentPage(List<Comment> comments, int currentPage){
		totalRecords = comments.size();
		if(totalRecords % pageSize == 0){
			totalPage = totalRecords / pageSize;
		}else {
			totalPage = totalRecords / pageSize + 1;
		}
		if(currentPage > totalPage){
			finalPage = totalPage;
			currentPage = finalPage;
		}else if(currentPage <= 0){
			currentPage = defaultPage;
		}
		List<Comment> pageComment = new ArrayList<Comment>();
		int i, startIndex = (currentPage-1)*pageSize,endIndex = currentPage*pageSize;
		if(endIndex > totalRecords){
			endIndex = totalRecords;
		}
		for(i=startIndex;i<endIndex;i++){
			pageComment.add(comments.get(i));
		}
		CommentPage commentPage = new CommentPage();
		commentPage.setCurrentPage(currentPage);
		commentPage.setTotalPage(totalPage);
		commentPage.setComments(pageComment);
		commentPage.setTotalRecords(totalRecords);
		return commentPage;
	}
}

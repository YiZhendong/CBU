package com.dong.cbu.model;

import java.util.List;

/**
 * Created by zhendong on 2016/6/5.
 * email:myyizhendong@gmail.com
 */
public class MoviePage{
	private int currentPage;
	private int totalPage;
	private int totalRecords;
	private List<Movie> movies;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
}

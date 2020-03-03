package com.example.moviecatalogservice.model;

public class MovieInfo {

	private String name;
	private String movieId;
	
	public MovieInfo() {
	}

	public MovieInfo(String name, String movieId) {
		super();
		this.name = name;
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

}

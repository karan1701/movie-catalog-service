package com.example.moviecatalogservice.model;

public class Rating {

	private String moviId;
	private int rating;

	public Rating() {
		
	}
	
	public Rating(String moviId, int rating) {
		super();
		this.moviId = moviId;
		this.rating = rating;
	}

	public String getMoviId() {
		return moviId;
	}

	public void setMoviId(String moviId) {
		this.moviId = moviId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}

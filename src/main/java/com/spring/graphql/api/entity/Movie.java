package com.spring.graphql.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Movie {
	@Id
	private String movieid;
	private String movieName;
	private String releaseDate;
	private String[] actors;
	private String director;
	private String producer;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Movie(String movieid,String movieName,String releaseDate,String[] actors,String director,String producer) {
		this.movieid = movieid;
		this.movieName = movieName;
		this.releaseDate = releaseDate;
		this.actors = actors;
		this.director = director;
		this.producer = producer;
	}

	public String getMovieid() {
		return movieid;
	}

	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String[] getActors() {
		return actors;
	}

	public void setActors(String[] actors) {
		this.actors = actors;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}
	
	
	

}

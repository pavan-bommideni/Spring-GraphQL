package com.spring.graphql.api.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.graphql.api.entity.Movie;
import com.spring.graphql.api.service.MovieService;

import graphql.ExecutionResult;

@RestController
@RequestMapping("/api")
public class MovieSearchController {
	@Autowired
	private MovieService movieService;
	
	/* Get List of Movie with all the fields */
	@GetMapping("/movies")
	public List<Movie> getMovieList() {
		System.out.println("getMovieList invoked");
		return movieService.findAllMovies();
	}

	/*
	 * Get List of Movie with required the fields using graphQL API provided by
	 * Face-book
	 */
	@PostMapping("/graphql-data")
	public ResponseEntity<Object> getAllMovies(@RequestBody String query) throws IOException {
		System.out.println("getAllMovies started GraphQL Execution");
		ExecutionResult result = movieService.executeQuery(query);
		System.out.println("getAllMovies ended GraphQL Execution");
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}

	/*
	 * Get Movie by movie id
	 */
	@GetMapping("/movies/{movieId}")
	public Movie getMovieInfo(@PathVariable String movieId) {
		System.out.println("getMovieInfo invoked");
		return movieService.findMovieById(movieId);
	}
}

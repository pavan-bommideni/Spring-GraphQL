package com.spring.graphql.api.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.graphql.api.entity.Movie;
import com.spring.graphql.api.repository.MovieRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class MovieDataFetcher implements DataFetcher<Movie> {
	@Autowired
	private MovieRepository repository;

	@Override
	public Movie get(DataFetchingEnvironment environment) {
		System.out.println("MovieDataFetcher invoked");
		String movieId = environment.getArgument("id");
		System.out.println("MovieDataFetcher input " + movieId);
		return repository.findOne(movieId);
	}

}

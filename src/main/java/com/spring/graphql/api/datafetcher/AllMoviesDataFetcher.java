package com.spring.graphql.api.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.graphql.api.entity.Movie;
import com.spring.graphql.api.repository.MovieRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllMoviesDataFetcher implements DataFetcher<List<Movie>> {
	@Autowired
	private MovieRepository repository;

	@Override
	public List<Movie> get(DataFetchingEnvironment environment) {
		System.out.println("allMoviesDataFetcher invoked");
		return repository.findAll();
	}

}

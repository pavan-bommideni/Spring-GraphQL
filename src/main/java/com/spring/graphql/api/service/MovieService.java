package com.spring.graphql.api.service;

import java.io.IOException;
import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.graphql.api.configuration.GraphQLUtils;
import com.spring.graphql.api.entity.Movie;
import com.spring.graphql.api.entity.Employee;
import com.spring.graphql.api.repository.EmployeeRespository;
import com.spring.graphql.api.repository.MovieRepository;

import graphql.ExecutionResult;
import graphql.GraphQL;

@Service
public class MovieService {
	@Autowired
	private MovieRepository repository;
	
	@Autowired
	private EmployeeRespository empRepository;

	@Autowired
	private GraphQLUtils graphQLUtils;

	@PostConstruct
	public void initMovies() {
		System.out.println("initMovies invoked PostConstruct");
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie("1", "Tiger Zinda Hai",
				"22-12-2017", new String[] { "Salman Khan", "Katrina Kaif", "Sajjad Delfrooz", "Angad Bedi",
						"Kumud Mishra", "Nawab Shah", "Girish Karnad", "Paresh" },
				"Ali Abbas Zafar", "Yash Raj Films"));
		movies.add(new Movie("2", "Baahubali 2 The Conclusion", "28-04-2017",
				new String[] { "Prabhas", "Sudeep", "Anushka Shetty", "Rana Daggubati", "Tamannaah", "Satyaraj",
						"Ramya Krishnan", "Nassar", "Shriya Saran", "Rohini" },
				"S.S.Rajamouli", "Shobu Yarlagadda and Prasad Devineni"));
		repository.save(movies);
		List<Employee> employees = new ArrayList<>();
		for(int i = 1 ; i<=25; i++ ) {
			employees.add(new Employee(i, "P"+i));
		}
		empRepository.save(employees);
		System.out.println("initMovies PostConstruct ended");
	}

	public List<Movie> findAllMovies() {
		return repository.findAll();
	}
	/**
	 * findMovieById returns the Movie based on Id
	 * @param movieId
	 * @return
	 */
	public Movie findMovieById(String movieId) {
		return repository.findOne(movieId);
	}
	/**
	 * executeQuery runs the GraphQL Query and returns the result
	 * @param query
	 * @return
	 * @throws IOException
	 */
	public ExecutionResult  executeQuery(String query) throws IOException {
		GraphQL graphQL = graphQLUtils.getGraphQLInstanceByResourceName("schema.graphqls");
		return graphQL.execute(query);
	}

}

package com.spring.graphql.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.graphql.api.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, String> {

}

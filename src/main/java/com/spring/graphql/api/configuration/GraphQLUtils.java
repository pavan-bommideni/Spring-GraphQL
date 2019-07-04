package com.spring.graphql.api.configuration;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.spring.graphql.api.datafetcher.AllMoviesDataFetcher;
import com.spring.graphql.api.datafetcher.EmployeesDataFetcher;
import com.spring.graphql.api.datafetcher.MovieDataFetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Component
public class GraphQLUtils {
	
		private GraphQL graphQL;
		
		@Autowired
		ResourceLoader resourceLoader;
		
		@Autowired
		private AllMoviesDataFetcher allMoviesDataFetcher;
		
		@Autowired
		private MovieDataFetcher movieDataFetcher;
		
		@Autowired
		private EmployeesDataFetcher employeesDataFetcher;

		private RuntimeWiring buildRuntimeWiring() {
			System.out.println("buildRuntimeWiring invoked");
			/*
			 * This dataFetcher first argument i.e "allMovies" or "movie" this name
			 * should be same with the field which u declare in your schema.graphqls
			 * in typeQuery section and one more things these 2 field name should be
			 * same which we are sending as part of request query from postman for
			 * Example : { allMovies{pass required field } }
			 */
			return RuntimeWiring.newRuntimeWiring()
					.type("Query", typeWiring -> typeWiring
					.dataFetcher("allMovies", allMoviesDataFetcher)
					.dataFetcher("movie", movieDataFetcher)
					.dataFetcher("employees", employeesDataFetcher))
					.build();
		}
		
		/**
		 * Returns the instance of GraphQL by parsing the schema and executing the Data fetcher's
		 * @param resourceName
		 * @return
		 * @throws IOException
		 */
		public GraphQL getGraphQLInstanceByResourceName(String resourceName) throws IOException {
			System.out.println("getGraphQLInstanceByResourceName invoked");
			Resource resource =  resourceLoader.getResource(ResourceUtils.CLASSPATH_URL_PREFIX+resourceName);
			// get the schema
			File schemaFile = resource.getFile();
			// parse schema
			TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
			RuntimeWiring wiring = buildRuntimeWiring();
			GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
			graphQL = GraphQL.newGraphQL(schema).build();
			return graphQL;
		}
}

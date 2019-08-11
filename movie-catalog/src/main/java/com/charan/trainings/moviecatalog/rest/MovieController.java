package com.charan.trainings.moviecatalog.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charan.trainings.moviecatalog.entity.Movie;
import com.charan.trainings.moviecatalog.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("/all")
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}

	@GetMapping("/name/{name}")
	public List<Movie> getMovieByName(@PathVariable("name") String name) {
		return movieService.getMovieByName(name);
	}
	
	@GetMapping("/director/{name}")
	public List<Movie> getMovieByDirector(@PathVariable("name") String name) {
		return movieService.getMovieByDirector(name);
	}
	
	@GetMapping("/hero/{name}")
	public List<Movie> getMovieByHero(@PathVariable("name") String name) {
		return movieService.getMovieByHero(name);
	}

}

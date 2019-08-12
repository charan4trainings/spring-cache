package com.charan.trainings.moviecatalog.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.charan.trainings.moviecatalog.entity.Movie;
import com.charan.trainings.moviecatalog.repository.MovieRepository;

@Service
public class MovieService {

	private static final Logger log = LoggerFactory.getLogger(MovieService.class);

	@Autowired
	private MovieRepository movieRepository;

	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Cacheable(value = "movieByName", key = "#name")
	public List<Movie> getMovieByName(String name) {
		return fetchMovieByName(name);
	}

	@Cacheable(value = "movieByDirector", key = "#director")
	public List<Movie> getMovieByDirector(String director) {
		return fetchMovieByDirector(director);
	}

	@Cacheable(value = "movieByHero", key = "#hero")
	//@Cacheable(value = "movieByHero", key = "#hero", unless = "#hero != null and #hero.toUpperCase().startsWith('TEST')")
	public List<Movie> getMovieByHero(String hero) {
		return fetchMovieByHero(hero);
	}
	
	@Caching(evict = {@CacheEvict(value = "movieByName", key = "#name")})
	public void removeMovieByName(String name) {
		movieRepository.deleteByName(name);
	}
	
	@Caching(evict = {@CacheEvict(value = "movieByName", allEntries = true)},
	        put = {@CachePut(value = "movieByName", key = "#movie.name")})
	public void update(Movie movie) {
	    movieRepository.save(movie);
	}

	private List<Movie> fetchMovieByName(String name) {
		try {
			Thread.sleep(3000);
			return movieRepository.findByName(name);
		} catch (Exception e) {
			log.error("Exception occurred : ", e);
			return new ArrayList<>();
		}
	}

	private List<Movie> fetchMovieByDirector(String director) {
		try {
			Thread.sleep(3000);
			return movieRepository.findByDirector(director);
		} catch (Exception e) {
			log.error("Exception occurred : ", e);
			return new ArrayList<>();
		}
	}

	private List<Movie> fetchMovieByHero(String hero) {
		try {
			Thread.sleep(3000);
			return movieRepository.findByHero(hero);
		} catch (Exception e) {
			log.error("Exception occurred : ", e);
			return new ArrayList<>();
		}
	}

}

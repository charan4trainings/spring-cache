package com.charan.trainings.moviecatalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charan.trainings.moviecatalog.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	List<Movie> findByName(String name);

	List<Movie> findByHero(String hero);

	List<Movie> findByDirector(String director);

}

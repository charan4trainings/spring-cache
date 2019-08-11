package com.charan.trainings.moviecatalog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIES")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DIRECTOR")
	private String director;
	
	@Column(name = "HERO")
	private String hero;
	
	@Column(name = "HEROINE")
	private String heroine;
	
	@Column(name = "LANGUAGE")
	private String language;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director
	 *            the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * @return the hero
	 */
	public String getHero() {
		return hero;
	}

	/**
	 * @param hero
	 *            the hero to set
	 */
	public void setHero(String hero) {
		this.hero = hero;
	}

	/**
	 * @return the heroine
	 */
	public String getHeroine() {
		return heroine;
	}

	/**
	 * @param heroine
	 *            the heroine to set
	 */
	public void setHeroine(String heroine) {
		this.heroine = heroine;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

}

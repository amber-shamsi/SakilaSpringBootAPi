package com.example.sakiladbapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actor")
@Getter
@Setter
public class Actor {
	public Actor(String firstName, String lastName) {

	}

	public Actor() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "actor_id")
	private Short id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Getter
	@ManyToMany
	@JoinTable(
			name = "film_actor",
			joinColumns = {@JoinColumn(name = "film_id")},
			inverseJoinColumns = {@JoinColumn(name = "actor_id")}
	)
	@ToString.Exclude
	@JsonIgnore
	@Setter(AccessLevel.NONE)
	private List<Film> films = new ArrayList<>();
}

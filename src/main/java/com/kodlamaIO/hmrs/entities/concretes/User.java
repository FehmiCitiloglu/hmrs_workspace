package com.kodlamaIO.hmrs.entities.concretes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")

public class User {

	@Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "user_sequence"
    )
	private Long id;
	
	
	@NotNull(message = "Password can not be blank")
	@NotBlank(message = "password can not be blank")
	@Size(min = 6, message = "Password lenght can not be less than 6 characters")
	@Column(name = "user_password")
	private String password;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<JobSeekers> jobSeekers;

	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<JobCreator> jobCreator;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Experience> experiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<School> schools;
}

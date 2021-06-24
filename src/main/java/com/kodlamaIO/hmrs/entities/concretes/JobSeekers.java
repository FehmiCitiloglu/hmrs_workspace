package com.kodlamaIO.hmrs.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.kodlamaIO.hmrs.entities.dtos.CurriculumVitae;
import com.sun.istack.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_seeker")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")


public class JobSeekers {
	
	@Id
    @SequenceGenerator(
            name = "jobseeker_sequence",
            sequenceName = "jobseeker_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "jobseeker_sequence"
    )
    @Column(name = "jobseeker_id")
	private Long id;
	
	@NotNull
	@Column(name = "first_name")
	private String firstName;
	
	
	@NotNull
	@Column(name = "last_name")
	private String lastName;
	
	@NotBlank(message = "Email can not be blank")
	@NotNull
	@Size(min = 10, max = 255)
	@Email(message = "Please enter a valid email address")
	@Column(name = "email", unique = true)
	private String individualEmail;
	
	@NotNull
	@NotBlank
	@Column(name = "national_id", unique = true)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "^[1-9]{1}[0-9]{9}[02468]{1}$")
	private String nationalId;
	

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "jobSeekers")
//	private List<CurriculumVitae> curriculumVitaes;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<Experience> experiences;

}

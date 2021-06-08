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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_creator")
//@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class JobCreator{
	
	@Id
	@SequenceGenerator(
			name = "job_creator_sequence",
			sequenceName = "job_creator_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.IDENTITY,
			generator = "job_creator_sequence"
			)
	private Long id;

	@NotBlank
	@Size(max = 100, min = 10)
	@Column(name = "company_name", unique = true)
	private String companyName;
	
	@NotBlank
	@Size(min = 10, max = 100)
	@Column(name = "website", unique = true)
	private String webSite;
	
	
	@NotBlank(message = "Email can not be blank")
	@Column(name ="company_email", unique = true)
	private String companyEmail;
	
	// regex => phone number with parantheses and international prefix
//	@Pattern(regexp =
//			"^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" 
//			, message = "Please enter a valid phone number")
	@Column(name = "phone", unique = true)
	private String phoneString;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobCreator")
	private List<JobPosting> jobPostings;
	

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}

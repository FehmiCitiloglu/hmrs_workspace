//package com.kodlamaIO.hmrs.entities.dtos;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumns;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//import javax.validation.constraints.Max;
//
//import com.kodlamaIO.hmrs.entities.concretes.Experience;
//import com.kodlamaIO.hmrs.entities.concretes.JobSeekers;
//import com.kodlamaIO.hmrs.entities.concretes.ProgrammingLanguage;
//import com.kodlamaIO.hmrs.entities.concretes.School;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//
//@Table(name = "curriculum_vitae")
//@AllArgsConstructor
//@NoArgsConstructor
//public class CurriculumVitae {
//	@Id
//	@SequenceGenerator(
//			name = "cirriculum_vitae_sequence",
//			sequenceName = "cirriculum_vitae_sequence",
//			allocationSize = 1
//			)
//	@GeneratedValue(
//			strategy = GenerationType.IDENTITY,
//			generator = "cirriculum_vitae_sequence"
//			)
//	private int id;
//
//	@Column(name = "github_adress")
//	@Max(100)
//	private String githubAdress;
//
//	@Column(name = "linkedin_adress")
//	@Max(100)
//	private String linkedinAdress;
//
//	@Column(name = "summary")
//	private String summary;
//
//
//	@ManyToOne
//	@JoinColumns({
//		@JoinColumn(name = "id"),
//		@JoinColumn(name = "email"),
//		@JoinColumn(name = "first_name"),
//	})
//	private JobSeekers jobSeekers;
//
//	@ManyToOne
//	@JoinColumn(name = "id")
//	private ProgrammingLanguage programmingLanguage;
//
//	@ManyToOne
//	@JoinColumn(name = "school_id")
//	private School school;
//
//	@ManyToOne
//	@JoinColumns({
//		@JoinColumn(name = "experience_id"),
//		@JoinColumn(name = "which_company"),
//		@JoinColumn(name = "position"),
//		@JoinColumn(name = "still_working"),
//
//	})
//	private Experience experience;
//
//
//}

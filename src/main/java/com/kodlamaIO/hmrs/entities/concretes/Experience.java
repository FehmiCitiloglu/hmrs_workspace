package com.kodlamaIO.hmrs.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kodlamaIO.hmrs.entities.dtos.CurriculumVitae;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Table(name="experience")
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Experience {
	
	@Id
    @SequenceGenerator(
            name = "experience_sequence",
            sequenceName = "experience_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "experience_sequence"
    )
	private int experienceId;
	

	@Column(name = "do_you_have_experince")
	private boolean doYouHaveExperience;
	
	@Max(100)
	@Column(name = "which_company")
	private String whichCompany;

	
	@Column(name = "position")
	@Max(50)
	private String position;
	
	@Column(name = "begin_date")
	private LocalDate beginDate;
	
	@Column(name = "still_working")
	private boolean stillWorking;
	
	@Column(name = "quit_date")
	private LocalDate quitDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "id", referencedColumnName = "jobseeker_id")
	private JobSeekers jobSeeker;
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "experience")
//	private List<CurriculumVitae> curriculumVitaes;

}

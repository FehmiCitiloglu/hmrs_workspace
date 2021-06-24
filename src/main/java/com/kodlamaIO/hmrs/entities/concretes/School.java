package com.kodlamaIO.hmrs.entities.concretes;


import java.time.LocalDate;
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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kodlamaIO.hmrs.entities.dtos.CurriculumVitae;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "school")
@AllArgsConstructor
@NoArgsConstructor
public class School {

	@Id
    @SequenceGenerator(
            name = "school_sequence",
            sequenceName = "school_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "school_sequence"
    )
	private int schoolId;
	
	@NotNull
	@NotBlank
	@Column(name = "school_name")
	private String schoolName;
	
	@NotNull
	@NotBlank
	@Column(name = "department")
	private String department;
	
	@Column(name = "is_finish")
	private boolean isFinish;
	
	@Column(name = "finish_date")
	private LocalDate finishDate;

	@Column(name = "begin_date")
	private LocalDate beginDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "school")
//	private List<CurriculumVitae> curriculumVitaes;
	
}

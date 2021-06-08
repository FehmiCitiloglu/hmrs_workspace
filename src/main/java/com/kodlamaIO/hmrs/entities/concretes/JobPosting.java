package com.kodlamaIO.hmrs.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_posting")
@AllArgsConstructor
@NoArgsConstructor
public class JobPosting {
	@Id
    @SequenceGenerator(
            name = "post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "post_sequence"
    )
    @Column(name = "post_id")
	private int postId;
	
	@NotNull
	@Column(name = "position")
	private String position;

	@NotBlank
	@NotNull
	@Column(name = "description")
	@Size(max = 500, min = 10)
	private String description;
	
//	@NotBlank
//	@Column(name = "city")
//	private String city;
	
	@NotNull
	@Column(name = "open_positions")
	private int openPositions;
	
	@NotNull
	@Column(name = "deadline")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate deadline;
	
	@NotNull
	@Column(name = "is_open")
	private boolean isOpen;
	
	@Column(name = "wage_min")
	private double wageMin;
	
	@Column(name = "wage_max")
	private double wageMax;
	
	@CreationTimestamp
	// @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]") //stackoverflow's code
	@Column(name = "release_date")
	private LocalDate releaseDate = LocalDate.now();
	
	
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "job_position_id")
	private JobPositions jobPositions;
	
	@ManyToOne
	@JoinColumn(name = "company_name")
	private JobCreator jobCreator;
	
}

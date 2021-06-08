package com.kodlamaIO.hmrs.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_positions")

public class JobPositions {
	@Id
	@SequenceGenerator(
			name = "job_sequence",
			sequenceName = "job_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.IDENTITY,
			generator = "job_sequence"
			)
	@Column(name = "job_position_id")
	private Long jobPositionId;
	
	@NotNull
	@Column(name = "job_position")
	private String jobPosition;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobPositions", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private List<JobPosting> jobPostings;
}

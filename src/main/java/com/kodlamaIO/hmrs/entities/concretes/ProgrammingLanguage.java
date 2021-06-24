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
import javax.validation.constraints.Max;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kodlamaIO.hmrs.entities.dtos.CurriculumVitae;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "programming_language")
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguage {

	@Id
	@SequenceGenerator(
			name = "programming_language_sequence",
			sequenceName = "programming_language_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.IDENTITY,
			generator = "programming_language_sequence"
			)
	private int id;
	
	@Column(name = "language_name")
	@Max(50)
	private String languageName;
	
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "programmingLanguage")
//	private List<CurriculumVitae> curriculumVitaes;
}

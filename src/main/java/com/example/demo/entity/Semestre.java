package com.example.demo.entity;



import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="SEMESTRE")
public class Semestre {
	@Id
	@Column(name = "ID_SEMESTRE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSemestre")
    @SequenceGenerator(name = "seqSemestre", allocationSize = 1, sequenceName = "SEQ_SEMESTRE")
    private Integer id;
	
	@Column(name = "NOMBRE_SEMESTRE")
	@NotNull @NotBlank    
    private String nombresemeste;





	public Semestre(Integer id) {
		super();
		this.id = id;
	}	
	
	
}

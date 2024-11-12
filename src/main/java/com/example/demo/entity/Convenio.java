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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="CONVENIO")
public class Convenio {
	@Id
	@Column(name = "ID_CONVENIO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqConvenio")
    @SequenceGenerator(name = "seqConvenio", allocationSize = 1, sequenceName = "SEQ_CONVENIO")
    private Integer id;
	
	@Column(name = "NOMBRE_CONVENIO")
	@NotNull @NotBlank    
    private String nombreconvenio;
	
	
//TODO RELACIONES 	
	
		//RELACION ENTRE CONVENIO Y TIPO_CONVENIO
		@ManyToOne
		@JoinColumn(name="ID_TIPO_CONVENIO", nullable = false)
		private Tipo_Convenio tipo_Convenio;



		public Convenio(Integer id) {
			super();
			this.id = id;
		}
		
		
}

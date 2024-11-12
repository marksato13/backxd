package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name="CORDINADORA")
public class Cordinadora {
	@Id
	@Column(name = "ID_CORDINADORA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCordinadora")
    @SequenceGenerator(name = "seqCordinadora", allocationSize = 1, sequenceName = "SEQ_CORDINADORA")
    private Integer id;
	
	@Column(name = "CODIGO_CORDINADORA")
	@NotNull @NotBlank    
    private String codigocordinadora;
	

    @OneToOne
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "ID_PERSONA")
    private Persona persona;

}

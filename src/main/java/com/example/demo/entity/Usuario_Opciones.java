package com.example.demo.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
@Table(name="USUARIO_OPCIONES")
public class Usuario_Opciones {
	@Id
	@Column(name = "ID_USUARIO_OPCIONES")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUsuario_Opciones")
    @SequenceGenerator(name = "seqUsuario_Opciones", allocationSize = 1, sequenceName = "SEQ_USUARIO_OPCIONES")
    private Integer id;
	
	
//TODO RELACIONES 	

		@ManyToOne
		@JoinColumn(name="ID_OPCIONES", nullable = false)
		private Opciones opciones;
	
		@ManyToOne
		@JoinColumn(name="ID_USUARIO", nullable = false)
		private Usuario usuarios;
	
}

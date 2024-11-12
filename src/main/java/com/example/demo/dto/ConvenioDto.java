package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               
@AllArgsConstructor 
@NoArgsConstructor  
public class ConvenioDto {
	
    private String nombreconvenio; // Un campo que representa el nombre del convenio.
    
    private int tipo_Convenio;     // Un campo que representa el tipo de convenio (se espera un entero).

}

				//TODO:APUNTES DE MARK
				//se utiliza para transferir datos relacionados con un convenio
                //desde el cliente TODO(aplicación Angular) al servidor  TODO(controlador de Spring Boot). 
				//DATA TRANFORN OBJETH	
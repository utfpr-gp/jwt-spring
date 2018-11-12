package br.edu.utfpr.jwt.model.dto;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * DTO para receber os dados de login.
 * @author ronifabio
 *
 */
@Data
@NoArgsConstructor
public class JwtAuthenticationDTO {
	
	@NotEmpty(message = "O email não pode ser vazio.")
	@Email(message = "O email é inválido.")
	private String email;
	
	@NotEmpty(message = "A senha não pode ser vazia.")
	private String password;

}

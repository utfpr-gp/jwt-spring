package br.edu.utfpr.jwt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.edu.utfpr.jwt.security.ProfileEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Entidade JPA para salvar as credenciais do usuário no BD.
 * @author ronifabio
 *
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private ProfileEnum profile;

}

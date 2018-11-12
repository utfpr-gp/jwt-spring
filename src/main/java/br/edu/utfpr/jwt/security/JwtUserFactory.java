package br.edu.utfpr.jwt.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.edu.utfpr.jwt.model.User;

/**
 * 
 * Converte o usuário no formato de usuário suportado pelo Spring
 * @author ronifabio
 *
 */
public class JwtUserFactory {
	
	private JwtUserFactory() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * Converte e gera um JwtUser com base nos dados de um usuário.
	 * 
	 * @param user
	 * @return
	 */
	public static JwtUser create(User user) {
		return new JwtUser(user.getId(), user.getEmail(), user.getPassword(), 
				mapToGrantedAuthorithies(user.getProfile()));
	}
	
	/**
	 * 
	 * Converte o perfil do usuário para o formato utilizado pelo Spring Security.
	 *
	 * @param profileEnum
	 * @return
	 */
	private static List<GrantedAuthority> mapToGrantedAuthorithies(ProfileEnum profileEnum){
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
		return authorities;
	}

}

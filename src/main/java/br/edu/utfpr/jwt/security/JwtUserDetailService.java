package br.edu.utfpr.jwt.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.utfpr.jwt.model.User;
import br.edu.utfpr.jwt.model.service.UserService;

/**
 * 
 * Serviço para implementar a interface do UserDetailsService.
 * É usada para buscar o UserDetails a partir dos dados do usuário.
 * @author ronifabio
 *
 */
@Service
public class JwtUserDetailService implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userOptional = userService.findByEmail(username);
		
		if(userOptional.isPresent()) {
			return JwtUserFactory.create(userOptional.get());
		}
		
		throw new UsernameNotFoundException("Email não encontrado!");
	}

}

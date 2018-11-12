package br.edu.utfpr.jwt.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.jwt.model.User;
import br.edu.utfpr.jwt.model.UserRepository;

/**
 * 
 * Serviço para uso do repositório de usuário.
 * É usado no processo de autenticação e autorização
 * @author ronifabio
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public Optional<User> findByEmail(String email){
		return Optional.ofNullable(this.userRepository.findByEmail(email));
	}
}

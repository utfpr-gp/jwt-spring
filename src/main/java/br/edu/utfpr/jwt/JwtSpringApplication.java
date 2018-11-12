package br.edu.utfpr.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.edu.utfpr.jwt.model.User;
import br.edu.utfpr.jwt.model.UserRepository;
import br.edu.utfpr.jwt.security.ProfileEnum;
import br.edu.utfpr.jwt.util.PasswordUtil;

@SpringBootApplication
public class JwtSpringApplication {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(JwtSpringApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			User user = new User();
			user.setEmail("admin@utfpr.edu.br"); 
			user.setProfile(ProfileEnum.ROLE_ADMIN);
			user.setPassword(PasswordUtil.generateBCrypt("qwerty"));
			userRepository.save(user);
			
			user = new User();
			user.setEmail("user@utfpr.edu.br"); 
			user.setProfile(ProfileEnum.ROLE_USER);
			user.setPassword(PasswordUtil.generateBCrypt("qwerty"));
			userRepository.save(user);
		};
	}
}

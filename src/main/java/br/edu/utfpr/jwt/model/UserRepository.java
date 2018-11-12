package br.edu.utfpr.jwt.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * Repositório para o Usuário.
 * Por ser somente leitura, utiliza a anotação com atributo readOnly para dispensar 
 * acesso transacional.
 * @author ronifabio
 *
 */
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
}

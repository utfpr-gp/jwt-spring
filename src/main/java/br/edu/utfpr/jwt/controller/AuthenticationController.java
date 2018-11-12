package br.edu.utfpr.jwt.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.jwt.model.dto.JwtAuthenticationDTO;
import br.edu.utfpr.jwt.model.dto.TokenDTO;
import br.edu.utfpr.jwt.util.JwtTokenUtil;
import br.edu.utfpr.jwt.util.Response;


@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthenticationController {
	private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
	private static final String TOKEN_HEADER = "Authorization";
	private static final String BEARER_PREFIX = "Bearer ";
	
	@Autowired
	private AuthenticationManager authenticationManager;
		
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@PostMapping
	public ResponseEntity<Response<TokenDTO>> generateToken(@Valid @RequestBody JwtAuthenticationDTO authenticationDTO, BindingResult result)  throws AuthenticationException{
		Response<TokenDTO> response = new Response<>();		
		
		if(result.hasErrors()) {
			log.error("Erro {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationDTO.getEmail(), authenticationDTO.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationDTO.getEmail());
		String token = jwtTokenUtil.generateToken(userDetails);
		response.setData(new TokenDTO(token));
		
		return ResponseEntity.ok(response);
	}
	
	
}

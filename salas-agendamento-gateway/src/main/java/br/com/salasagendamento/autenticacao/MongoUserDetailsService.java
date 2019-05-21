package br.com.salasagendamento.autenticacao;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MongoUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		String cpf = "37765289829";
		String senhaBanco = "$2a$10$i7Gyiukp5L19wQ7NxSaRVObCC3/uCeHmn4AyysIQbzUPFn1wGg6Uu";

		if (cpf == null) {
			throw new UsernameNotFoundException("User not found");
		}

		List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));

		return new User(cpf, senhaBanco, authorities);
	}

}

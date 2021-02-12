package com.javainuse.springbootsecurity.config;

import java.util.Arrays;
import java.util.List;

import com.javainuse.springbootsecurity.model.DAORole;
import com.javainuse.springbootsecurity.repository.RoleRepository;
import com.javainuse.springbootsecurity.responses.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.javainuse.springbootsecurity.model.DAOUser;
import com.javainuse.springbootsecurity.model.dto.UserDTO;
import com.javainuse.springbootsecurity.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;


	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = null;

		DAOUser user = userRepository.findByUsername(username);
		if (user != null) {
			roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole().getName()));
			return new User(user.getUsername(), user.getPassword(), roles);
		}
		throw new UsernameNotFoundException("User not found with the name " + username);	}
	
	public DAOUser save(UserDTO user, ResponseStatus status) {
		DAORole role = roleRepository.findByName(user.getRole());
		if(role == null){
			status.setMsg("Invalid Role.");
			return null;
		}
		DAOUser newUser = userRepository.findByUsername(user.getUsername());
		if(newUser != null){
			status.setMsg("User already exists.");
			return null;
		}else {
			newUser = new DAOUser();
		}
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setRole(role);
		return userRepository.save(newUser);
	}

}

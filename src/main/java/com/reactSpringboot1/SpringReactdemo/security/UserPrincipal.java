package com.reactSpringboot1.SpringReactdemo.security;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.reactSpringboot1.SpringReactdemo.modal.User;

public class UserPrincipal implements UserDetails {

	private Long id;
	
	private String name;
	
	private String username;
	
	private String email;
	
	private String password;
	
	
	
	
	
	//@Override
	private Collection<? extends GrantedAuthority> authorities;

	public UserPrincipal(Long id, String name, String username, String email,
			String password,  Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public static UserPrincipal create(User user){
		
		List<GrantedAuthority>authorities = user.getRoles().stream().map(role -> 
		new SimpleGrantedAuthority(role.getName().name())
		        ).collect(Collectors.toList());
		
		return new UserPrincipal(
				
				user.getId(),
				
				user.getName(),
				
				user.getEmail(),
				
				user.getUsername(),
				
				user.getPassword(),
				
				authorities);
	
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean equals(Object o) {
		
		if (this == o) return true;
		
		if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
		
	}
	  @Override
	    public int hashCode() {

	        return Objects.hash(id);
}
}

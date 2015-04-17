package so.pickme.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import so.pickme.domain.User;
import so.pickme.repository.UserRepository;
import so.pickme.service.PassEncoder;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	PassEncoder pe;
	
	@Resource
	private UserRepository repository;
	

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();
		System.out.println(name);
		System.out.println(password);
		User u=repository.findByUsername(name);
		
		if (name.equals(u.getUsername().trim()) && PassEncoder.passDecoder().matches(password, u.getPassword().trim())) {
			List<GrantedAuthority> grantedAuths = getGrantedAuthorities(getRoles(u.getRole().getRole())); 
			
//			List<GrantedAuthority> grantedAuths = new ArrayList<>();
//			grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
			Authentication auth = new UsernamePasswordAuthenticationToken(name,
				password, grantedAuths);
			return auth;
		} else {
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	
	/**
	 * Converts a numerical role to an equivalent list of roles.
	 * 
	 * @param role the numerical role
	 * @return list of roles as as a list of {@link String}
	 */
	public List<String> getRoles(Integer role) {
		List<String> roles = new ArrayList<String>();
		System.out.println(role.intValue());
		if (role.intValue() == 1) {
			roles.add("ROLE_USER");
			roles.add("ROLE_ADMIN");
			System.out.println("Roles admin and user assigned");
			
		} else if (role.intValue() == 2 || role.intValue() == 3 || role.intValue() == 4 || role.intValue() == 5 ) {
			System.out.println("roles added");
			roles.add("ROLE_USER");
			System.out.println("Role user assigned");
		//	roles.add("ROLE_ADMIN");
		}
		
		return roles;
	}
	
	/**
	 * Wraps {@link String} roles to {@link SimpleGrantedAuthority} objects.
	 * 
	 * @param roles {@link String} of roles
	 * @return list of granted authorities
	 */
	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}
}

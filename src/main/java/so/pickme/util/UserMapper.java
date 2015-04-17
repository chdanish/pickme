package so.pickme.util;

import java.util.ArrayList;
import java.util.List;

import so.pickme.domain.User;
import so.pickme.response.UserDto;

import org.springframework.data.domain.Page;

public class UserMapper {

	public static UserDto map(User user) {
			UserDto dto = new UserDto();
			dto.setId(user.getId());
			dto.setFirstName(user.getFirstName());
			dto.setLastName(user.getLastName());
			dto.setUsername(user.getUsername());
			dto.setRole(user.getRole().getRole());
			return dto;
	}
	
	public static User map(UserDto dto) {
		User user = new User();
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setUsername(dto.getUsername());
		user.setEmail(dto.getEmail());
		
//		PasswordEncoder encoder = new Md5PasswordEncoder();
//		PasswordEncoder encoder = new BCryptPasswordEncoder(12);
		
//		user.setPassword(encoder.encode(dto.getPassword()));
		user.setPassword(dto.getPassword());
		return user;
}
	
	public static List<UserDto> map(Page<User> users) {
		List<UserDto> dtos = new ArrayList<UserDto>();
		for (User user: users) {
			dtos.add(map(user));
		}
		return dtos;
	}
}

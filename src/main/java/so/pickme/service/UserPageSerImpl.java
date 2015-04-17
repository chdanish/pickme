package so.pickme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import so.pickme.domain.User;
import so.pickme.repository.UserRepository;

/**
 * Implementation of the {@link PersonService}.
 * 
 * @author Thibault Duchateau
 */
@Service
public class UserPageSerImpl implements UserPageService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public List<User> findLimited(int maxResult) {
		List<User> users= userRepository.findAll();
		return users.subList(0, maxResult);
	}
	
	public Boolean delete(User user) {
		User existingUser = userRepository.findOne(user.getId());
		if (existingUser == null) 
			return false;
		
		userRepository.delete(existingUser);
		User deletedUser = userRepository.findOne(user.getId());
		if (deletedUser != null) 
			return false;
		
		return true;
	}
}
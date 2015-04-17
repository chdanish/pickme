package so.pickme.repository;

import java.util.List;

import so.pickme.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	

	/**
	 * @return the complete list of persons stored in the repository.
	 */
	User findByUsername(String username);
	
	/**
	 * @param maxResult
	 *            Max number of persons.
	 * @return a limited list of persons.
	 */
	public List<User> findAll();
	
}

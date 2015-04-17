package so.pickme.service;

import java.util.List;

import so.pickme.domain.User;

/**
 * <p>
 * Person service mostly used as a facade for all controllers.
 * 
 * @author Thibault Duchateau
 */
public interface UserPageService {

	/**
	 * @return the complete list of persons.
	 */
	public List<User> findAll();

	/**
	 * @param maxResult
	 *            Max number of persons.
	 * @return a maxResult limited list of persons.
	 */
	public List<User> findLimited(int maxResult);
}
package org.codingpedia.demo.rest.dao;

import java.util.List;

import org.codingpedia.demo.rest.entities.User;

/**
 * 
 * @author ama
 * @see <a href="http://www.codingpedia.org/ama/spring-mybatis-integration-example/">http://www.codingpedia.org/ama/spring-mybatis-integration-example/</a>
 */
public interface UserDao {
	
	public List<User> getUsers();

	/**
	 * Returns a podcast given its id
	 * 
	 * @param user_id
	 * @return
	 */
	public User getUserById(Long user_id);

	public Long deleteUserById(Long user_id);

	public Long createUser(User user);

	public int updateUser(User user);

	/** removes all Users */
	public void deleteUsers();

}

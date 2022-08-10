/**
 * 
 */
package com.greatLearning.Lab6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatLearning.Lab6.entity.User;

/**
 * @author User
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("FROM User u where u.username=?1")
	public User getUserByUsername(String username);
}

package com.wipro.user.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wipro.user.entity.User;
@Repository
public interface UserRepo extends CrudRepository<User,Long>{

	@Query(value="select * from user where email=:username",nativeQuery=true)
	User findByEmail(@Param("username")String username);

}

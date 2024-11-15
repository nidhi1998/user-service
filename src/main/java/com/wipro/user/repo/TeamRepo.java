package com.wipro.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wipro.user.entity.Team;
@Repository
public interface TeamRepo extends CrudRepository<Team,Long> {
	@Query(value="select * from team where name=:name",nativeQuery=true)
	Team findByName(@Param("name")String name);
	@Query(value="select * from team where createdBy=:userId",nativeQuery=true)
	List<Team> findAllByAdmin(@Param("userId")String userId);

}

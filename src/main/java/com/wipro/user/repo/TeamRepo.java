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
	@Query(value="select * from team where id in (select team_id from team_user_mapping where user_id=:userId)",nativeQuery=true)
	List<Team> findAllByAdmin(@Param("userId")String userId);
	@Query(value="select * from team where id=:id",nativeQuery=true)
	Team findByIdTeam(@Param("id")Long teamId);

}

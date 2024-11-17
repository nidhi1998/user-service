package com.wipro.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wipro.user.entity.Task;

@Repository

public interface TaskRepo extends CrudRepository<Task,Long> {

	@Query(value="select * from task where created_by=:userId",nativeQuery=true)
	List<Task> findUserTask(@Param("userId")String userId);
	@Query(value="select * from task where assign=:userId and team=:teamid",nativeQuery=true)
	List<Task> findUserTeamTask(@Param("userId")String userId,@Param("teamid")String teamId);
	@Query(value="select * from task where created_by=:userId and (assign is null or team is null)",nativeQuery=true)
	List<Task> findAdminTask(String userId);
	@Query(value="select * from task where created_by=:userId and team=:teamId",nativeQuery=true)
	List<Task> findAdminTeamTask(@Param("userId")String userId, @Param("teamId")String team);
	@Query(value="select count(*) from task where created_by=:userId and team=:teamId and status='Pending'",nativeQuery=true)
	int findPendingteamTask(@Param("userId")String userId, @Param("teamId")String team);
	@Query(value="select count(*) from task where created_by=:userId and team=:teamId and status='In Progress'",nativeQuery=true)
	int findInprogressTask(@Param("userId")String userId, @Param("teamId")String team);
	@Query(value="select count(*) from task where created_by=:userId and team=:teamId and status='Completed'",nativeQuery=true)
	int findCompleteTask(@Param("userId")String userId, @Param("teamId")String team);
	

}

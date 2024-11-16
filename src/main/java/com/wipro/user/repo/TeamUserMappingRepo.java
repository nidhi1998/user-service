package com.wipro.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wipro.user.entity.TeamUserMapping;
@Repository
public interface TeamUserMappingRepo extends JpaRepository<TeamUserMapping, Long> {
@Query(value="select * from team_user_mapping where team_id=:teamId",nativeQuery=true)
	List<TeamUserMapping> findByTeamId(@Param("teamId")Long teamId);
@Query(value="select * from team_user_mapping where team_id=:teamId and user_id=:userId",nativeQuery=true)
TeamUserMapping findByTeamIdandUserId(@Param("teamId")Long teamId, @Param("userId")Long userId);
}

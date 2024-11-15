package com.wipro.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.user.entity.Task;

@Repository

public interface TaskRepo extends CrudRepository<Task,Long> {

}

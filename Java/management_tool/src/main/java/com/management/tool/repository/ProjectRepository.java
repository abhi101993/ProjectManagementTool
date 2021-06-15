package com.management.tool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.management.tool.entity.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long>{

	@Override
	Iterable<Project> findAllById(Iterable<Long> ids);

	
}

package com.management.tool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.tool.entity.Project;
import com.management.tool.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService
{
    @Autowired
    ProjectRepository projectRepository;
    
	@Override
	public Project saveOrUpdateProject(Project project) 
	{
		return projectRepository.save(project);
	}

}

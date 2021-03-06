package com.management.tool.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.tool.entity.Project;
import com.management.tool.service.ProjectService;
import com.management.tool.utility.MapValidationErrorUtility;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

@Autowired
ProjectService projectService;

@Autowired
MapValidationErrorUtility mapValidationErrorUtility;

@PostMapping("/createProject")
public ResponseEntity<?> createProject(@Valid @RequestBody Project project,BindingResult result)
{ 
	 if(result.hasErrors())
	 {
		 
		 return mapValidationErrorUtility.mapValidationService(result);
	 }
	
	project = projectService.saveOrUpdateProject(project);
	return new ResponseEntity<Project>(project,HttpStatus.CREATED);
	
}

}

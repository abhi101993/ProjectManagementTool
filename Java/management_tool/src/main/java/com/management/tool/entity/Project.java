package com.management.tool.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Project")
public class Project {

@Id
@Column(name="id")
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;


@Column(name="project_name")
@NotBlank(message="Project name is required")
private String projectName;

@Column(name="project_id",updatable=false,unique=true)
@NotBlank(message="Project identifier is required")
@Size(min=4,max=5,message="Please use 4 to 5 characters")
private String projectIdentifier;

@Column(name="description")
@NotBlank(message="Project description is required")
private String description;

@Column(name="start_date")
@JsonFormat(pattern="yyyy-mm-dd")
private Date startDate;


@Column(name="end_date")
@JsonFormat(pattern="yyyy-mm-dd")
private Date endDate;

@Column(name="created_at")
@JsonFormat(pattern="yyyy-mm-dd")
private Date createdAt;

@Column(name="updated_at")
@JsonFormat(pattern="yyyy-mm-dd")
private Date updatedAt;

Project()
{
	
}

@PrePersist
protected void onCreate()
{
	this.createdAt = new Date();
}

@PreUpdate
protected void onUpdate()
{
	this.createdAt = new Date();
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getProjectName() {
	return projectName;
}

public void setProjectName(String projectName) {
	this.projectName = projectName;
}

public String getProjectIdentifier() {
	return projectIdentifier;
}

public void setProjectIdentifier(String projectIdentifier) {
	this.projectIdentifier = projectIdentifier;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Date getStartDate() {
	return startDate;
}

public void setStartDate(Date startDate) {
	this.startDate = startDate;
}

public Date getEndDate() {
	return endDate;
}

public void setEndDate(Date endDate) {
	this.endDate = endDate;
}

public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public Date getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}



}

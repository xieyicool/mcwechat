package com.mchr.wechat.entity;

public class Job {
	
	public int id;
	public String title;
	public String description;
	public String Requirement;
	public String Courses;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRequirement() {
		return Requirement;
	}
	public void setRequirement(String requirement) {
		Requirement = requirement;
	}
	public String getCourses() {
		return Courses;
	}
	public void setCourses(String courses) {
		Courses = courses;
	}

	
}

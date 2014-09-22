package com.acxiom.crashcourse.projects;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ProjectsRepository {
	private final List<Project> projects;
	
	public ProjectsRepository() {
		this.projects = new ArrayList<>();
	}

	public List<Project> getProjectList(final String keyword) {
		if(keyword != null && !keyword.isEmpty()){
			List<Project> matching = filterProjects(keyword);
			
			return matching;
		}else{
			return new ArrayList<>(projects);
		}
		
	}

	public Project getProject(final int projectId) {
		for (Project project : projects) {
			if(project.getId() == projectId){
				return project;
			}
		}
		return null;
	}
	
	public Project saveProject(Project project) {
		projects.add(project);
		return project;
	}
	
	private List<Project> filterProjects(String keyword) {
		List<Project> matching = new ArrayList<>();
		for (Project project : projects) {
			if(project.getProjectName().contains(keyword) || project.getProjectDescription().contains(keyword)){
				matching.add(project);
			}
		}
		return matching;
	}

}

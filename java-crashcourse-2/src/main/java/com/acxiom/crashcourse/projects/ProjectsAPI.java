package com.acxiom.crashcourse.projects;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/projects")
public class ProjectsAPI {
	
	private final ProjectsRepository repository;
	
	@Autowired
	public ProjectsAPI(ProjectsRepository repository) {
		this.repository = repository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Project> getProjectList(@RequestParam(required=false, value="keyword") String keyword){
		return this.repository.getProjectList(keyword);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Project addProject(@RequestBody Project project){
		return this.repository.saveProject(project);
	}
	
	@RequestMapping(value="/{projectId}", method = RequestMethod.GET)
	public ResponseEntity<Project> getProject(@PathVariable("projectId") int projectId){
		Project project = this.repository.getProject(projectId);
		HttpHeaders responseHeaders = new HttpHeaders();
		
		if(project!=null){
			 return new ResponseEntity<Project>(project, responseHeaders, HttpStatus.OK);
		}else{
			 return new ResponseEntity("No project found with id "+projectId, responseHeaders, HttpStatus.NOT_FOUND);
		}
	}
}

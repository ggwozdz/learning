package com.acxiom.crashcourse.projects;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/projects")
public class ProjectsAPI {
	private final static Logger LOG = LoggerFactory.getLogger(ProjectsAPI.class);
	private final ProjectsRepository repository;
	
	@Autowired
	public ProjectsAPI(ProjectsRepository repository) {
		this.repository = repository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Project> getProjectList(@RequestParam(required=false, value="keyword") String keyword){
		return this.repository.getProjectList(keyword);
	}
	
	@RequestMapping(value="/{projectId}", method = RequestMethod.GET)
	public ResponseEntity<?> getProject(@PathVariable("projectId") int projectId){
		Project project = this.repository.getProject(projectId);
		HttpHeaders responseHeaders = new HttpHeaders();
		
		if(project!=null){
			 return new ResponseEntity<Project>(project, responseHeaders, HttpStatus.OK);
		}else{
			 return new ResponseEntity<String>("No project found with id "+projectId, responseHeaders, HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Project addProject(@RequestBody @Valid Project project){
		return this.repository.addProject(project);
	}
	
	@RequestMapping(value="/{projectId}", method = RequestMethod.PUT)
	public @ResponseBody Project updateProject(@RequestBody @Validated Project project){
		return this.repository.updateProject(project);
	}
	
	@RequestMapping(value="/{projectId}", method = RequestMethod.DELETE)
	public void deleteProject(@PathVariable("projectId") int projectId){
		this.repository.deleteProject(projectId);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public void handleIllegalArgumentException(IllegalArgumentException ex, HttpServletResponse response) throws IOException{
		LOG.warn("Exception!", ex);
		response.sendError(400, ex.getMessage());		
	}
}

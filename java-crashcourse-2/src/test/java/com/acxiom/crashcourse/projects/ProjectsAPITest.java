package com.acxiom.crashcourse.projects;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ProjectsAPITest {

	
	@Mock ProjectsRepository projectsRepository;
	
	@Before
	public void initTest(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetProjectWhenPresent() {
		ProjectsAPI projectsAPI = new ProjectsAPI(projectsRepository);
		Project project = Project.newBuilder()
			.setId(1)
			.setProjectDescription("descr")
			.setProjectName("name")
			.build();
		
		when(projectsRepository.getProject(1)).thenReturn(project);
		
		ResponseEntity<?> result = projectsAPI.getProject(1);
		assertNotNull(result);
		assertEquals(project, result.getBody());
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}
	
	@Test
	public void testGetProjectWhenAbsent() {
		ProjectsAPI projectsAPI = new ProjectsAPI(projectsRepository);
		when(projectsRepository.getProject(1)).thenReturn(null);
		
		ResponseEntity<?> result = projectsAPI.getProject(1);
		assertNotNull(result);
		assertEquals("No project found with id 1", result.getBody());
		assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
	}

}

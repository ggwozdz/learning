package com.acxiom.crashcourse.projects;

import static org.junit.Assert.*;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProjectTest {
	private static final Logger LOG = LoggerFactory.getLogger(ProjectTest.class);
	
	@Test
	public void testCreateWithDefaults() {
		LOG.debug("----");
		LOG.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"\n");
		
		Project project = Project.newBuilder().build();
		
		LOG.trace("project {}", project);
		
		
		assertNotNull(project);
		assertNull(project.getId());
		assertNull(project.getProjectName());
		assertNull(project.getProjectDescription());
	}
	
	@Test
	public void testCreateWithValues() {
		LOG.debug("----");
		LOG.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"\n");
		
		Project project = Project.newBuilder()
			.setId(1)
			.setProjectDescription("descr")
			.setProjectName("name")
			.build();
		
		LOG.trace("project {}", project);
		
		assertNotNull(project);
		assertEquals(Integer.valueOf(1), project.getId());
		assertEquals("name",  project.getProjectName());
		assertEquals("descr", project.getProjectDescription());
	}
	
	@Test
	public void testJSON() throws JsonGenerationException, JsonMappingException, IOException {
		LOG.debug("----");
		LOG.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"\n");
		
		Project project = Project.newBuilder()
			.setId(1)
			.setProjectDescription("descr")
			.setProjectName("name")
			.build();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(project);
		
		LOG.trace("project {}", project);
		
		Project fromJson = mapper.readValue(json, Project.class);
		
		LOG.trace("fromJson {}",fromJson);
		
		assertNotNull(project);
		assertEquals(project, fromJson);
	}

}

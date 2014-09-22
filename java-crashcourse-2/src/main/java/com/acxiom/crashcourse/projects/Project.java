package com.acxiom.crashcourse.projects;

import java.io.IOException;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class Project {
	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	@JsonProperty("id")
	@NotNull
	private final Integer id;
	
	@JsonProperty("projectName")
	@NotNull
	@Size(min=1)
	private final String projectName;
	
	@JsonProperty("projectDescription")
	private final String projectDescription;
	
	private final int hashCode;

	@JsonCreator
	public Project(
			@JsonProperty("id") Integer id, 
			@JsonProperty("projectName") String projectName, 
			@JsonProperty("projectDescription") String projectDescription) {
		this.id = id;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		
		this.hashCode = Objects.hash(id, projectName, projectDescription);
	}

	private Project(Builder builder) {
		this(builder.id, builder.projectName, builder.projectDescription);
	}
	
	public static Builder newBuilder(){
		return new Builder();
	}

	public Integer getId() {
		return id;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}
	
	@Override
	public int hashCode() {
		return hashCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}else if(obj !=null && obj instanceof Project){
			Project other = (Project) obj;
			return Objects.equals(this.id, other.id) &&
					Objects.equals(this.projectName, other.projectName) &&
					Objects.equals(this.projectDescription, other.projectDescription);
		}else{
			return false;
		}
	}
	
	@Override
	public String toString() {
		try {
			return MAPPER.writeValueAsString(this);
		} catch (IOException e) {
			return super.toString();
		}
	}
	
	public static final class Builder {
		private Integer id;
		private String projectName;
		private String projectDescription;
		
		public Builder setId(Integer id) {
			this.id = id;
			return this;
		}
		
		public Builder setProjectName(String projectName) {
			this.projectName = projectName;
			return this;
		}
		
		public Builder setProjectDescription(String projectDescription) {
			this.projectDescription = projectDescription;
			return this;
		}
		
		public Project build(){
			return new Project(this);
		}
		
		
	}
}

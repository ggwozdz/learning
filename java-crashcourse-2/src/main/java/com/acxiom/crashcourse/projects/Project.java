package com.acxiom.crashcourse.projects;

import java.util.Objects;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {
	@JsonProperty("id")
	private final int id;
	
	@JsonProperty("projectName")
	private final String projectName;
	
	@JsonProperty("projectDescription")
	private final String projectDescription;
	
	private final int hashCode;

	@JsonCreator
	public Project(
			@JsonProperty("id") int id, 
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

	public int getId() {
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
	
	public static final class Builder {
		private int id;
		private String projectName;
		private String projectDescription;
		
		public Builder setId(int id) {
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

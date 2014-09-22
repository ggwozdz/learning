package com.acxiom.crashcourse.encoding;

import java.io.File;
import java.net.URL;

public class TestUtils {
	public File getFileFromTestResources(String fileName){
		URL resource = this.getClass().getClassLoader().getResource(fileName);
		return new File(resource.getFile());
	}
}

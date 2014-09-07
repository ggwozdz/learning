package com.acxiom.crashcourse.encoding;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

class FileTransform {
	protected String readFileAsText(File file) throws IOException{
		byte[] fileContent = Files.readAllBytes(file.toPath());
		return new String(fileContent);
	}
}

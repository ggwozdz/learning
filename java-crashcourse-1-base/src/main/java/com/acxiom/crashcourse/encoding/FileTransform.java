package com.acxiom.crashcourse.encoding;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

class FileTransform {
	protected String readFile(File fileToRead) throws IOException{
		byte[] bytes = Files.readAllBytes(fileToRead.toPath());
		return new String(bytes);
	}
}

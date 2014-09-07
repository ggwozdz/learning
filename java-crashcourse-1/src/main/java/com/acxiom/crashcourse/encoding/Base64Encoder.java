package com.acxiom.crashcourse.encoding; 

import java.io.File;
import java.io.IOException;

import javax.xml.bind.DatatypeConverter;

class Base64Encoder extends FileTransform implements Encoder{
	@Override
	public String encode(File textFile) throws IOException {
		String fileContent = this.readFileAsText(textFile);
		return DatatypeConverter.printBase64Binary(fileContent.getBytes());
	}
}

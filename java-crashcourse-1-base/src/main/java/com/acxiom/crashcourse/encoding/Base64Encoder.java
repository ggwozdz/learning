package com.acxiom.crashcourse.encoding;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.DatatypeConverter;

class Base64Encoder extends FileTransform implements Encoder {

	@Override
	public String encode(File file) throws IOException {
		String fileContent = this.readFile(file);
		return DatatypeConverter.printBase64Binary(fileContent.getBytes());
	}
}

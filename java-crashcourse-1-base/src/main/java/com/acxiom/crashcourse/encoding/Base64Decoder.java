package com.acxiom.crashcourse.encoding;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.DatatypeConverter;

class Base64Decoder extends FileTransform implements Decoder {

	@Override
	public String decode(File textFile) throws IOException {
		String fileContent = this.readFile(textFile);
		
		byte[] decoded = DatatypeConverter.parseBase64Binary(fileContent);
		return new String(decoded);
	}
	
}

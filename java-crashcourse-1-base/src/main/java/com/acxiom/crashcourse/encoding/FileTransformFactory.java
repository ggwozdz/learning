package com.acxiom.crashcourse.encoding;

public class FileTransformFactory {
	public static Encoder getEncoder(){
		return new Base64Encoder();
	}

	public static Decoder getDecoder() {
		return new Base64Decoder();
	}
}

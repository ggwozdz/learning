package com.acxiom.crashcourse.encoding;

public class EncoderFactory {
	public static Encoder getEncoder(){
		return new Base64Encoder();
	}
}

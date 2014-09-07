package com.acxiom.crashcourse.encoding;

public class DecoderFactory {
	public static Decoder getDecoder(){
		return new Base64Decoder();
	}
}

package com.acxiom.crashcourse.encoding;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class Base64EncoderTest {

	@Test
	public void testEncode() throws IOException {
		File fileFromTestResources = new TestUtils().getFileFromTestResources("example.txt");
		String encoded = EncoderFactory.getEncoder().encode(fileFromTestResources);
		assertEquals(encoded, "QWxhIG1hIGtvdGE=");
	}

}

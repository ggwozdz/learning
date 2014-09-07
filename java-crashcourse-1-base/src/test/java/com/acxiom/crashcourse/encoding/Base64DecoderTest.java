package com.acxiom.crashcourse.encoding;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class Base64DecoderTest {

	@Test
	public void testDecode() throws IOException {
		File fileFromTestResources = new TestUtils().getFileFromTestResources("encoded.txt");
		String decoded = DecoderFactory.getDecoder().decode(fileFromTestResources);
		assertEquals(decoded, "Ala ma kota");		
	}
	

}

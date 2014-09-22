package com.acxiom.crashcourse.encoding;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class DecoderTest {

	@Test
	public void test() throws IOException {
		File fileFromTestResources = new TestUtils().getFileFromTestResources("encoded.txt");
		String decoded = FileTransformFactory.getDecoder().decode(fileFromTestResources);
		assertEquals(decoded, "Ala ma kota");
	}

}

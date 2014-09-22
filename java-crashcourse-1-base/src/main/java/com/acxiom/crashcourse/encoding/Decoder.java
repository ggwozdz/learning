package com.acxiom.crashcourse.encoding;

import java.io.File;
import java.io.IOException;

public interface Decoder {
	public String decode(File file) throws IOException;
}

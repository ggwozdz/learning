package com.acxiom.crashcourse.encoding;

import java.io.File;
import java.io.IOException;

public interface Encoder {
	public String encode(File textFile) throws IOException;
}

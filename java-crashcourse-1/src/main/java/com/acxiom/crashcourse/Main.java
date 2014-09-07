package com.acxiom.crashcourse;

import java.io.File;
import java.io.IOException;

import com.acxiom.crashcourse.encoding.DecoderFactory;
import com.acxiom.crashcourse.encoding.EncoderFactory;

public class Main {
	private static final String ERROR_MESSAGE_TEMPLATE = "Cannot execute command %s due to error '%s'";
	
	
	public static void main(String[] args) {
		if(args.length == 2){
			Command command = Command.valueOf(args[0]);
			File file = new File(args[1]);
			
			try {
				new Main().executeCommand(command, file);
			} catch (IOException e) {
				String errorMessage = String.format(ERROR_MESSAGE_TEMPLATE, command, e.getMessage());
				System.err.println(errorMessage);
			}
		}else{
			System.out.println("usage: {command:ENCODE/DECODE}  /path/to/file");
		}
	}
	
	private void executeCommand(Command command, File file) throws IOException{
		switch (command) {
			case DECODE:	this.decode(file); break;
			case ENCODE:	this.encode(file); break;
			default: 		throw new IllegalArgumentException("Unsupported command:"+command);
		}
	}
	
	private void encode(File file) throws IOException{
		String encoded = EncoderFactory.getEncoder().encode(file);
		System.out.println(encoded);
	}
	
	private void decode(File file) throws IOException{
		String decoded = DecoderFactory.getDecoder().decode(file);
		System.out.println(decoded);
	}
}

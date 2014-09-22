package com.acxiom.crashcourse;

import java.io.File;
import java.io.IOException;

import com.acxiom.crashcourse.encoding.FileTransformFactory;


public class Main {
	
	public static void main(String[] args) {
		if(args.length == 2){
			Command command = Command.valueOf(args[0]);
			File file = new File(args[1]);
			
			System.out.println("command: "+command+" file:"+file);
			if(file.exists()){
				try {
					new Main().runCommand(command, file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else{
				System.err.println("File not found");
			}
		}else{
			System.out.println("usage: {command:ENCODE/DECODE}  /path/to/file");
		}
	}
	
	public void runCommand(Command command, File file) throws IOException{
		switch(command){
		case DECODE:
			String decded = FileTransformFactory.getDecoder().decode(file);
			System.out.println(decded);
			break;
		case ENCODE:
			String encoded = FileTransformFactory.getEncoder().encode(file);
			System.out.println(encoded);
			break;
		}
	}
}

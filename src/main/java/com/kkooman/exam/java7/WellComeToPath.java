package com.kkooman.exam.java7;

import java.nio.file.Path;
import java.nio.file.Paths;

public class WellComeToPath {
	
	public static void main(String[] args) {
		
		Path path = Paths.get("/", "Users/kkooman/Documents/index.html");
		//Path path = Paths.get("/Users/kkooman/Documents/index.html");
		System.out.println(path.getFileName());
		System.out.println(path.getFileSystem());
		
		
		System.out.println(path.getNameCount());
		System.out.println(path.getParent());
		System.out.println(path.getRoot());
		System.out.println(path.getName(0));
		System.out.println(path.getName(1));
		
	}
}

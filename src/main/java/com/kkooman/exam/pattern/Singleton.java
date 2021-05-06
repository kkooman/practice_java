package com.kkooman.exam.pattern;

public class Singleton {
	
	private static Singleton singleton;
	
	public static synchronized Singleton getInstance() {
		
		if (singleton == null) {
			singleton = new Singleton();
			System.out.println("init synchronized");
		}
		return singleton;
		
	}
}

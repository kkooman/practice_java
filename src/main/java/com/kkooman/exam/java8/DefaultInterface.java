package com.kkooman.exam.java8;

public interface DefaultInterface {
	default void set(String val) {
		System.out.println("interface val + " + val);
	}
	String get();
}

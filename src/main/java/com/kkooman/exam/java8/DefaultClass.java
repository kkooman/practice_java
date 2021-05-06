package com.kkooman.exam.java8;

public class DefaultClass implements DefaultInterface {
	
	String val;
	
	@Override
	public void set(String val) {
		System.out.println("Override val + " + val);
		this.val = val;
	}
	
	@Override
	public String get() {
		System.out.println("get val + " + this.val);
		return this.val;
	}
	
	public static void main(String[] args) {
		DefaultClass defaultClass = new DefaultClass();
		defaultClass.get();
		defaultClass.set("new val");
		defaultClass.get();
	}
}

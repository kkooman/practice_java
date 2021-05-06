package com.kkooman.exam.pattern;

public class ShapeFactory {
	
	public static Shape getShape(String name) {
	
		if("circle".equals(name)) {
			return new Circle();
		} else if("square".equals(name)) {
			return new Square();
		}
		return null;
	}
	
}

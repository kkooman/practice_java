package com.kkooman.exam.pattern;

public class NewRunner {
	
	public static void main(String[] args) {
		
		Shape circle = ShapeFactory.getShape("circle");
		Shape square = ShapeFactory.getShape("square");
		Shape rectangle = ShapeFactory.getShape("rectangle");
		
		circle.draw();
		square.draw();
		//rectangle.draw();
		
		Singleton.getInstance();
		Singleton.getInstance();
	}
}

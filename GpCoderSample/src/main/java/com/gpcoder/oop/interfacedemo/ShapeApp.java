package com.gpcoder.oop.interfacedemo;

public class ShapeApp {
	public static void main(String[] args) {
		Shape rect = new Rectangle();
		rect.draw();
		System.out.println("---");
		Shape circle = new Circle();
		circle.draw();
	}

	interface Printable {
		void print();

		interface MessagePrintable {
			void msg();
		}
	}
}

package com.gpcoder.supplier;

import java.util.function.Supplier;

interface Shape {
	void display();
}

class ShapeFactory {
	public static Shape createRectangle() {
		return new Shape() {
			@Override
			public void display() {
				System.out.println("This is rectangle shape");
			}
		};
	}

	public static Shape createSquare() {
		return new Shape() {
			@Override
			public void display() {
				System.out.println("This is square shape");
			}
		};
	}
}

class ShapeProducerFactory {
	public static Supplier<Shape> createRectangleProducer() {
		return ShapeFactory::createRectangle;
	}

	public static Supplier<Shape> createsquareProducer() {
		return ShapeFactory::createSquare;
	}
}

public class UsingSupplierExample3 {
	public static void main(String[] args) {
		Supplier<Shape> recangleProducer = ShapeFactory::createRectangle;
		Supplier<Shape> squareProducer = ShapeFactory::createSquare;
		recangleProducer.get().display();
		squareProducer.get().display();

		ShapeProducerFactory.createRectangleProducer().get().display();
		ShapeProducerFactory.createsquareProducer().get().display();
	}
}

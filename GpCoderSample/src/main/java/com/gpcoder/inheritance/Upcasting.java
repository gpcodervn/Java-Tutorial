package com.gpcoder.inheritance;

public class Upcasting {

	public static void main(String[] args) {
		Cat cat = new Cat();
		Animal animal1 = cat; // Upcasting with no explicit cast
		Animal animal2 = (Animal) cat; // Upcasting with an explicit cast

		cat.eat();
		cat.meow();
		animal1.eat();
		animal2.eat();
		// animal2.meow(); // Không thể gọi phương thức meow()
	}

}

package com.gpcoder.method_reference;

@FunctionalInterface
interface SayHello {
	void display(String say);
}

class Hello {
	public Hello(String say) {
		System.out.print(say);
	}
}

public class DemoMethodReference4 {

	public static void main(String[] args) {
		SayHello ref = Hello::new;
		ref.display("Welcome to gpcoder.com");
	}

}

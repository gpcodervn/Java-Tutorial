package com.gpcoder.lambda;

@FunctionalInterface
interface Sayable2 {
	public String say(String name);
}

public class LambdaExpression2 {
	public static void main(String[] args) {

		// Lambda expression with single parameter.
		Sayable2 s1 = (name) -> {
			return "Hello, " + name;
		};
		System.out.println(s1.say("GP Coder"));

		// Shorter
		Sayable2 s2 = name -> {
			return "Hello, " + name;
		};
		System.out.println(s2.say("GP Coder"));

		// Shortest
		Sayable2 s3 = name -> "Hello, " + name;
		System.out.println(s3.say("GP Coder"));
	}
}
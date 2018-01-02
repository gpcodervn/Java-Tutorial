package com.gpcoder.nestedclass;

class MemberOuterExample {
	private int data = 30;

	class Inner {
		void msg() {
			System.out.println("data is " + data);
		}
	}

	public static void main(String args[]) {
		MemberOuterExample obj = new MemberOuterExample();
		MemberOuterExample.Inner in = obj.new Inner();
		in.msg();
	}
}

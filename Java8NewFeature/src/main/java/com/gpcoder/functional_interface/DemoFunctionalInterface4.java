package com.gpcoder.functional_interface;

interface BaseInterface1 {
	void base();
}

interface BaseInterface2 {
	void base();
}

@FunctionalInterface
public interface DemoFunctionalInterface4 extends BaseInterface1, BaseInterface2 {

}

package com.gpcoder.junit.listener;

import org.junit.runner.JUnitCore;

public class JUnitListenerExample1 {

	public static void main(String[] args) {
        JUnitCore runner = new JUnitCore();
        runner.addListener(new ExecutionListener());
        runner.run(AssertTest.class, IgnoreTest.class);
    }
}

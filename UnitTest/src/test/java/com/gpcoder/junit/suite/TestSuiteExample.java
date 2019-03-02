package com.gpcoder.junit.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ TestSuite1.class, TestSuite2.class })
public class TestSuiteExample {
	// the class remains empty, used only as a holder for the above annotations
}

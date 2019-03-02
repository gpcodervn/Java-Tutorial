package com.gpcoder.junit.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ Test3.class, Test4.class })
public class TestSuite2 {
	// the class remains empty, used only as a holder for the above annotations
}
package com.gpcoder.junit.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ Test1.class, Test2.class })
public class TestSuite1 {
	// the class remains empty, used only as a holder for the above annotations
}

package com.gpcoder.junit.categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(RegressionTests.class)
@Categories.ExcludeCategory(IntegrationTest.class)
@Suite.SuiteClasses({ ClassA.class, ClassB.class, ClassC.class })
public class RegressionTestSuite {
	// the class remains empty, used only as a holder for the above annotations
}

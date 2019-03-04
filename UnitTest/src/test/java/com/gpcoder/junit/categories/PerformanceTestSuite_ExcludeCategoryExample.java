package com.gpcoder.junit.categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.ExcludeCategory({ RegressionTests.class })
@Suite.SuiteClasses({ ClassA.class, ClassB.class, ClassC.class })
public class PerformanceTestSuite_ExcludeCategoryExample {
	// the class remains empty, used only as a holder for the above annotations
}
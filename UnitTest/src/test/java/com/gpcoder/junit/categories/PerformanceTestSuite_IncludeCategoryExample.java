package com.gpcoder.junit.categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(PerformanceTests.class)
@Suite.SuiteClasses({ ClassA.class, ClassB.class, ClassC.class })
public class PerformanceTestSuite_IncludeCategoryExample {
	// the class remains empty, used only as a holder for the above annotations
}
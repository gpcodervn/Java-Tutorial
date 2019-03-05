package com.gpcoder.junit.rule;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TemporaryFolderRuleTest {

	/**
	 * Annotates fields that reference rules or methods that return a rule.
	 * 
	 * A field must be public, not static, and a sub-type of
	 * org.junit.rules.TestRule (preferred) or org.junit.rules.MethodRule.
	 * 
	 * A method must be public, not static, and must return a sub-type of
	 * org.junit.rules.TestRule (preferred) or org.junit.rules.MethodRule.
	 */
	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	@Test
	public void testFile() throws Exception {
		File testFolder = tempFolder.newFolder("TestFolder");
		File testFile = tempFolder.newFile("test.txt");
		assertTrue(testFolder.exists());
		assertTrue(testFile.exists());
	}
}

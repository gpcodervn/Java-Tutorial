package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class ReplaceEachTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String data = "<html><body>AB & CD</body></html>";
		String [] searchList = { "<", ">", "&"};
		String [] replacementList = { "&lt;", "&gt;", "&amp;" };
		
		System.out.println(StringUtils.replaceEach(data, searchList, replacementList));
	}

}

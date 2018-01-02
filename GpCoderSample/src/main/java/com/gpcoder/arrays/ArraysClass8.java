package com.gpcoder.arrays;

import java.util.Arrays;

public class ArraysClass8 {
	public static void main(String[] args) {
		// One Dimensional Array

		String[] oneDArray = new String[] {
			"ONE", "TWO", "THREE", "FOUR", "FIVE" 
		};
		System.out.println("One Dimensional Array : ");
		// Printing one dimensional array contents using deepToString() method
		System.out.println(Arrays.deepToString(oneDArray));

		// Two Dimensional Array

		String[][] twoDArray = new String[][] { 
			{ "ONE", "TWO", "THREE", "FOUR" }, 
			{ "FIVE", "SIX", "SEVEN" },
			{ "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE" } 
		};
		System.out.println("Two Dimensional Array : ");
		// Printing two dimensional array contents using deepToString() method
		System.out.println(Arrays.deepToString(twoDArray));

		// Three Dimensional Array
		String[][][] threeDArray = new String[][][] { 
			{ 
				{ "ONE", "TWO", "THREE" }, 
				{ "FOUR", "FIVE", "SIX", "SEVEN" } 
			}, { 
				{ "EIGHT", "NINE", "TEN", "ELEVEN" }, 
				{ "TWELVE", "THIRTEEN", "FOURTEEN" } 
			}, { 
				{ "FIFTEEN", "SIXTEEN" }, 
				{ "SEVENTEEN", "EIGHTEEN", "NINETEEN" }, 
				{ "TWENTY", "TWENTY ONE" } 
			} 
		};
		System.out.println("Three Dimensional Array : ");
		// Printing three dimensional array contents using deepToString() method
		System.out.println(Arrays.deepToString(threeDArray));
	}
}

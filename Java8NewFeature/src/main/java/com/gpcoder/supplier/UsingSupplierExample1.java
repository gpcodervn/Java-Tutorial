package com.gpcoder.supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

class CollectionHelper {
	public static List<Programing> getLanguages() {
		return new ArrayList<>();
	}
}

public class UsingSupplierExample1 {

	public static void main(String[] args) {
		// Call helper methods
		List<Programing> list1 = CollectionHelper.getLanguages();
		List<Programing> list2 = CollectionHelper.getLanguages();
		List<Programing> list3 = CollectionHelper.getLanguages();

		// Using Supplier
		Supplier<List<Programing>> supplier = CollectionHelper::getLanguages;
		List<Programing> list01 = supplier.get();
		List<Programing> list02 = supplier.get();
		List<Programing> list03 = supplier.get();
	}
}

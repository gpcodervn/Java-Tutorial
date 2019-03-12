package com.gpcoder.junit.hamcrest;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.collection.IsArrayWithSize.arrayWithSize;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.lessThan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.collection.IsEmptyCollection;
import org.hamcrest.collection.IsMapContaining;
import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

public class CollectionMatcherTest {

	@Test
	public void arrayTest() {
	    Integer[] ints = new Integer[] { 2, 5, 1, 9 };
	    
	    assertThat(ints, arrayWithSize(4));
	    assertThat(ints, arrayContainingInAnyOrder(2, 5, 1, 9));
	}

	@Test
    public void testAssertMap() {

        Map<String, String> map = new HashMap<>();
        map.put("j", "Java");
        map.put("s", "Spring Boot");
        map.put("w", "Web services");

        Map<String, String> expected = new HashMap<>();
        expected.put("j", "Java");
        expected.put("s", "Spring Boot");
        expected.put("w", "Web service");

        // Test equal, ignore order
        assertThat(map, is(expected));

        // Test size
        assertThat(map.size(), is(3));

        // Test map entry
        assertThat(map, IsMapContaining.hasEntry("s", "Spring Boot"));

        assertThat(map, not(IsMapContaining.hasEntry("s", "SQL")));

        // Test map key
        assertThat(map, IsMapContaining.hasKey("j"));

        // Test map value
        assertThat(map, IsMapContaining.hasValue("Java"));
    }
	
	@Test
	public void testAssertListString() {

		List<String> actual = Arrays.asList("Java", "Spring Boot", "Web services");
		List<String> expected = Arrays.asList("Java", "Spring Boot", "Web services");

		// Test equal.
		assertThat(actual, is(expected));

		// If List has this value?
		assertThat(actual, hasItems("Java"));

		// Check List Size
		assertThat(actual, hasSize(3));

		assertThat(actual.size(), is(3));

		// Ensure Correct order
		assertThat(actual, contains("Java", "Spring Boot", "Web services"));

		// Can be any order
		assertThat(actual, containsInAnyOrder("Web services", "Spring Boot"));
        
		assertThat(actual, everyItem(greaterThan("A")));

		// Check empty list
		assertThat(actual, not(IsEmptyCollection.empty()));
		assertThat(new ArrayList<>(), IsEmptyCollection.empty());
	}
	
	@Test
    public void testAssertListInteger() {

        List<Integer> actual = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        // Test equal.
        assertThat(actual, is(expected));

        // Check List has this value
        assertThat(actual, hasItems(2));

        // Check List Size
        assertThat(actual, hasSize(5));

        assertThat(actual.size(), is(5));

        // Ensure Correct order
        assertThat(actual, contains(1, 2, 3, 4, 5));

        // Can be any order
        assertThat(actual, containsInAnyOrder(5, 4, 3, 2, 1));

        // check empty list
        assertThat(actual, not(IsEmptyCollection.empty()));

        assertThat(new ArrayList<>(), IsEmptyCollection.empty());

		// Test numeric comparisons
        assertThat(actual, everyItem(greaterThanOrEqualTo(1)));

        assertThat(actual, everyItem(lessThan(10)));

    }
	
	@Test
    public void testAssertListObject() {

        List<Fruit> list = Arrays.asList(
                new Fruit("Banana", 99), 
                new Fruit("Apple", 20)
        );

        // Test equals
        assertThat(list, hasItems(
                new Fruit("Banana", 99),
                new Fruit("Apple", 20)
        ));

        assertThat(list, containsInAnyOrder(
                new Fruit("Apple", 20),
                new Fruit("Banana", 99)
        ));

        // Test class property, and its value
        assertThat(list, containsInAnyOrder(
                hasProperty("name", is("Apple")),
                hasProperty("name", is("Banana"))
        ));

    }

	@Data
	@AllArgsConstructor
	@EqualsAndHashCode
    public class Fruit {
        private String name;
        private int qty;
    }
}

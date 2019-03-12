package com.gpcoder.junit.hamcrest;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
class Student {
    private int id;
    private String name;
}

public class BeanMatcherExample {
	
	@Test
	public void givenBean_whenHasValue_thenCorrect() {
		Student student = new Student(29, "gpcoder");
	    assertThat(student, hasProperty("gpcoder"));
	}
	
	@Test
	public void givenBean_whenHasCorrectValue_thenCorrect() {
		Student student = new Student(29, "gpcoder");
	    assertThat(student, hasProperty("name", equalTo("gpcoder")));
	}
	
	@Test
	public void given2Beans_whenHavingSameValues_thenCorrect() {
		Student student1 = new Student(29, "gpcoder");
		Student student2 = new Student(29, "gpcoder");
	    assertThat(student1, samePropertyValuesAs(student2));
	}
}

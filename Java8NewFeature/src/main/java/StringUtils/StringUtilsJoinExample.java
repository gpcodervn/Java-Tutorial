package StringUtils;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsJoinExample {

	public static void main(String[] args) {
		String[] arr = { "one", "two", "three" };
		String joinedString = StringUtils.join(arr, ", "); // one, two, three

		List<String> list = Arrays.asList("one", "two", "three");
		joinedString = StringUtils.join(list, ", "); // one, two, three
	}
}

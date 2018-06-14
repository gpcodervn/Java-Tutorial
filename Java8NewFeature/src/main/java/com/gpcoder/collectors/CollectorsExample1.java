package com.gpcoder.collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExample1 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Java", "C++", "C#", "PHP");

		List<String> result1 = list.stream().collect(Collectors.toList());

		Set<String> result2 = list.stream().collect(Collectors.toSet());

		List<String> result3 = list.stream().collect(Collectors.toCollection(LinkedList::new));

		Map<String, Integer> result4 = list.stream().collect( //
				Collectors.toMap(Function.identity(), String::length));

		List<String> result5 = list.stream()
				.collect(Collectors.collectingAndThen(Collectors.toList(), x -> x.subList(0, 2)));

		String result6 = list.stream().collect(Collectors.joining());
		String result7 = list.stream().collect(Collectors.joining(", "));
		String result8 = list.stream().collect(Collectors.joining(" ", "PRE-", "-POST"));

		Long result9 = list.stream().collect(Collectors.counting());

		IntSummaryStatistics result10 = list.stream().collect(Collectors.summarizingInt(String::length));

		Optional<String> result11 = list.stream().collect(Collectors.maxBy(Comparator.naturalOrder()));
		Optional<String> result12 = list.stream().collect(Collectors.minBy(Comparator.naturalOrder()));
		System.out.println(result12.get());

		Stream<Integer> s = Stream.of(5, 10, 20, 50);
		Integer i = s.collect(Collectors.reducing((integer, integer2) -> integer2 - integer)).orElse(-1);
		System.out.println(i);
	}
}

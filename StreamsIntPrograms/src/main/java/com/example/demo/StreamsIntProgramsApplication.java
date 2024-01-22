package com.example.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StreamsIntProgramsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamsIntProgramsApplication.class, args);
		String name="jdfkllkfdngjndfklvnlkdfnldnndfkl;lsdmerjm.lnsl;ldfjke";

		Optional<Integer> asList = Arrays.asList(22, 4, 5, 8, 9, 6, 33, 77, 58, 65, 14, 23, 98, 52, 66).stream()
				.reduce((a, b) -> a + b);
		Integer reduce = asList.stream().reduce((a, b) -> a + b).get();
		System.out.println(asList + "         " + reduce);
		name.chars().mapToObj(t->(char)t).collect(Collectors.groupingBy((t->t),Collectors.counting())).forEach((s,t)->  System.out.print(s+"->"+t+" "));

		printAverage();
		squareFilterAverageNumber();
		evenOddNum();
		printStartWithGivennum();
		printTheDuplicate();
		printMax_Min();
		sortingASC_DESC();
		printFirst5Numbers();
		printSecondHighesr_Lowest();
	}

	public static void printAverage() {
		List<Integer> asList = Arrays.asList(22, 4, 5, 8, 9, 6, 33, 77, 58, 65, 14, 32, 34, 23, 98, 52, 66);
		double asDouble = asList.stream().mapToInt(t -> t).average().getAsDouble();
		System.out.println(asDouble);

	}

	public static void squareFilterAverageNumber() {
		List<Integer> list = Arrays.asList(22, 4, 5, 8, 9, 6, 33, 77, 58, 65, 14, 23, 98, 52, 66);
		double asDouble = list.stream().mapToInt(t -> t * t).average().getAsDouble();
		System.out.println(asDouble);

	}

	public static void evenOddNum() {
		List<Integer> list = Arrays.asList(22, 4, 5, 8, 9, 6, 33, 77, 58, 65, 14, 23, 98, 52, 66);

		List<Integer> collect = list.stream().filter(t -> t % 2 == 0).collect(Collectors.toList());
		List<Integer> collect1 = list.stream().filter(t -> t % 2 != 0).collect(Collectors.toList());
		System.out.println(collect);
		System.out.println(collect1);

	}

	public static void printStartWithGivennum() {
		List<Integer> list = Arrays.asList(22, 4, 5, 8, 9, 6, 33, 77, 58, 65, 14, 23, 9, 22, 33, 98, 52, 66);
		List<Integer> collect = list.stream().map(t -> String.valueOf(t)).filter(t -> t.startsWith("6"))
				.map(Integer::valueOf).collect(Collectors.toList());
		System.out.println(collect);

	}

	public static void printTheDuplicate() {
		List<Integer> list = Arrays.asList(22, 4, 5, 8, 9, 6, 33, 77, 58, 65, 14, 23, 9, 22, 33, 98, 52, 66);
		List<Integer> collect = list.stream().filter(t -> Collections.frequency(list, t) > 1).distinct()
				.collect(Collectors.toList());
		Set<Integer> collect2 = list.stream().filter(t -> Collections.frequency(list, t) > 1)
				.collect(Collectors.toSet());
		Set<Integer> hashSet = new HashSet<Integer>();
		Set<Integer> collect3 = list.stream().filter(t -> !hashSet.add(t)).collect(Collectors.toSet());

		System.out.println(collect);
		System.out.println(collect2);
		System.out.println(collect3);

	}

	public static void printMax_Min() {
		List<Integer> list = Arrays.asList(22, 4, 5, 8, 9, 6, 33, 77, 58, 65, 14, 23, 9, 22, 33, 98, 52, 66);
		Integer max = list.stream().max(Comparator.comparing(Integer::valueOf)).get();
		Integer min = list.stream().min(Comparator.comparing(Integer::valueOf)).get();
		Integer skip = list.stream().sorted(Collections.reverseOrder()).findFirst().get();
		Integer integer = list.stream().sorted().findFirst().get();
		int max2 = list.stream().mapToInt(t -> t).max().getAsInt();
		int asInt = list.stream().mapToInt(t -> t).min().getAsInt();
		list.stream().sorted().distinct();
		System.out.println(max);
		System.out.println(min);
		System.out.println(max2);
		System.out.println(asInt);
		System.out.println(skip);
		System.out.println(integer);

	}

	public static void sortingASC_DESC() {
		List<Integer> list = Arrays.asList(22, 4, 5, 8, 9, 6, 33, 77, 58, 65, 14, 23, 9, 22, 33, 98, 52, 66);
		List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
		List<Integer> collect1 = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println(collect);
		System.out.println(collect1);

	}

	public static void printFirst5Numbers() {
		List<Integer> list = Arrays.asList(22, 4, 5, 8, 9, 6, 33, 77, 58, 65, 14, 23, 9, 22, 33, 98, 52, 66);
		List<Integer> collect = list.stream().limit(5).collect(Collectors.toList());
		List<Integer> collect1 = list.stream().skip(8).collect(Collectors.toList());
		Integer collect11 = list.stream().skip(8).reduce((a, b) -> a + b).get();
		System.out.println(collect);
		System.out.println(collect1);

		System.out.println(collect11);

	}

	public static void printSecondHighesr_Lowest() {
		List<Integer> list = Arrays.asList(22, 4, 5, 8, 9, 6, 33, 77, 58, 65, 14, 23, 9, 22, 33, 98, 52, 66);
		Integer collect = list.stream().sorted().skip(1).findFirst().get();
		Integer collect1 = list.stream().sorted(Collections.reverseOrder()).skip(1).findFirst().get();
		System.out.println(collect);
		System.out.println(collect1);

	}

}

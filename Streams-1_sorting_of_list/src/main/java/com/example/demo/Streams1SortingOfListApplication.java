package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Streams1SortingOfListApplication {

	public static void main(String[] args) {
		SpringApplication.run(Streams1SortingOfListApplication.class, args);

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(9);
		list.add(58);
		list.add(35);
		list.add(5);
		list.add(14);
		list.add(12);

		ArrayList<Employee> list1 = new ArrayList<>();
		list1.add(new Employee(12, "Mallesh", "Hcl Technology", 500000));
		list1.add(new Employee(52, "Kumar", "Infosys", 1000000));
		list1.add(new Employee(14, "mohan", "capgeminy", 250000));
		list1.add(new Employee(1, "suresh", "cts", 3200000));
		list1.add(new Employee(65, "thirupal", "tcs", 660000));
		list1.add(new Employee(95, "karthik", "wipro", 8500000));

		// ----------printing the values-------------------
		list.forEach(System.out::println);
		// -----------------sorted the values using the streams------------
		list.stream().sorted().forEach(System.out::println);
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		// ------------------general process-----------------

		for (Integer integer : list) {
			System.out.println(integer);
		}

		Collections.sort(list);
		Collections.sort(list, Comparator.reverseOrder());

		Collections.sort(list1, new MyComparator());
		System.out.println(list1);
		// -----------------using the annonimous class-----

		Collections.sort(list1, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getSalary() - o2.getSalary();
			}
		});
		System.out.println(list1);

		// --------------using the lamda ----------------

		Collections.sort(list1, (o1, o2) -> o2.getSalary() - o1.getSalary());
		System.out.println(list1);

		list1.stream().sorted(Comparator.comparing(t -> t.getSalary())).forEach(System.out::println);
		System.out.println();
		list1.stream().sorted(Comparator.comparing(Employee::getEmployeeName)).forEach(System.out::println);
		printTheEmployee();
	}

	public static void printTheEmployee() {

		ArrayList<Employee> list1 = new ArrayList<>();
		list1.add(new Employee(12, "Mallesh", "Hcl Technology", 500000));
		list1.add(new Employee(52, "Kumar", "Infosys", 1000000));
		list1.add(new Employee(14, "mohan", "capgeminy", 250000));
		list1.add(new Employee(1, "suresh", "cts", 3200000));
		list1.add(new Employee(65, "thirupal", "tcs", 660000));
		list1.add(new Employee(95, "karthik", "wipro", 8500000));

		list1.stream().filter(e -> e.getSalary() > 500000).map(e -> e.getEmployeeName()).distinct().sorted()
				.forEach(System.out::println);
		System.out.println();
		list1.stream().filter(t -> t.getSalary() > 2500000).map(Employee::getEmployeeName).distinct().sorted()
				.forEach(System.out::println);

	}

}

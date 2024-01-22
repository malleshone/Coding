package com.example.demo;

import java.util.Comparator;

public class MyComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
      
		 return o2.getSalary() - o1.getSalary() ;
	
	}
}

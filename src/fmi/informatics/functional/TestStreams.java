package fmi.informatics.functional;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import fmi.informatics.extending.Student;

public class TestStreams {

	public static void main(String[] args) {
		streamTask1();
		streamTask2();
		streamTask3();
		streamTask4();
		
		Rock onEarth = new Rock();
		onEarth.drop(onEarth.height());
		
	}

	public static void streamTask1() {
		
		Stream.of(Student.StudentGenerator.make(),
				Student.StudentGenerator.make(),
				Student.StudentGenerator.make()
				)
		.filter(s -> s.getName().length() > 4)
		.sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
		.forEach(System.out::println); 
	
	}
	
	public static void streamTask2() {
		Stream.of("cat", "dog", "cow", "bird") 
		.map(String::toUpperCase) 
		.collect(Collectors.toList()) 
		.forEach(System.out::println); 
	}
	
	public static void streamTask3() {
		
		List<Student> studs = new ArrayList<>(); 
		for (int i = 0; i < 5; ++i) { 
			studs.add(Student.StudentGenerator.make()); 
		}
		String studNames = studs.stream()        
				.sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))        
				.map(s -> s.getName())        
				.reduce((s1, s2) -> {
					if (s2 != null) return s1 + ", " + s2;
					return s1;
					})
				.get();
		System.out.println(studNames); 
	}
	
	public static void streamTask4() {
		IntStream.iterate(0, i -> i + 1)
		.skip(5)
		.limit(10)
		.forEach(i -> { 
			if (i % 2 == 0) 
				System.out.println(i);
			});
	}
	
	
}

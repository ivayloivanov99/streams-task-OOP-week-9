package fmi.informatics.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import fmi.informatics.extending.Student;
import fmi.informatics.functional.Rock;


public class StreamTests {

	public String concatenate(String one, String two) {
		return one + two;
	}

	@Test
	public void testConcatenate() {
		String result = concatenate("one", "two");
		String expectedResult = "onetwo";

		assertEquals(expectedResult, result);
	}

	@Test
	public void testTask1() {		
		ArrayList<Student> students = new ArrayList<Student>();
		Stream.of(Student.StudentGenerator.make(),
			Student.StudentGenerator.make(),
			Student.StudentGenerator.make()
			)
	.filter(s -> s.getName().length() > 4)
	.sorted((s1, s2) -> s2.getName().compareTo(s1.getName()))
	.forEach(s -> students.add(s)); 
		
	 Assert.assertEquals(students.get(0).getName().toString(),"Stoyan");
	}
	

	
	
	@Test
	public void testTask2() {		
		ArrayList<String> animals = new ArrayList<String>();
		Stream.of("cat", "dog", "cow", "bird") 
		.map(String::toUpperCase)
		.sorted()
		.collect(Collectors.toList()) 
		.forEach(s -> animals.add(s)); 

		 
		Assert.assertEquals(animals.get(0),"BIRD");

	}
	
	@Test
	public void testTask3() {		
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
		
		
		 Assert.assertEquals(studNames,"Ivan, Ivan, Petya, Stoyan, Stoyan");
		
		
	}
	@Test
	public void testTask4() {		
	
		IntStream.iterate(0, i -> i + 1)
		.skip(5)
		.limit(10)
		.forEach(i -> { 
			if (i % 2 == 0) 
				System.out.println(i);						
			});

		
	}
	@Test
	public void testTask5() {		
		Rock onEarth = new Rock();
		onEarth.drop(onEarth.height());
		Rock onMars = new Rock();

		assertEquals(onEarth,onMars);
	
	}
	
	
	
	
	
	
	

}
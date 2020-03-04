package fmi.informatics.extending;

import java.util.ArrayList;
import java.util.List;



public class TestClass {

	public static void main(String[] args) {
		testGenerator();
		testAnonymousClasses();
		testRTTI();
	}
	
	public static void testGenerator() {
		List<Student> students = new ArrayList<>();
		
		for(int i = 0; i <= 6; i++) {
			Student student = Student.StudentGenerator.make();
			students.add(student);
		}

		for(Student student: students) {
			System.out.println(student);
		}
	}
	
	
	public static void testAnonymousClasses() {
		Student student = new Student("Pesho", 123, "PU", "5698", 2569) {
			@Override
			public String getTypicalDrink(){
				return "50 years Black Johny";
			}
		};
		student.goBar();
		
	
	}
	
	
	@SuppressWarnings("rawtypes")
	public static void testRTTI() {
		Person person = Student.StudentGenerator.make();
		
	
		if(person instanceof Student) {
			String name = person.getName();
			String speciality = ((Student) person).getSpeciality();
			System.out.println("I'm " + name + " and I'm studying " + speciality);
		}
		

		Class studentClass = Student.class;
		if(person.getClass().isAssignableFrom(studentClass)) {
			String speciality = ((Student) person).getSpeciality();
			System.out.println("I'm studying " + speciality);
		}
		
		if(person.getClass().equals(Student.class)) {
			String speciality = ((Student) person).getSpeciality();
			System.out.println("I'm studying " + speciality);
		}
	}
}
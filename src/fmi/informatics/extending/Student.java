package fmi.informatics.extending;

import java.util.Calendar;

import java.util.concurrent.ThreadLocalRandom;


public class Student extends Person {

	private String university;
	private String speciality;
	private int facNumber;

	public Student() {

	}
	
	public Student(String speciality, String university) {
		this. speciality = speciality;
		this. university = university;
	}

	public Student(String name, int egn, String university, String speciality, int facNumber) {
		super(name, egn);
		this.university = university;
		this.speciality = speciality;
		this.facNumber = facNumber;
	}
	
	public Student(String name, int egn, String university, String speciality, int facNumber,
			int age, int height, int weight) {
		super(name, egn, age, height, weight);
		this.university = university;
		this.speciality = speciality;
		this.facNumber = facNumber;
	}

	
	@Override
	public void run() {
		System.out.println("The student is running");
	}
	
	@Override
	public String toString() {
		return String.format(this.getName());
	}

	public void study() {
		System.out.println("The student is studying");
	}

	public void takeExam() {
		System.out.println("The student passed the exam");
	}

	public void goBar(String drink) {
		System.out.println("The student " + getName() +  " drinking " + drink);
	}
	
	
	@Override
	protected String getTypicalDrink() {
		return "Vodka";
	}
	
	
	@SuppressWarnings("static-access")
	@Override
	public void getUpEarly(Calendar hour) {
		System.out.println("The student usually gets up at " + hour.HOUR);
	}

	@Override
	public void run(int minutes) {
		// TODO Auto-generated method stub
	}

	@Override
	public void think() {
		// TODO Auto-generated method stub
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + facNumber;
		result = prime * result + ((speciality == null) ? 0 : speciality.hashCode());
		result = prime * result + ((university == null) ? 0 : university.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (facNumber != other.facNumber)
			return false;
		if (speciality == null) {
			if (other.speciality != null)
				return false;
		} else if (!speciality.equals(other.speciality))
			return false;
		if (university == null) {
			if (other.university != null)
				return false;
		} else if (!university.equals(other.university))
			return false;
		return true;
	}

	// Getters and setters
	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public int getFacNumber() {
		return facNumber;
	}

	public void setFacNumber(int facNumber) {
		this.facNumber = facNumber;
	}
	
	
	public static class StudentGenerator {
		private static String[] names = {"Ivan", "Mariya", "Stoyan", "Petyr", "Petya", "Lilly"};
		private static String[] specialities = {"Informatics", "STD", "BIT", "Mathematics"};
		private static String[] universities = {"PU", "NBU", "SU", "UHT"};
		
		public static Student make() {
			int arrayIndex = ThreadLocalRandom.current().nextInt(0, names.length);
			String name = names[arrayIndex];
			
			arrayIndex = ThreadLocalRandom.current().nextInt(0, specialities.length);
			String speciality = specialities[arrayIndex];
			
			arrayIndex = ThreadLocalRandom.current().nextInt(0, universities.length);
			String university = universities[arrayIndex];
			
			int facNumber = ThreadLocalRandom.current().nextInt(111111, 999999);
			
			int egn = ThreadLocalRandom.current().nextInt(111111, 999999);
			
			
			int age = ThreadLocalRandom.current().nextInt(18, 30);
			
			int height =  ThreadLocalRandom.current().nextInt(150, 220);
			
			int weight = ThreadLocalRandom.current().nextInt(50, 220);
			
			return new Student(name, egn, university, speciality, facNumber, age, height, weight);
		}
	}
}
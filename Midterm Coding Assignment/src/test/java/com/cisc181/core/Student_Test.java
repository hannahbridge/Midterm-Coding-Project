package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test	 
{
	private static ArrayList<Course> courses = new ArrayList<Course>();
	private static ArrayList<Semester> semesters = new ArrayList<Semester>();
	private static ArrayList<Section> sections = new ArrayList<Section>();
	private static ArrayList<Student> students = new ArrayList<Student>();
	
	private static ArrayList<Enrollment> enroll = new ArrayList<Enrollment>();
	
	@BeforeClass
	public static void setup() throws PersonException 
	{
		final UUID FINANCE100UUID = UUID.randomUUID();	
		final UUID CHEM103UUID = UUID.randomUUID();
		final UUID BIO104UUID = UUID.randomUUID();
		
		final UUID SPRINGUUID = UUID.randomUUID();
		final UUID FALLUUID = UUID.randomUUID();
			
		Course course1 = new Course(FINANCE100UUID, "Finance 100", 3, eMajor.BUSINESS);
		Course course2 = new Course(CHEM103UUID, "Chemistry 103", 4, eMajor.CHEM);
		Course course3 = new Course(BIO104UUID, "Biology 104", 4, eMajor.NURSING);
		
		Semester Spring = new Semester(SPRINGUUID, new Date(2018, 2, 5), new Date(2018, 5, 24));
		Semester Fall = new Semester(FALLUUID, new Date(2017, 8, 29), new Date(2017, 12, 16));
		
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		
		semesters.add(Spring);
		semesters.add(Fall);
			
		Student Eleven = new Student("Eleven", "", "", new Date(2003, 11, 25), eMajor.CHEM,
				"100 Hawkins Circle", "(000)-000-0000", "eleven@gmail.com");
		
		Student DustinHenderson = new Student("Dustin", "Michael", "Henderson", new Date(2003, 8, 21), eMajor.PHYSICS,
				"101 Hawkins Circle", "(111)-111-1111", "dhenderson@gmail.com");
		
		Student MikeWheeler = new Student("Mike", "John", "Wheeler", new Date(2003, 9, 10), eMajor.COMPSI,
				"102 Hawkins Circle", "(222)-222-2222", "mwheeler@gmail.com");
		
		Student LucasSinclair = new Student("Lucas", "Joshua", "Sinclair", new Date(2003, 5, 25), eMajor.CHEM,
				"103 Hawkins Circle", "(333)-333-3333", "lsinclair@gmail.com");
		
		Student WillByers = new Student("Will", "Anthony", "Byers", new Date(2003, 4, 4), eMajor.CHEM,
				"104 Hawkins Circle", "(444)-444-4444", "wbyers@gmail.com");
		
		Student JimHopper = new Student("Jim", "Nicholas", "Hopper", new Date(1959, 7, 19), eMajor.BUSINESS,
				"105 Hawkins Circle", "(555)-555-5555", "jhopper@gmail.com");
		
		Student MartinBrenner = new Student("Martin", "Jacob", "Brenner", new Date(1948, 1, 14), eMajor.PHYSICS,
				"106 Hawkins Circle", "(666)-666-6666", "mbrenner@gmail.com");
		
		Student NancyWheeler = new Student("Nancy", "Charlotte", "Wheeler", new Date(1999, 11, 2), eMajor.NURSING,
				"107 Hawkins Circle", "(777)-777-7777", "nwheeler@gmail.com");
		
		Student JonathanByers = new Student("Jonathan", "Daniel", "Byers", new Date(1998, 6, 10), eMajor.COMPSI,
				"108 Hawkins Circle", "(888)-888-8888", "jbyers@gmail.com");
		
		Student SteveHarrington = new Student("Steve", "Cameron", "Harrington", new Date(1998, 2, 22), eMajor.CHEM,
				"109 Hawkins Circle", "(999)-999-9999", "sharrington@gmail.com");
		
		students.add(Eleven);
		students.add(DustinHenderson); 
		students.add(MikeWheeler);
		students.add(LucasSinclair);
		students.add(WillByers);
		students.add(JimHopper);
		students.add(MartinBrenner);
		students.add(NancyWheeler);
		students.add(JonathanByers);
		students.add(SteveHarrington);
		
		int roomNumber = 1;
		for(Semester s: semesters)
		{
			for(Course c: courses)
			{
				sections.add(new Section(c.getCourseID(), s.getSemesterID(), UUID.randomUUID(), roomNumber));
			}
			roomNumber += 10;
		}
		
		for(Section sec: sections)
		{
			for(Student stu: students)
			{
				
				
				Enrollment enrollment = new Enrollment(sec.getSectionID(), stu.getStudentID());
				enroll.add(enrollment);
				
				for(Enrollment en: enroll)
				{
					en.SetGrade(75.00);
				}
			}
		}
		
	} 
	
	@Test
	public void test() 
	{	
		double creditsTaken = 0;
		double creditsEarned = 0;
		
		double numOfStudents = 0;
		double allGrades = 0;
		
		for(Enrollment e: enroll)
		{
			numOfStudents += 1;
			allGrades += e.getGrade();
			
			for(Course c: courses)
			{
				creditsEarned += c.getGradePoints() * e.getGrade();
				creditsTaken += c.getGradePoints();
			}
		}
		
		double gpa = creditsEarned / creditsTaken;
		assertEquals(gpa, 75.00, 0.01);
		
		double courseAvgGrade = allGrades / numOfStudents;
		assertEquals(courseAvgGrade, 75.00, 0.01);
		
	}
}
package com.cisc181.core;

import static org.junit.Assert.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.core.PersonException;
import com.cisc181.core.Staff;
import com.cisc181.eNums.eTitle;

public class Staff_Test 
{
	private static ArrayList<Staff> listOfStaff = new ArrayList<Staff>(); 

	@BeforeClass
	public static void setup() throws PersonException 
	{
		Staff JackPearson = new Staff("Jack", "Lucas", "Pearson", new Date(1954, 4, 15), "78 Hollow Drive", "(412)-123-4567",
				"jackpearson@gmail.com", "Monday 10-12pm", 9, 210000.00, new Date(1984, 9, 7), eTitle.MR);
		
		Staff RebeccaPearson = new Staff("Rebecca", "Claire", "Pearson", new Date(1962, 8, 23), "78 Hollow Drive", "(412)-987-6543",
				"rebeccapearson@gmail.com", "Tuesday 10-12pm", 10, 140000.00, new Date(1985, 6, 17), eTitle.MRS);
		
		Staff KatePearson = new Staff("Kate", "Elizabeth", "Pearson", new Date(1980, 4, 15), "193 Hills Street", "(412)-555-8888",
				"katepearson@gmail.com", "Wednesday 10-12pm", 8, 100000.00, new Date(2003, 2, 2), eTitle.MS);
		
		Staff RandallPearson = new Staff("Randall", "Thomas", "Pearson", new Date(1980, 4, 15), "210 Park Avenue", "(412)-333-9999",
				"randallpearson@gmail.com", "Thursday 10-12pm", 10, 200000.00, new Date(2002, 5, 21), eTitle.MR);
		
		Staff KevinPearson = new Staff("Kevin", "James", "Pearson", new Date(1980, 4, 15), "105 Country Road", "(412)-222-1111",
				"kevinpearson@gmail.com", "Friday 10-12pm", 9, 112000.00, new Date(2003, 10, 26), eTitle.MR);
		
		listOfStaff.add(JackPearson);
		listOfStaff.add(RebeccaPearson);
		listOfStaff.add(KatePearson);
		listOfStaff.add(RandallPearson);
		listOfStaff.add(KevinPearson);

	
	}
	
	@Test
	public void test() 
	{
		int amount = 0;
		for(Staff x: listOfStaff)
		{
			amount += x.getSalary();
		}
		
		double average = amount / 5.0;
		
		assertEquals(average, 152400.00, 0.01);
		
		boolean wasThrown1 = false;
		try
		{
			Staff JohnSmith = new Staff("John", "Henry", "Smith", new Date(1897, 3, 29), "123 Wrong Road", "(302)-749-3988",
					"jsmith@gmail.com", "Monday 1-3pm", 7, 101000.00, new Date(1983, 1, 3), eTitle.MR);
		}
		catch(PersonException e)
		{
			wasThrown1 = true;
		}
		assertTrue(wasThrown1);
		
		boolean wasThrown2 = false;
		try
		{
			Staff NickSnow = new Staff("Nick", "Daniel", "Snow", new Date(1944, 4, 4), "34 Run Avenue", "(302)-254-64no",
					"nsnow@gmail.com", "Tuesday 1-3pm", 7, 101000.00, new Date(1966, 2, 16), eTitle.MR);
		}
		catch(PersonException e)
		{
			wasThrown2 = true;
		}
		assertTrue(wasThrown2);
	}	

	
}

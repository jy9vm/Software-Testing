import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class CalTest {

	@Test
	//Checking for correct result for the same days
	public void test1() {
		int month1 = 2;
		int day1 = 10;
		int month2 = 2;
		int day2 = 10;
		int year = 2000;
		
		int result = Cal.cal(month1, day1, month2, day2, year);
		assertEquals(0, result);
	}

	@Test
	//Checking for correct result between two different days in the same month
	public void test2() {
		int month1 = 2;
		int day1 = 10;
		int month2 = 2;
		int day2 = 22;
		int year = 1999;
		
		int result = Cal.cal(month1, day1, month2, day2, year);
		assertEquals(12, result);
	}
	
	@Test
	//Checking for correct result between two different days in different months,
	//where the difference between the months is 1. (February is not used)
	public void test3() {
		int month1 = 4;
		int day1 = 10;
		int month2 = 5;
		int day2 = 22;
		int year = 1999;
		
		int result = Cal.cal(month1, day1, month2, day2, year);
		assertEquals(42, result);
	}
	
	@Test
	//Checking for correct result between two different days in different months,
	//where the difference between the months is more than 1. (February is not used)
	public void test4() {
		int month1 = 4;
		int day1 = 10;
		int month2 = 8;
		int day2 = 22;
		int year = 2016;
		
		int result = Cal.cal(month1, day1, month2, day2, year);
		assertEquals(134, result);
	}
	
	@Test
	//Checking for correct result between two dates which in which a leap day is included
	public void test5() {
		int month1 = 2;
		int day1 = 10;
		int month2 = 10;
		int day2 = 22;
		int year = 2016;
		
		int result = Cal.cal(month1, day1, month2, day2, year);
		assertEquals(255, result);
	}
	
	@Test
	//Checking for correct result between two dates which in which a leap day is not included
	public void test6() {
		int month1 = 2;
		int day1 = 10;
		int month2 = 10;
		int day2 = 22;
		int year = 2017;
		
		int result = Cal.cal(month1, day1, month2, day2, year);
		assertEquals(254, result);
	}
	
	@Test
	//Checking for correct result between the beginning and end of the year
	public void test7() {
		int month1 = 1;
		int day1 = 1;
		int month2 = 12;
		int day2 = 31;
		int year = 2018;
		
		int result = Cal.cal(month1, day1, month2, day2, year);
		assertEquals(364, result);
	}
	
	//Checking for correct result for start and end of a month
	@Test
	public void test8() {
		int month1 = 1;
		int day1 = 1;
		int month2 = 1;
		int day2 = 31;
		int year = 2018;
		
		int result = Cal.cal(month1, day1, month2, day2, year);
		assertEquals(30, result);
	}
	
	//Checking boundary condition when year is 1
	@Test
	public void test9() {
		int month1 = 3;
		int day1 = 5;
		int month2 = 3;
		int day2 = 20;
		int year = 1;
		
		int result = Cal.cal(month1, day1, month2, day2, year);
		assertEquals(15, result);
	}
	
	//Checking boundary condition when year is 10000
	@Test
	public void test10() {
		int month1 = 3;
		int day1 = 5;
		int month2 = 3;
		int day2 = 20;
		int year = 10000;
		
		int result = Cal.cal(month1, day1, month2, day2, year);
		assertEquals(15, result);
	}
	
	//Checking boundary condition when I use the dates 11/5/2018 and 11/31/2018
	@Test(expected=IOException.class)
	public void test11() {
		int month1 = 11;
		int day1 = 5;
		int month2 = 11;
		int day2 = 31;
		int year = 2018;
		
		Cal.cal(month1, day1, month2, day2, year);
	}
	
	
}

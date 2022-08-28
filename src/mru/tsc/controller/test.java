package mru.tsc.controller;

import org.junit.Assert;

import java.util.ArrayList;

import org.junit.Test;

import mru.tsc.model.*;



class ControllerTest {

	@Test
	void testAnimalName() {
		Toy t = new Animal(0, "x", "xy", 0, 0, "b", "c", '0');
		String result = t.getName();
		Assert.assertEquals("x", result);
	}
	

	
	@Test
	void testFigureBrand() {
		Toy t = new Figure(011204114212, "x", "xy", 0, 0, "b", '0');
		String result = t.getBrand();
		Assert.assertEquals("xy", result);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testFigurePrice() {
		Toy t = new Figure(011204114212, "x", "xy", 30.35, 0, "b", '0');
		double result = t.getPrice();
		Assert.assertEquals(30.35, result);
	}
	
	@Test
	void testFigureAge() {
		Toy t = new Figure(011204114212, "x", "xy", 30.35, 0, "b", '0');
		String  result = t.getAgeAppropriate();
		Assert.assertEquals("b", result);
	}
	
	@Test
	void testFigureMaterial() {
		Toy t = new Animal(011204114212, "x", "xy", 30.35, 10, "b", "c", '0');
		int result = t.getAvailableCount();
		Assert.assertEquals(10, result);
	}
	
	
	
	@Test
	void testFigureName() {
		Toy t = new Figure(0, "x", "xy", 0, 0, "b", '0');
		String result = t.getName();
		Assert.assertEquals("x", result);
	}
	

	
	@Test
	void testAnimalBrand() {
		Toy t = new Animal(011204114212, "x", "xy", 0, 0, "b", "c", '0');
		String result = t.getBrand();
		Assert.assertEquals("xy", result);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testAnimalPrice() {
		Toy t = new Animal(011204114212, "x", "xy", 30.35, 0, "b", "c", '0');
		double result = t.getPrice();
		Assert.assertEquals(30.35, result);
	}
	
	@Test
	void testAnimalAge() {
		Toy t = new Animal(011204114212, "x", "xy", 30.35, 0, "b", "c", '0');
		String  result = t.getAgeAppropriate();
		Assert.assertEquals("b", result);
	}
	
	@Test
	void testAnimalMaterial() {
		Toy t = new Animal(011204114212, "x", "xy", 30.35, 10, "b", "c", '0');
		int result = t.getAvailableCount();
		Assert.assertEquals(10, result);
	}
	
	
	@Test
	void testPuzzleName() {
		Toy t = new Animal(0, "x", "xy", 0, 0, "b", "c", '0');
		String result = t.getName();
		Assert.assertEquals("x", result);
	}
	

	
	@Test
	void testPuzzleBrand() {
		Toy t = new Puzzle(011204114212, "x", "xy", 0, 0, "b","0");
		String result = t.getBrand();
		Assert.assertEquals("xy", result);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testPuzzlePrice() {
		Toy t = new Puzzle(011204114212, "x", "xy", 0, 0, "b","0");
		double result = t.getPrice();
		Assert.assertEquals(30.35, result);
	}
	
	@Test
	void testPuzzleAge() {
		Toy t = new Puzzle(011204114212, "x", "xy", 0, 0, "b","0");
		String  result = t.getAgeAppropriate();
		Assert.assertEquals("b", result);
	}
	
	@Test
	void testPuzzleMaterial() {
		Toy t = new Puzzle(011204114212, "x", "xy", 0, 0, "b","0");
		int result = t.getAvailableCount();
		Assert.assertEquals(10, result);
	}
	
	
	
	
	
	
	
	






}


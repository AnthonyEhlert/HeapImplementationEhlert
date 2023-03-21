package tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import Exceptions.HeapEmptyException;
import Exceptions.HeapFullException;
import MainClasses.Heap;

/*****************************************************************
 * Name				: HeapImplementationEhlert
 * Author			: Tony Ehlert
 * Created			: Mar 16, 2023
 * Course			: CIS152 Data Structures
 * Version			: 1.0
 * OS				: Windows 11
 * Copyright		: This is my own original work based on
 *         	  	  	  specifications issued by our instructor
 * Description		: This program contains the classes and methods to implement a max heap data structure.
 * 					  It also includes a driver/test class to test the class and methods
 *					 Input: Integer numbers to be stored in the heap
 *					 Output: Prints to the console after each method to prove that a method worked as intended.
 * Academic Honesty	: I attest that this is my original work.
 * I have not used unauthorized source code, either modified or 
 * unmodified. I have not given other fellow student(s) access to
 * my program.         
 *****************************************************************/

class HeapImplementationTest {

	@Test
	void testHeap() {
		// ARRANGE
		int maxSize = 3;
		Heap myHeap = new Heap(maxSize);
		boolean actual;
		// ACT
		actual = myHeap.isEmpty();
		// ASSERT
		assertTrue(actual);
	}

	@Test
	void testIsEmptyTrue() throws HeapFullException, HeapEmptyException{
		// ARRANGE
		int maxSize = 3;
		Heap myHeap = new Heap(maxSize);
		boolean actual;
		double num1 = 1.1;
		// ACT
		myHeap.insert(num1);
		myHeap.removeMax();
		actual = myHeap.isEmpty();
		// ASSERT
		assertTrue(actual);
	}

	@Test
	void testIsEmptyFalse() throws HeapFullException {
		// ARRANGE
		int maxSize = 1;
		Heap myHeap = new Heap(maxSize);
		boolean actual;
		double num1 = 1.1;
		// ACT
		myHeap.insert(num1);
		actual = myHeap.isEmpty();
		// ASSERT
		assertFalse(actual);
	}
	
	@Test
	void testSize() throws HeapEmptyException, HeapFullException {
		// ARRANGE
		int maxSize = 3;
		Heap myHeap = new Heap(maxSize);
		int actual;
		double num1 = 1.1;
		double num2 = 2.2;
		double num3 = 3.3;
		int expected = 2;
		// ACT
		myHeap.insert(num1);
		myHeap.insert(num2);
		myHeap.insert(num3);
		myHeap.removeMax();
		actual = myHeap.size();
		// ASSERT
		assertEquals(expected, actual);
	}
	
	@Test
	void testSizeZero() throws HeapEmptyException, HeapFullException {
		// ARRANGE
		int maxSize = 3;
		Heap myHeap = new Heap(maxSize);
		int actual;
		int expected = 0;
		// ACT
		actual = myHeap.size();
		// ASSERT
		assertEquals(expected, actual);
	}
	
	@Test
	void testPrintHeap() throws HeapEmptyException, HeapFullException {
		// ARRANGE
		int maxSize = 3;
		Heap myHeap = new Heap(maxSize);
		String actual;
		double num1 = 1.1;
		double num2 = 2.2;
		double num3 = 3.3;
		String expected = "[3.3, 1.1, 2.2, ]";
		// ACT
		myHeap.insert(num1);
		myHeap.insert(num2);
		myHeap.insert(num3);
		actual = myHeap.printHeap();
		// ASSERT
		assertEquals(expected, actual);
	}
	
	@Test
	void testPrintHeapEmptyHeap() throws HeapEmptyException {
		// ARRANGE
		int maxSize = 1;
		Heap myHeap = new Heap(maxSize);
		// ACT
		// ASSERT
		assertThrows(HeapEmptyException.class, () -> myHeap.printHeap());
	}
	
	@Test
	void testRemoveMax() throws HeapEmptyException, HeapFullException {
		// ARRANGE
		int maxSize = 3;
		Heap myHeap = new Heap(maxSize);
		String actual;
		double num1 = 1.1;
		double num2 = 2.2;
		double num3 = 3.3;
		String expected = "[2.2, 1.1, ]";
		// ACT
		myHeap.insert(num1);
		myHeap.insert(num2);
		myHeap.insert(num3);
		myHeap.removeMax();
		actual = myHeap.printHeap();
		// ASSERT
		assertEquals(expected, actual);
	}
	
	@Test
	void testRemoveMaxReturn() throws HeapEmptyException, HeapFullException {
		// ARRANGE
		int maxSize = 3;
		Heap myHeap = new Heap(maxSize);
		double actual;
		double num1 = 1.1;
		double num2 = 2.2;
		double num3 = 3.3;
		double expected = 3.3;
		// ACT
		myHeap.insert(num1);
		myHeap.insert(num2);
		myHeap.insert(num3);
		actual = myHeap.removeMax();
		// ASSERT
		assertEquals(expected, actual);
	}
	
	@Test
	void testRemoveMaxEmptyHeap() throws HeapEmptyException {
		// ARRANGE
		int maxSize = 1;
		Heap myHeap = new Heap(maxSize);
		// ACT
		// ASSERT
		assertThrows(HeapEmptyException.class, () -> myHeap.removeMax());
	}
	
	@Test
	void testInsert() throws HeapFullException, HeapEmptyException {
		// ARRANGE
		int maxSize = 1;
		Heap myHeap = new Heap(maxSize);
		double actual;
		double num1 = 1.1;
		double expected = 1.1;
		// ACT
		myHeap.insert(num1);
		actual = myHeap.getMax();
		// ASSERT
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testInsertFullHeap() throws HeapFullException {
		// ARRANGE
		int maxSize = 1;
		Heap myHeap = new Heap(maxSize);
		double num1 = 1.1;
		double num2 = 2.2;
		myHeap.insert(num1);;
		// ACT
		// ASSERT
		assertThrows(HeapFullException.class, () -> myHeap.insert(num2));
	}
	
	@Test
	void testGetMax() throws HeapFullException, HeapEmptyException {
		// ARRANGE
		int maxSize = 3;
		Heap myHeap = new Heap(maxSize);
		double actual;
		double num1 = 1.1;
		double num2 = 2.2;
		double num3 = 3.3;
		double expected = 2.2;
		// ACT
		myHeap.insert(num1);
		myHeap.insert(num2);
		myHeap.insert(num3);
		myHeap.removeMax();
		actual = myHeap.getMax();
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	void testGetMaxEmptyHeap() throws HeapEmptyException {
		// ARRANGE
		int maxSize = 1;
		Heap myHeap = new Heap(maxSize);
		// ACT
		// ASSERT
		assertThrows(HeapEmptyException.class, () -> myHeap.getMax());
	}
	
	@Test
	void testHeapSort() throws HeapEmptyException, HeapFullException {
		// ARRANGE
		double[] heapArray = new double[] {73.2, 84, 75.3, 92.3, 85.6, 45.2, 83.2, 84.2, 94.4, 99.8, 85.4, 101.1, 100.3};
		Heap myHeap = new Heap(heapArray.length);
		for(int i = 0; i < heapArray.length; i++) {
			myHeap.insert(heapArray[i]);
		}
		double[] actual;
		double[] expected = new double[] {45.2, 73.2, 75.3, 83.2, 84.0, 84.2, 85.4, 85.6, 92.3, 94.4, 99.8, 100.3, 101.1};
		// ACT
		actual = myHeap.heapSort();
		// ASSERT
		assertTrue(java.util.Arrays.equals(expected, actual));
	}
	
	@Test
	void testHeapSortEmptyHeap() throws HeapEmptyException {
		// ARRANGE
		int maxSize = 1;
		Heap myHeap = new Heap(maxSize);
		// ACT
		// ASSERT
		assertThrows(HeapEmptyException.class, () -> myHeap.heapSort());
	}
	
	@Test
	void testBuildMaxHeap() throws HeapFullException, HeapEmptyException {
		// ARRANGE
		double[] heapArray = new double[] {1.1, 3.3, 2.2, 4.4, 5.5};
		Heap myHeap = new Heap(heapArray.length);
		myHeap = myHeap.buildMaxHeap(heapArray);
		String actual;
		String expected = "[5.5, 4.4, 2.2, 3.3, 1.1, ]";
		// ACT
		actual = myHeap.printHeap();
		// ASSERT
		assertEquals(expected, actual);
	}
	
	@Test
	void testRemoveEmpty() throws HeapFullException, HeapEmptyException {
		// ARRANGE
		double[] heapArray = new double[] {1.1, 3.3, 2.2, 4.4, 5.5};
		Heap myHeap = new Heap(heapArray.length);
		// ACT
		// ASSERT
		assertThrows(HeapEmptyException.class, () -> myHeap.remove(0));
	}
	
	@Test
	void testRemove() throws HeapFullException, HeapEmptyException {
		// ARRANGE
		double[] heapArray = new double[] {1.1, 3.3, 2.2, 4.4, 5.5};
		Heap myHeap = new Heap(heapArray.length);
		myHeap = myHeap.buildMaxHeap(heapArray);
		myHeap.remove(2);
		String actual;
		String expected = "[5.5, 4.4, 1.1, 3.3, ]";
		// ACT
		actual = myHeap.printHeap();
		// ASSERT
		assertEquals(expected, actual);
	}
}
package MainClasses;
import Exceptions.HeapEmptyException;
import Exceptions.HeapFullException;

/*****************************************************************
 * Name				: HeapImplementationEhlert
 * Author			: Tony Ehlert
 * Created			: Mar 21, 2023
 * Course			: CIS152 Data Structures
 * Version			: 1.0
 * OS				: Windows 11
 * Copyright		: This is my own original work based on
 *         	  	  	  specifications issued by our instructor
 * Description		: This program contains the classes and methods to implement a max heap data structure.
 * 					  It also includes a driver and test class to test the class and methods
 *					 Input: Integer numbers to be stored in the heap
 *					 Output: Prints to the console after each method to prove that a method worked as intended.
 * Academic Honesty	: I attest that this is my original work.
 * I have not used unauthorized source code, either modified or 
 * unmodified. I have not given other fellow student(s) access to
 * my program.         
 *****************************************************************/
public class HeapDriver {

	public static void main(String[] args) {
		
		// array of numbers to be added to heap
		double[] heapArray = new double[] {73.2, 84, 75.3, 92.3, 85.6, 45.2, 83.2, 84.2, 94.4, 99.8, 85.4, 101.1, 100.3};

		Heap testHeap1 = new Heap(heapArray.length);
		
		// test buildMaxHeap()
		Heap testHeap2 = new Heap(heapArray.length);
		try {
			testHeap2 = testHeap1.buildMaxHeap(heapArray);
		} catch (HeapFullException e) {
			System.out.println("buildMaxHeap() HeapFullException thrown");
		}
		
		System.out.println("////START OF isEmpty() TESTS\\\\\\\\");
		
		System.out.println("isEmpty() is true Test: " + testHeap1.isEmpty());
		try {
			testHeap1.insert(12.2);
			System.out.println("isEmpty() is false Test: " + testHeap1.isEmpty());
			testHeap1.removeMax();
		} catch (HeapFullException e) {
			System.out.println("insert() HeapFullException thrown");
		} catch (HeapEmptyException e) {
			System.out.println("isEmpty() HeapEmptyException thrown");
		}
		System.out.println("isEmpty() is false Test: " + testHeap1.isEmpty());
		System.out.println("////END OF isEmpty() TESTS\\\\\\\\\n");
		
		
		try {
			for(int i = 0; i < heapArray.length; i++) {
				testHeap1.insert(heapArray[i]);
			}
		} catch (HeapFullException e) {
			System.out.println("insert() HeapFullException thrown");
		}
		
		
		System.out.println("\n////START OF HEAPS CONTENTS USING printHeap() TESTS\\\\\\\\");
		System.out.println("Contents & size of testHeap1:");
		String heapContents;
		try {
			heapContents = testHeap1.printHeap();
			System.out.println("testHeap1 Contents (after using insert()): " + heapContents);
		} catch (HeapEmptyException e1) {
			System.out.println("printHeap() HeapEmptyException Thrown");
		}
		
		System.out.println("testHeap1 Size: " + testHeap1.size());
		try {
			System.out.println("Max Value of testHeap1: " + testHeap1.getMax());
		} catch (HeapEmptyException e1) {
			System.out.println("peek() HeapEmptyExcetpion thrown");
		}
		
		System.out.println("");
		System.out.println("Contents and size of testHeap2 built from buildMaxHeap() method: ");
		try {
			System.out.println("testHeap2 Contents: " + testHeap2.printHeap());
		} catch (HeapEmptyException e) {
			System.out.println("printHeap() HeapEmptyException Thrown");
		}
		
		System.out.println("testHeap2 Size: " + testHeap2.size());
		try {
			System.out.println("Max Value of testHeap2: " + testHeap2.getMax());
		} catch (HeapEmptyException e1) {
			System.out.println("peek() HeapEmptyExcetpion thrown");
		}
		System.out.println("////END OF HEAPS CONTENTS USING printHeap() TESTS\\\\\\\\");
		
		
		System.out.println("\n////START OF removeMax() TESTS\\\\\\\\");
		try {
			testHeap1.removeMax();
		} catch (HeapEmptyException e) {
			System.out.println("removeMax() HeapEmptyExcetpion thrown");
		}
		try {
			System.out.println("Max Value after call of removeMax(): " + testHeap1.getMax());
			System.out.println("Size after call of removeMax(): " + testHeap1.size());
		} catch (HeapEmptyException e1) {
			System.out.println("peek() HeapEmptyExcetpion thrown");
		}
		
		try {
			testHeap1.removeMax();
		} catch (HeapEmptyException e) {
			System.out.println("removeMax() HeapEmptyExcetpion thrown");
		}
		try {
			System.out.println("Max Value after 2nd call of removeMax(): " + testHeap1.getMax());
			System.out.println("Size after 2nd call of removeMax(): " + testHeap1.size());
		} catch (HeapEmptyException e) {
			System.out.println("peek() HeapEmptyExcetpion thrown");
		}
		System.out.println("////END OF removeMax() TESTS\\\\\\\\");
		
		System.out.println("\n////START OF remove() TESTS\\\\\\\\");
		try {
			heapContents = testHeap1.printHeap();
			System.out.println("testHeap1 Contents before remove(): " + heapContents);
			testHeap1.remove(4);
			heapContents = testHeap1.printHeap();
			System.out.println("testHeap1 Contents after remove(4) aka 92.3: " + heapContents);
		} catch (HeapEmptyException e1) {
			System.out.println("printHeap() HeapEmptyException Thrown");
		}
		System.out.println("////END OF remove() TESTS\\\\\\\\");
		
		
		System.out.println("\n////START OF heapSort() TESTS\\\\\\\\");
		double[] sortedHeap1;
		double[] sortedHeap2;
		try {
			// sorting of testHeap1
			sortedHeap1 = testHeap1.heapSort();
			System.out.print("Array after heapSort() on testHeap1: [");
			for (int i = 0; i < sortedHeap1.length; i++) {
				System.out.print(sortedHeap1[i] + ", ");
			}
			System.out.print("]\n");
			
			// sorting of testHeap2
			sortedHeap2 = testHeap2.heapSort();
			System.out.print("Array after heapSort() on testHeap2: [");
			for (int i = 0; i < sortedHeap2.length; i++) {
				System.out.print(sortedHeap2[i] + ", ");
			}
			System.out.print("]\n");
			
		} catch (HeapEmptyException e) {
			System.out.println("heapSort() HeapEmptyExcetpion thrown");
		}
		System.out.println("////END OF heapSort() TESTS\\\\\\\\");
		
	}

}

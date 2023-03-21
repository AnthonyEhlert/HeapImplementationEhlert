package MainClasses;
import Exceptions.HeapEmptyException;
import Exceptions.HeapFullException;

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
 * 					  It also includes a driver and test class to test the class and methods
 *					 Input: Integer numbers to be stored in the heap
 *					 Output: Prints to the console after each method to prove that a method worked as intended.
 * Academic Honesty	: I attest that this is my original work.
 * I have not used unauthorized source code, either modified or 
 * unmodified. I have not given other fellow student(s) access to
 * my program.         
 *****************************************************************/
public class Heap {

	//****DATA MEMBERS****\\
	private double[] arr;
	private int maxSize;
	private int size;
	
	//****CONSTRUCTORS****\\
	
	/**
	 * default no-arg constructor with private access modifier to force usage of
	 * other constructors
	 */
	private Heap() {
		this.maxSize = 0;
		this.arr = new double[maxSize];
		this.size = 0;
	}
	
	/**
	 * This constructors accepts an integer indicating the max number of elements
	 * the heap can hold and creates an empty array equal to the maxSize argument
	 * and sets the size variable to 0.
	 * 
	 * @param maxSize - maximum number of elements that can be stored in heap
	 */
	public Heap(int maxSize) {
		this.maxSize = maxSize;
		this.arr = new double[maxSize];
		this.size = 0;
	}
	
	//****NECESSARY METHODS FOR IMPLEMENTATION****\\
	
	/**
	 * This method returns the current number of elements stored in the heap
	 * 
	 * @return - integer representing the number of elements currently stored in the heap
	 */
	public int size() {
		return size;
	}
	
	/**
	 * This method returns a boolean value indicating whether or not
	 * the heap is empty by evaluating if the size is greater than zero
	 * 
	 * @return - true/false indicating if the heap is empty or not
	 */
	public boolean isEmpty() {
		return (size <= 0);
	}
	
	/**
	 * This method creates a string that contains the contents of the heap
	 * 
	 * @return - string containing the contents of the heap
	 */
	public String printHeap() throws HeapEmptyException {
		
		// check if heap is empty, if empty, throw exception
		if (size <= 0) {
			throw new HeapEmptyException();
		}
		
		// create variable to hold contents of heap
		String heapString = "[";
		
		// loop until all elements are added to string
		for (int i = 0; i < size; i++) {
			heapString += arr[i] + ", ";
		}
		
		heapString += "]";
		
		return heapString;
	}
	
	/**
	 * This method takes the element at the current root and swaps it with
	 * the last element in the heap and then reduces the heap size by one
	 * 
	 * @return - max element of heap
	 * @throws HeapEmptyException
	 */
	public double removeMax() throws HeapEmptyException {
		
		// check if heap is empty or not, if empty, throw exception
		if (size <= 0) {
			throw new HeapEmptyException();
		}
		
		// if size of heap is 1, reduce size and end method with return
		if (size == 1) {
			size--;
			return arr[0];
		}
		
		// assign current root to variable to return
		double maxValue = arr[0];
		
		// swap current root with last element in heap array
		// and reduce size by one
		arr[0] = arr[size - 1];
		size--;
		
		// call maxHeapify on new root (previous last element in heap array) to restore heap properties
		maxHeapify(0);
		
		// return max element
		return maxValue;
		
	}
	
	/**
	 * This method inserts a new element into the heap and then calls
	 * the maxHeapify method to ensure the heap maintains its
	 * heap properties
	 * 
	 * @param key - value of element to be inserted into heap
	 * @throws HeapFullException
	 */
	public void insert(double key) throws HeapFullException{
		
		// check if heap is full or not, if so throw exception
		if (size >= maxSize) {
			throw new HeapFullException();
		}
		
		// increase size by one
		size++;
		
		// get index of next empty element in heap and assign to variable
		int next = size - 1;
		
		// insert key in index of next element position
		arr[next] = key;
		
		// check heap property and fix if
		// heap property is not valid
		// first check to ensure index of next != 0 and 
		// if parent of index of next is greater than key stored at index of next
		while (next != 0 && arr[parent(next)] < arr[next]) {
			// temp variable to hold value of index of next
			double temp = arr[next];
			
			// make index of next equal to value of parent
			arr[next] = arr[parent(next)];
			
			// assign temp value to index of parent of next
			arr[parent(next)] = temp;
			
			// change next index variable to parent index
			next = parent(next);
		}
	}
	
	/**
	 * This method simply returns the value/key of the largest element in the heap
	 * (aka the value of the root) and leaves the heap unchanged
	 * 
	 * @return - value/key of the largest element in the heap (root node)
	 * @throws HeapEmptyException
	 */
	public double getMax() throws HeapEmptyException {
		if (size <= 0) {
			throw new HeapEmptyException ();
		}
		
		return arr[0];
	}
	
	/**
	 * This method sorts the heap and rearranges the elements in the array based on
	 * size(largest to smallest)
	 * 
	 * @throws HeapEmptyException
	 */
	public double[] heapSort() throws HeapEmptyException {
		
		// check if heap is empty
		if (size <= 0) {
			throw new HeapEmptyException();
		}
		
		// create new array to store sorted elements
		double[] heapSort = new double[size];
		
		// loop until all elements sorted
		for (int i = size - 1;  i >= 0; i--) {
			// swap root element and last element
			double temp = arr[0];
			arr[0] = arr[size - 1];
			arr[size - 1] = temp;
			
			// add temp value to last element in heapSort array
			heapSort[size - 1] = temp;
			
			// reduce size by 1
			size--;
			
			// heapify
			maxHeapify(0);
		}
		
		return heapSort;
	}
	
	public Heap buildMaxHeap(double[] doubleArr) throws HeapFullException {
		Heap heapToBuild = new Heap(doubleArr.length);
		for (int i = doubleArr.length - 1; i >= 0; i--) {
			// check if heap is full or not, if so throw exception
			if (heapToBuild.size >= heapToBuild.maxSize) {
				throw new HeapFullException();
			}
			heapToBuild.insert(doubleArr[i]);
		}
		return heapToBuild;
	}
	
	//****PRIVATE METHODS****\\
	
	
	/**
	 * This method creates a heap structure (or restores it after insertion or
	 * deletion) based off of the index of the element provided in the argument.
	 * 
	 * @param index - index of the element to be root of heap
	 */
	private void maxHeapify(int index) {
		
		// variable for left child index
		int left = lChild(index);
		
		// variable for right child index
		int right = rChild(index);
		
		// variable to hold index of largest value found (set initially to element at index passed in)
		int largest = index;
		
		// check to ensure lChild return value does not create index out of bounds error and
		// if left child value is greater than value at index, if so left is now largest
		if (left < size && arr[left] > arr[index]) {
			largest = left;
		}
		
		// check to ensure rChild return value does not create index out of bounds error and
		// if right child value is greater than current largest, if so right is now largest
		if (right < size && arr[right] > arr[largest]) {
			largest = right;
		}
		
		// if index of largest is not the root (aka 0) run maxHeapify again using index of largest
		if (largest != index) {
			double temp = arr[index];
			arr[index] = arr[largest];
			arr[largest] = temp;
			maxHeapify(largest);
		}
		
	}
	
	/**
	 * This method accepts the position/index of an element and returns
	 * the position/index of its parent element in the heap
	 * 
	 * @param i - index of element to retrieve the parent of
	 * @return - index of parent element
	 */
	private int parent(int i) {
		return (i - 1)/2;
	}
	
	/**
	 * This method accepts the position/index of an element and returns
	 * the position/index of its left child element in the heap
	 * 
	 * @param i - index of parent element
	 * @return - index of parent element
	 */
	private int lChild(int i) {
		return ((i * 2) + 1);
	}
	
	/**
	 * This method accepts the position/index of an element and returns
	 * the position/index of its right child element in the heap
	 * 
	 * @param i - index of parent element
	 * @return - index of parent element
	 */
	private int rChild(int i) {
		return ((i * 2) + 2);
	}
	
}

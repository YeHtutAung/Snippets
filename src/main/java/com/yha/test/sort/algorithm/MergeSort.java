/**
 * 
 */
package com.yha.test.sort.algorithm;

/**
 * @author yehtu
 *
 */
public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 5, 2, 9, 1, 5 };
		System.out.println("Original Array:");
		printArray(array);

		mergeSort(array);

		System.out.println("\nSorted Array:");
		printArray(array);
	}

	// Main merge sort method
	public static void mergeSort(int[] array) {
		if (array == null || array.length <= 1) {
			return; // Base case: array is already sorted or empty
		}

		int n = array.length;
		int[] tempArray = new int[n]; // Temporary array for merging

		mergeSortHelper(array, tempArray, 0, n - 1);
	}

	// Recursive helper method for merge sort
	private static void mergeSortHelper(int[] array, int[] tempArray, int left, int right) {
		if (left >= right) {
			return; // Base case: subarray has only one element (already sorted)
		}

		int mid = left + (right - left) / 2; // Calculate the middle index

		mergeSortHelper(array, tempArray, left, mid); // Sort left subarray
		mergeSortHelper(array, tempArray, mid + 1, right); // Sort right subarray

		merge(array, tempArray, left, mid, right); // Merge the two sorted subarrays
	}

	// Merge two sorted subarrays into a single sorted array
	private static void merge(int[] array, int[] tempArray, int left, int mid, int right) {
		// Copy elements to the temporary array
		System.arraycopy(array, left, tempArray, left, right - left + 1);

		int leftPointer = left;
		int rightPointer = mid + 1;
		int current = left;

		// Merge the two subarrays by comparing and merging elements
		while (leftPointer <= mid && rightPointer <= right) {
			if (tempArray[leftPointer] <= tempArray[rightPointer]) {
				array[current] = tempArray[leftPointer];
				leftPointer++;
			} else {
				array[current] = tempArray[rightPointer];
				rightPointer++;
			}
			current++;
		}

		// Copy remaining elements from the left subarray, if any
		while (leftPointer <= mid) {
			array[current] = tempArray[leftPointer];
			leftPointer++;
			current++;
		}
	}

	// Helper method to print the array
	public static void printArray(int[] array) {
		for (int num : array) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

}

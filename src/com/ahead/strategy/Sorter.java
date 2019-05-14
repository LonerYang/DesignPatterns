package com.ahead.strategy;

public class Sorter<T> {
	
	public void sort(T[] arr, Comparator<T> com) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minPos = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (com.compare(arr[minPos], arr[j]) == 1) {
					minPos = j;
				}
			}
			swap(minPos, i, arr);
		}
		
	}
	
	private void swap(int i, int j, T[] arr) {
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

package algorithmsImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuickSort {
	public static void main(String[] args) {
		List<Integer> numbersList = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the numbers to be sorted[Press exit after giving all numbers]");
		while(scanner.hasNextInt()) {
			numbersList.add(scanner.nextInt());
		}
		System.out.println("Numbers Given: ");
		System.out.println(numbersList.toString());
		QuickSortAlgorithm(numbersList, 0, numbersList.size() - 1);
		System.out.println("Final Sorted List: " + numbersList.toString());
		
	}
	
	public static void QuickSortAlgorithm(List<Integer> tempSortedNumbers, int lowerIndex, int higherIndex){
		if(lowerIndex >= higherIndex) {
			return;
		}
		int middleIndex = partition(tempSortedNumbers, lowerIndex, higherIndex);
		QuickSortAlgorithm(tempSortedNumbers, lowerIndex, middleIndex - 1);
		QuickSortAlgorithm(tempSortedNumbers, middleIndex + 1, higherIndex);
	}
	
	public static int partition(List<Integer> tempSortedNumbers, int lowerIndex, int higherIndex) {
		int pivot = tempSortedNumbers.get(lowerIndex);
		int comparingIndex = lowerIndex;
		int tempSwap;
		for(int i = lowerIndex + 1; i <= higherIndex; i++) {
			if(tempSortedNumbers.get(i) <= pivot) {
				comparingIndex = comparingIndex + 1;
				tempSwap = tempSortedNumbers.get(comparingIndex);
				tempSortedNumbers.set(comparingIndex, tempSortedNumbers.get(i));
				tempSortedNumbers.set(i, tempSwap);
			}
		}
		System.out.println("Sorted Iterations: " + tempSortedNumbers.toString());
		tempSwap = tempSortedNumbers.get(lowerIndex);
		tempSortedNumbers.set(lowerIndex, tempSortedNumbers.get(comparingIndex));
		tempSortedNumbers.set(comparingIndex, tempSwap);
		return comparingIndex;
	}
	
}

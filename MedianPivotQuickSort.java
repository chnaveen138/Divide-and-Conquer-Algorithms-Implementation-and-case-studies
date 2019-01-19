package algorithmsImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MedianPivotQuickSort {

	public static void main(String[] args) {
		List<Integer> numbersList = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the numbers to be sorted[Press exit after giving all numbers]");
		while (scanner.hasNextInt()) {
			numbersList.add(scanner.nextInt());
		}
		System.out.println("Numbers Given: ");
		System.out.println(numbersList.toString());
		QuickSortAlgorithm(numbersList, 0, numbersList.size() - 1);
		System.out.println("Final Sorted List: " + numbersList.toString());

	}

	public static void QuickSortAlgorithm(List<Integer> tempSortedNumbers, int lowerIndex, int higherIndex) {
		if (lowerIndex >= higherIndex) {
			return;
		}
		int middleIndex = partition(tempSortedNumbers, lowerIndex, higherIndex);
		QuickSortAlgorithm(tempSortedNumbers, lowerIndex, middleIndex - 1);
		QuickSortAlgorithm(tempSortedNumbers, middleIndex + 1, higherIndex);
	}

	public static int partition(List<Integer> tempSortedNumbers, int lowerIndex, int higherIndex) {
		int comparingIndex = lowerIndex;
		int tempSwap;
		int pivotIndex = getMedianPivotIndex(tempSortedNumbers, lowerIndex, higherIndex);
		tempSwap = tempSortedNumbers.get(lowerIndex);
		tempSortedNumbers.set(lowerIndex, tempSortedNumbers.get(pivotIndex));
		tempSortedNumbers.set(pivotIndex, tempSwap);
		int pivot = tempSortedNumbers.get(lowerIndex);
		for (int i = lowerIndex + 1; i <= higherIndex; i++) {
			if (tempSortedNumbers.get(i) <= pivot) {
				comparingIndex = comparingIndex + 1;
				tempSwap = tempSortedNumbers.get(comparingIndex);
				tempSortedNumbers.set(comparingIndex, tempSortedNumbers.get(i));
				tempSortedNumbers.set(i, tempSwap);
			}
		}
		tempSwap = tempSortedNumbers.get(lowerIndex);
		tempSortedNumbers.set(lowerIndex, tempSortedNumbers.get(comparingIndex));
		tempSortedNumbers.set(comparingIndex, tempSwap);
		System.out.println("Sorted Iterations: " + tempSortedNumbers.toString());
		return comparingIndex;
	}
	
	public static int getMedianPivotIndex(List<Integer> tempSortedNumbers, int lowerIndex, int higherIndex) {
		int avgIndex = Math.round((lowerIndex + higherIndex) / 2);
		if(tempSortedNumbers.get(lowerIndex) > tempSortedNumbers.get(avgIndex)) {
			if(tempSortedNumbers.get(avgIndex) > tempSortedNumbers.get(higherIndex)) {
				return avgIndex;
			}
			else if(tempSortedNumbers.get(lowerIndex) > tempSortedNumbers.get(higherIndex)){
				return higherIndex;
			}
			else {
				return lowerIndex;
			}
		}
		else {
			if(tempSortedNumbers.get(lowerIndex) > tempSortedNumbers.get(higherIndex)) {
				return lowerIndex;
			}
			else if(tempSortedNumbers.get(avgIndex) < tempSortedNumbers.get(higherIndex)) {
				return avgIndex;
			}
			else {
				return higherIndex;
			}
		}
	}

}

package algorithmsImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SelectiveRecursiveCallQuickSort {

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
		int tempSwap;
		while (lowerIndex < higherIndex) {
			Random randomPivot = new Random();
			int pivotIndex = randomPivot.nextInt(higherIndex - lowerIndex) + lowerIndex;
			tempSwap = tempSortedNumbers.get(lowerIndex);
			tempSortedNumbers.set(lowerIndex, tempSortedNumbers.get(pivotIndex));
			tempSortedNumbers.set(pivotIndex, tempSwap);
			System.out.println("Pivot Index: " + pivotIndex + ", Pivot Element: " + tempSortedNumbers.get(lowerIndex));

			int middleIndex = partition(tempSortedNumbers, lowerIndex, higherIndex);
			if (middleIndex - lowerIndex < higherIndex - middleIndex) {
				QuickSortAlgorithm(tempSortedNumbers, lowerIndex, middleIndex - 1);
				lowerIndex = middleIndex + 1;
			} else {
				QuickSortAlgorithm(tempSortedNumbers, middleIndex + 1, higherIndex);
				higherIndex = middleIndex - 1;
			}
		}
	}

	public static int partition(List<Integer> tempSortedNumbers, int lowerIndex, int higherIndex) {
		int pivot = tempSortedNumbers.get(lowerIndex);
		int comparingIndex = lowerIndex;
		int tempSwap;
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

}

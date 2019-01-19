package algorithmsImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class RandomizedQuickSortForEqualElements {

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
		if (lowerIndex >= higherIndex) {
			return;
		}
		Random randomPivot = new Random();
		int pivotIndex = randomPivot.nextInt(higherIndex - lowerIndex) + lowerIndex;

		tempSwap = tempSortedNumbers.get(lowerIndex);
		tempSortedNumbers.set(lowerIndex, tempSortedNumbers.get(pivotIndex));
		tempSortedNumbers.set(pivotIndex, tempSwap);
		System.out.println("Pivot Index: " + pivotIndex + ", Pivot Element: " + tempSortedNumbers.get(lowerIndex));

		int[] middleIndexes = partition(tempSortedNumbers, lowerIndex, higherIndex);
		QuickSortAlgorithm(tempSortedNumbers, lowerIndex, middleIndexes[0] - 1);
		QuickSortAlgorithm(tempSortedNumbers, middleIndexes[1] + 1, higherIndex);
	}

	public static int[] partition(List<Integer> tempSortedNumbers, int lowerIndex, int higherIndex) {
		int[] middleIndexes = new int[2];
		int pivot = tempSortedNumbers.get(lowerIndex);
		int comparingIndex = lowerIndex;
		int tempSwap, tempPivot, tempMiddleIndex;
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
		tempPivot = tempSwap;
		tempMiddleIndex = comparingIndex;
		for(int i = 0; i < comparingIndex; i++) {
			if(tempSortedNumbers.get(i) == tempPivot) {
				tempSortedNumbers.add(comparingIndex + 1, tempSortedNumbers.get(i));
				tempSortedNumbers.remove(i);
				if(i > comparingIndex)
				tempMiddleIndex = tempMiddleIndex + 1;
				break;
			}
		}
		middleIndexes[0] = comparingIndex;
		middleIndexes[1] = tempMiddleIndex;
		System.out.println("Sorted Iterations: " + tempSortedNumbers.toString());
		System.out.println("Middle Index 1: " + middleIndexes[0] + ", Middle Index 2: " + middleIndexes[1]);
		
		return middleIndexes;
	}

}

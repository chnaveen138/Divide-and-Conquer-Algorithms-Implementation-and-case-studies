package algorithmsImplementation;

import java.util.Scanner;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		List<Long> numberList = new ArrayList<Long>();
		List<Long> sortedList = new ArrayList<Long>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the numbers list to be sorted.[Press \"exit\" after giving all numbers]");
		while (scanner.hasNextLong()) {
			numberList.add(scanner.nextLong());
		}
		System.out.print("The numbers list is: ");
		for (int i = 0; i < numberList.size(); i++) {
			System.out.print(numberList.get(i) + " ");
		}
		System.out.print("\n");
		sortedList = mergeSort(numberList);
		System.out.println("\nThe Sorted list is: ");
		for (int i = 0; i < sortedList.size(); i++) {
			System.out.print(sortedList.get(i) + " ");
		}
	}

	public static List<Long> mergeSort(List<Long> numberList) {
		List<Long> numberListclone = new ArrayList<Long>(numberList);
		List<Long> firstSubNumberList = new ArrayList<Long>();
		List<Long> secondSubNumberList = new ArrayList<Long>();
		List<Long> subListAfterSorted = new ArrayList<Long>();
		if (numberList.size() == 1) {
			return numberList;
		}
		int partToBeDivided = (int) Math.floor(numberList.size() / (double) 2);

		firstSubNumberList = mergeSort(numberList.subList(0, partToBeDivided));
//		System.out.println(Arrays.toString(firstSubNumberList.toArray()));
		secondSubNumberList = mergeSort(numberList.subList(partToBeDivided, numberList.size()));
//		System.out.println(Arrays.toString(secondSubNumberList.toArray()));

		subListAfterSorted = merge(firstSubNumberList, secondSubNumberList);
//		System.out.println(Arrays.toString(subListAfterSorted.toArray()));
		return subListAfterSorted;
	}

	public static List<Long> merge(List<Long> firstSubNumberList, List<Long> secondSubNumberList) {
		List<Long> firstSubNumberListclone = new ArrayList<Long>(firstSubNumberList);
		List<Long> secondSubNumberListclone = new ArrayList<Long>(secondSubNumberList);
		int twoArraysTotalSize = firstSubNumberListclone.size() + secondSubNumberListclone.size();
		List<Long> tempSortedSubList = new ArrayList<Long>();
		while (firstSubNumberListclone.size() != 0 && secondSubNumberListclone.size() != 0) {
			if (firstSubNumberListclone.get(0) <= secondSubNumberListclone.get(0)) {
				tempSortedSubList.add(firstSubNumberListclone.get(0));
				firstSubNumberListclone.remove(0);
			} else {
				tempSortedSubList.add(secondSubNumberListclone.get(0));
				secondSubNumberListclone.remove(0);
			}
		}
		if (firstSubNumberListclone.size() == 0) {
			for (int i = 0; i < secondSubNumberListclone.size(); i++) {
				tempSortedSubList.add(secondSubNumberListclone.get(i));
			}
		} else {
			for (int i = 0; i < firstSubNumberListclone.size(); i++) {
				tempSortedSubList.add(firstSubNumberListclone.get(i));
			}
		}

//		System.out.println(Arrays.toString(tempSortedSubList.toArray()));

		return tempSortedSubList;
	}

}
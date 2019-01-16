package algorithmsImplementation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CountingSort {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		List<Integer> sortedList = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter numbers[only positive integers] to be sorted.[Hit exit after all numbers are given]");
		numbers.add(0);
		while(scanner.hasNextInt()) {
			numbers.add(scanner.nextInt());
		}
		System.out.print("Entered numbers list: " + numbers.toString());
		sortedList = countSort(numbers);
		System.out.print("\nThe sorted list is:");
		for(int i = 1; i < numbers.size(); i++) {
			System.out.print(" " + sortedList.get(i));
		}
	}
	
	private static List<Integer> countSort(List<Integer> numbers) {
		List<Integer> sortedList = new ArrayList<Integer>();
		List<Integer> countList = new ArrayList<Integer>();
		List<Integer> positionsList = new ArrayList<Integer>();
		int maxNumber = Collections.max(numbers);
		for(int i = 0; i <= maxNumber; i++) {
			countList.add(0);
			positionsList.add(0);
		}
		for(int i = 0; i < numbers.size(); i++) {
			sortedList.add(0);
		}
		for(int i = 1; i < numbers.size(); i++) {
			countList.set(numbers.get(i), countList.get(numbers.get(i)) + 1);
		}
		System.out.print("\nCount of numbers: " + countList.toString());
		positionsList.set(1, 1);
		for(int i = 2; i <= maxNumber; i++) {
			positionsList.set(i, (positionsList.get(i - 1) + countList.get(i - 1)));
		}
		System.out.print("\nPositions List: " + countList.toString());
		for(int i = 1; i < numbers.size(); i++) {
			sortedList.set(positionsList.get(numbers.get(i)), numbers.get(i));
			positionsList.set(numbers.get(i), positionsList.get(numbers.get(i)) + 1);
		}
				
		return sortedList;
	}
}

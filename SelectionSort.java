package algorithmsImplementation;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SelectionSort {
	public static void main(String[] args) {
		int sizeOfNumberList = 0;
		int tempMinIndex = 0;
		long tempVariableForSwapping = 0;
		List<Long> numberList = new ArrayList<Long>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the numbers list to be sorted. [Press \"exit\" after inputs given]");
		while(scanner.hasNextLong()) {
			numberList.add(scanner.nextLong());
		}
		sizeOfNumberList = numberList.size();
		System.out.print("Numbers List: ");
		printNumbersList(numberList, sizeOfNumberList);
		for(int i = 0; i < sizeOfNumberList; i++) {
			tempMinIndex = i;
			for(int j = i+1; j < sizeOfNumberList; j++) {
				if(numberList.get(j) < numberList.get(tempMinIndex)) {
					tempMinIndex = j;
				}
			}
			tempVariableForSwapping = numberList.get(tempMinIndex);
			numberList.set(tempMinIndex, numberList.get(i));
			numberList.set(i, tempVariableForSwapping);
		}
		System.out.print("\nNumbers List After Sorted: ");
		printNumbersList(numberList, sizeOfNumberList);
	}
	public static void printNumbersList(List<Long> numberList, int sizeOfNumberList) {
		for(int i = 0; i < sizeOfNumberList; i++) {
			System.out.print(numberList.get(i) + " ");
		}
	}
}

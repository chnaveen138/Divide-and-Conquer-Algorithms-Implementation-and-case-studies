package algorithmsImplementation;

import java.util.Scanner;

public class NaiveAlgorithm {
	
	private static int[] resultPolynomial;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the highest index of two polynomials");
		
		int highestIndex = scanner.nextInt();
		highestIndex = highestIndex + 1;
		int[] firstPolynomial = new int[highestIndex];
		int[] secondPolynomial = new int[highestIndex];
		
		System.out.println("Enter the coefficients of first polynomial");

		for (int i = 0; i < highestIndex; i++) {
			firstPolynomial[i] = scanner.nextInt();
		}
		
		System.out.println("Enter the coefficients of second polynomial");
		
		for(int i = 0; i < highestIndex; i++) {
			secondPolynomial[i] = scanner.nextInt();
		}
		
		MultiplyPolynomials(firstPolynomial, secondPolynomial, highestIndex);
		
		for(int i = 0; i < 2*(highestIndex) - 1; i++) {
			System.out.print(resultPolynomial[i] + " ");
		}
		
	}
	
	private static void MultiplyPolynomials(int[] firstPolynomial, int[] secondPolynomial, int highestIndex) {
		int resultHighestIndex = ((2*highestIndex) - 1);
		resultPolynomial = new int[resultHighestIndex];
		for(int i = 0; i < resultHighestIndex; i++) {
			resultPolynomial[i] = 0;
		}
		
		for(int i = 0; i < highestIndex; i++) {
			for(int j = 0; j < highestIndex; j++) {
				resultPolynomial[i + j] = resultPolynomial[i + j] + firstPolynomial[i] * secondPolynomial[j];
			}
		}
	}

}

package util;

import java.util.*;

public class ScannerInt {
	private static final Scanner scanner = new Scanner(System.in);

	/**
	 * read an integer from 1 (included) to n (excluded) from standard input input
	 * is repeated as long as it is not correct
	 * 
	 * @param n the upper (excluded) bound for input
	 * @return the valid read input
	 */
	public static int readInt(int n) {
		int input = -1;
		while (input < 1 || input >= n) {
			System.out.print("your choice (1-" + (n - 1) + ") ? ");
			try {
				input = scanner.nextInt();
			} catch (InputMismatchException e) {
				// consume the input (that is not an integer)
				scanner.skip(".*");
			}
		}
		return input;
	}

	public static void main(String[] args) {
		System.out.print("Enter an int from 0 to 5 : ");
		int j = ScannerInt.readInt(6);
		System.out.println("you typed : " + j);
	}

}

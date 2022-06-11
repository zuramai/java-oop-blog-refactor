package utils;

import java.util.Scanner;

public class Scan {
	private static Scanner sc = new Scanner(System.in);
	
	public static String scanString() {
		String strings;
		strings = sc.next();
		return strings;
	}

	public static int scanInteger() {
		int num = -1;
		try {
			num = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Input must be a number!");
			num = -1;
		}
		sc.nextLine();
		return num;
	}
}

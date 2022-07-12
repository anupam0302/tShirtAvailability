package com.nagarro.tshirt.availability.input;

import java.util.Scanner;

public class ScannerFactory {

	static Scanner scanner;
	public static Scanner getScanner() {
		if(scanner==null) {
			scanner = new Scanner(System.in);
		}
		return scanner;
	}
	
	public static void closeScanner() {
		scanner.close();
	}
}

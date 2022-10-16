//Andrew Rodriguez
//October 13, 2022
//COP3330 
//Assignment 3: Strings and Method Overloading

import java.util.Scanner;

public class halloween{

	private static int counter = 0;
	static String[] array = { "Pumpkin", "Bat", "Witch", "Vampire" };

	public static String sticker(String message) {
		String res = "";
		for (char ch : message.toCharArray()) {
			if (counter >= 4) {
				counter = 0;
			}
			if (ch == '$') {
				res += array[counter++].toUpperCase();
				res += array[counter++].toUpperCase();
			} else {
				res += ch;
			}
		}
		return res;
	}

	public static String sticker(String message, boolean found) {
		if (found) {
			if (message.contains("$")) {
				return "";
			}
			return message;
		}
		if (counter >= 4) {
			counter = 0;
		}
		String result = "";
		for (char ch : message.toCharArray()) {
			if (ch == '$') {
				result += array[counter].toUpperCase();
				counter++;
			} else {
				result += ch;
			}
		}
		return result;
	}
	//Run Program
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		//While loop == true 
		while (loop) {
			System.out.println("\nWhat type of data? ");
			String data = sc.next().toLowerCase();
			if (data.equals("exit")) {
				loop = false;
				continue;
			}
			sc.nextLine();
			System.out.println("\nWhat is the message? ");
			String message = sc.nextLine();
			String res = "";
			//Checking data type
			if (data.equals("date")) {
				res = sticker(message, true);
			} else if (data.equals("slogan")) {
				res = sticker(message, false);
			} else {
				res = sticker(message);
			}
			System.out.println(res);
		}
		sc.close();
	}

}

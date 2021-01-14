import java.util.Scanner;
import java.util.ArrayList;

public class AnagramChecker {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter first phrase> ");
		String input1 = scanner.nextLine();
		input1 = input1.replaceAll(" ", "");
		System.out.print("Enter second phrase> ");
		String input2 = scanner.nextLine();
		input2 = input2.replaceAll(" ", "");
		
		char[] array1 = input1.toCharArray();
		ArrayList<Character> chars1 = new ArrayList<Character>();
		for (int i = 0; i < array1.length; i++) {
			chars1.add(array1[i]);
		}
		
		char[] array2 = input2.toCharArray();
		ArrayList<Character> chars2 = new ArrayList<Character>();
		for (int i = 0; i < array2.length; i++) {
			chars2.add(array2[i]);
		}
		
		boolean anagram = true;
		if (chars1.size() != chars2.size()) {
			anagram = false;
			System.out.println("Is not an anagram.");
		} else {
			for (int i = 0; i < chars1.size(); i++) {
				if (chars2.remove(chars1.get(i)) == false) {
					anagram = false;
					System.out.println("Is not an anagram.");
					break;
				}
			}
		}
		
		if (anagram == true) {
			System.out.println("Is an anagram.");
		}
	}
}
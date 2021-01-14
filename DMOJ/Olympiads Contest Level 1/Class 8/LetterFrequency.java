import java.util.Scanner;
import java.util.ArrayList;

public class LetterFrequency {
	public static void main(String[] args) {
		
		//does not input from a file
		Scanner scanner = new Scanner(System.in);
		for (int a = 0; a < 5; a++) {
			String input = scanner.nextLine();
			
			String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
			int[] count = new int[26];
			for (int i = 0; i < 26; i++) {
				count[i] = 0;
			}
			
			for (int i = 0; i < input.length(); i++) {
				for (int j = 0; j < 26; j++) {		
					if (input.substring(i, i+1).equalsIgnoreCase(letters[j])) {
							count[j] = count[j] + 1;
					}
				}
			}
			
			int max = count[0];
			for (int i = 1; i < 26; i++) {
				if (count[i] > max) {
					max = count[i];
				}
			}
			
			ArrayList<String> mostLetters = new ArrayList<String>();
			while (indexOfArray(count, max) != -1) {
				mostLetters.add(letters[indexOfArray(count, max)]);
				count[indexOfArray(count, max)] = -1;
			}
			
			for (int i = 0; i < mostLetters.size(); i++) {
				System.out.print(mostLetters.get(i) + " ");
			}
			System.out.println("occur(s) " + max + " times.");
		}
		
	}
	public static int indexOfArray (int[] array, int num) {
		int index = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == num) {
				index = i;
				break;
			}
		}
		return index;
	}
}
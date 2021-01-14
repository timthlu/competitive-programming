import java.util.Scanner;

public class Rovarspraket {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		for (int i = 0; i < input.length(); i++) {
			String currentLetter = input.substring(i, i+1);
			System.out.print(currentLetter);
			
			if (!currentLetter.equals("a") && !currentLetter.equals("e") && !currentLetter.equals("i") && !currentLetter.equals("o") && !currentLetter.equals("u")) {
				int index = getIndex(alphabet, currentLetter);
				int closestVowelIndex = getClosestVowel(alphabet, index);
				System.out.print(alphabet[closestVowelIndex]);
				
				int nextConsonantIndex = getNextConsonant(alphabet, index);
				System.out.print(alphabet[nextConsonantIndex]);
			}
		}
	}
	public static int getIndex(String[] alphabet, String letter) {
		for (int i = 0; i < 26; i++) {
			if (letter.equals(alphabet[i])) {
				return i;
			}
		}
		
		return -1;
	}
	public static int getClosestVowel(String[] alphabet, int index) {
		for (int i = 0; i < 13; i++) {
			if (index-i >= 0) {
				String checkingLetter = alphabet[index-i];
				if (checkingLetter.equals("a") || checkingLetter.equals("e") || checkingLetter.equals("i") || checkingLetter.equals("o") || checkingLetter.equals("u")) {
					return index-i;
				}				
			}
			
			if (index+i <= 25) {
				String checkingLetter = alphabet[index+i];
				if (checkingLetter.equals("a") || checkingLetter.equals("e") || checkingLetter.equals("i") || checkingLetter.equals("o") || checkingLetter.equals("u")) {
					return index+i;
				}
			}
		}
		return -1;
	}
	public static int getNextConsonant(String[] alphabet, int index) {
		for (int i = 1; i < 25; i++) {
			if (index+i <= 25) {
				String checkingLetter = alphabet[index+i];
				if (!checkingLetter.equals("a") && !checkingLetter.equals("e") && !checkingLetter.equals("i") && !checkingLetter.equals("o") && !checkingLetter.equals("u")) {
					return index+i;
				}
			} else {
				return 25;
			}
		}
		
		return -1;
	}
}
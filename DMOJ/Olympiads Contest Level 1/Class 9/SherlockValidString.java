import java.util.Scanner;
import java.util.ArrayList;

public class SherlockValidString {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		ArrayList<Character> chars = new ArrayList<Character>();
		
		for (int i = 0; i < input.length(); i++) {
			boolean exists = false;
			for (int j = 0; j < chars.size(); j++) {
				if (input.charAt(i) == chars.get(j)) {
					exists = true;
				}
			}
			if (!exists) {
				chars.add(input.charAt(i));
			}
		}
		
		String shortened = "";
		for (int i = 0; i < chars.size(); i++) {
			shortened = shortened + chars.get(i);
		}
		char[] letters = shortened.toCharArray();
		int[] timesRepeated = new int[letters.length];
		
		for (int i = 0; i < timesRepeated.length; i++) {
			timesRepeated[i] = 0;
		}
		
		for (int i = 0; i < input.length(); i++) {
			timesRepeated[index(input.charAt(i), letters)] = timesRepeated[index(input.charAt(i), letters)] + 1;
		}
		
		boolean valid = true;
		boolean removed = false;
		boolean switched = false;
		int count = timesRepeated[0];
		for (int i = 0; i < timesRepeated.length; i++) {
			if (timesRepeated[i] == count) {
			} else if (timesRepeated[i] == 1 && count != 1) {
			} else if (timesRepeated[i] != count && timesRepeated[i] == count+1 && removed == false) {
				removed = true;
			} else if (timesRepeated[i] != count && timesRepeated[i] == count-1 && removed == false && switched == false) {
				count = timesRepeated[i];
				removed = true;
				switched = true;
			} else {
				valid = false;
			}
		}
		
		if (valid) System.out.println("YES");
		else System.out.println("NO");
	}
	public static int index(char letter, char[] array) {
		int index = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == letter) {
				index = i;
				break;
			}
		}
		return index;
	}
}
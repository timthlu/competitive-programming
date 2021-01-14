import java.util.Scanner;
import java.util.ArrayList;

public class Ragaman {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input1 = scanner.nextLine();
		String input2 = scanner.nextLine();
		
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		for (int i = 0; i < input1.length(); i++) {
			list1.add(input1.substring(i, i+1));
			list2.add(input2.substring(i, i+1));
		}
		
		boolean anagram = true;
		for (int i = 0; i < list1.size(); i++) {
			String currentChar = list1.get(i);
			if (list2.indexOf(currentChar) == -1) {
				if (list2.indexOf("*") == -1) {
					anagram = false;
				} else {
					list2.remove(list2.indexOf("*"));
				}
			} else {
				list2.remove(list2.indexOf(currentChar));
			}
		}
		
		if (anagram) {
			System.out.println("A");
		} else {
			System.out.println("N");
		}
	}
}
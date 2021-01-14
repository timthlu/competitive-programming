import java.util.Scanner;
import java.util.Stack;

public class Question1 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		Stack<Character> s = new Stack<Character>();
		for (int i = 0; i < input.length(); i++) {
			s.push(input.charAt(i));
		}
		
		while (!s.isEmpty()) {
			System.out.print(s.pop());
		}
	}
}
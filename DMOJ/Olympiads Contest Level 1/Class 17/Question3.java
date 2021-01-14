import java.util.Scanner;
import java.util.Stack;

public class Question3 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int integer = scanner.nextInt();
		Stack<Integer> s = new Stack<Integer>();
		while (integer > 0) {
			s.push(integer % 2);
			integer = integer/2;
		}
		
		while (!s.isEmpty()) {
			System.out.print(s.pop());
		}
	}
}
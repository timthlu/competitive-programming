import java.util.Scanner;
import java.util.Stack;

public class TwoStacks {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int numGames = scanner.nextInt();
		
		for (int i = 0; i < numGames; i++) {
			int size1 = scanner.nextInt();
			int size2 = scanner.nextInt();
			int max = scanner.nextInt();
			Stack<Integer> temp1 = new Stack<Integer>();
			Stack<Integer> temp2 = new Stack<Integer>();
			Stack<Integer> stack1 = new Stack<Integer>();
			Stack<Integer> stack2 = new Stack<Integer>();
			
			for (int j = 0; j < size1; j++) {
				temp1.push(scanner.nextInt());
			}
			for (int j = 0; j < size2; j++) {
				temp2.push(scanner.nextInt());
			}
			
			for (int j = 0; j < size1; j++) {
				stack1.push(temp1.pop());
			}
			for (int j = 0; j < size2; j++) {
				stack2.push(temp2.pop());
			}
			
			int sum = 0;
			int count = 0;
			while (sum < max) {
				if (stack1.peek() < stack2.peek()) {
					sum = sum + stack1.pop();
				} else {
					sum = sum + stack2.pop();
				}
				count++;
			}
			
			System.out.println(count-1);
		}
		
	}
}
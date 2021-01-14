import java.util.Scanner;
import java.util.Stack;

public class MaxEle {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		int n = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < n; i++) {
			String input = scanner.nextLine();
			if (input.charAt(0) == '1') {
				String num = input.substring(2);
				stack.push(Integer.parseInt(num));
			} else if (input.charAt(0) == '2') {
				int useless = stack.pop();
			} else {
				Stack<Integer> placeHolder = new Stack<Integer>();
				int max = 0;
				while (!stack.empty()) {
					int test = stack.pop();
					if (test > max) max = test;
					placeHolder.push(test);
				}
				
				System.out.println(max);
				stack = placeHolder;
			}
		}
	}
}
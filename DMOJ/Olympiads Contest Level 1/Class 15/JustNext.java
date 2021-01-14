import java.util.Scanner;

public class JustNext {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < n; i++) {
			int num = scanner.nextInt()
			scanner.nextLine();
			Stack<Integer> stack = new Stack<Integer>();
			for (int j = 0; j < num; j++) {
				stack.push(scanner.nextInt());
			}
			//reverse last two digits
			int temp1 = stack.pop();
			int temp2 = stack.pop();
		}
	}
}
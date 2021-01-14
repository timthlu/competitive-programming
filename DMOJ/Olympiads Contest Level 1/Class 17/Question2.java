import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Question2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		Queue<Character> q = new LinkedList<Character>();
		for (int i = 0; i < input.length(); i++) {
			q.add(input.charAt(i));
		}
		
		int openCurly = 0; //{
		int closedCurly = 0; //}
		int openBrack = 0; //[
		int closedBrack = 0; //]
		int openParen = 0; //(
		int closedParen = 0; //)
		
		while (!q.isEmpty()) {
			if (q.element() == '{') openCurly++;
			else if (q.element() == '}') closedCurly++;
			else if (q.element() == '[') openBrack++;
			else if (q.element() == ']') closedBrack++;
			else if (q.element() == '(') openParen++;
			else if (q.element() == ')') closedParen++;
			
			q.remove();
		}
		
		boolean balanced = true;
		if (openCurly != closedCurly || openBrack != closedBrack || openParen != closedParen) balanced = false;
		
		if (balanced) System.out.println("Balanced.");
		else System.out.println("Imbalanced.");
	}
}
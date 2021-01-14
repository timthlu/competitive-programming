import java.util.Scanner;
import java.util.Stack;

public class TheGenevaConfection {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int tests = scanner.nextInt();
		
		for (int i = 0; i < tests; i++) {
			int cars = scanner.nextInt();
			Stack<Integer> branch = new Stack();
			int[] mountain = new int[cars];
			
			for (int j = 0; j < cars; j++) {
				mountain[j] = scanner.nextInt();
			}
			
			int currentCarIndex = cars-1;
			int currentCarNum = 1;
			boolean moved = true;
			while (moved) {
				moved = false;
				if (!branch.empty() && branch.peek() == currentCarNum) {
					branch.pop();
					currentCarNum++;
					moved = true;
				}
				if (currentCarIndex != -1 && mountain[currentCarIndex] == currentCarNum) {
					currentCarIndex--;
					currentCarNum++;
					moved = true;
				}
				if (currentCarIndex != -1 && !moved) { 
					branch.push(mountain[currentCarIndex]);
					currentCarIndex--;
					moved = true;
				}
			}
			
			if (branch.empty() && currentCarIndex == -1) {
				System.out.println("Y");
			} else {
				System.out.println("N");
			}
		}
	}
}
import java.util.Scanner;

public class UpAndDown {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int d = scanner.nextInt();
		int steps = scanner.nextInt();
		
		int safeStepsN = steps/(a+b);
		int currentStepsN = (a-b)*safeStepsN;
		int moduloN = steps%(a+b);
		if (moduloN > a) {
			currentStepsN = currentStepsN + a - (b - (moduloN - a));
		} else {
			currentStepsN = currentStepsN + moduloN;
		}
		
		int safeStepsB = steps/(c+d);
		int currentStepsB = (c-d)*safeStepsB;
		int moduloB = steps%(c+d);
		if (moduloB > c) {
			currentStepsB = currentStepsB + c - (d - (moduloB - c));
		} else {
			currentStepsB = currentStepsB + moduloB;
		}
		
		if (currentStepsN > currentStepsB) {
			System.out.println("Nikky");
		} else if (currentStepsB > currentStepsN) {
			System.out.println("Byron");
		} else {
			System.out.println("Tied");
		}
		
	}
}
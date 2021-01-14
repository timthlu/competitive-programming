import java.util.Scanner;

public class ISBN {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		int num3 = scanner.nextInt();
		
		int sum = 91 + num1 + num2*3 + num3;
		System.out.println("The 1-3 sum is " + sum);
	}
}
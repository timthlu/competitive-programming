import java.util.Scanner;

public class GuessingGame {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int goal = scanner.nextInt();
		int min = scanner.nextInt();
		int max = scanner.nextInt();
		
		int num = (min+max)/2;
		int count = 1;
		
		while (num != goal) {
			if (goal > num) {
				min = num;
			} else if (goal < num) {
				max = num;
			}
			
			num = (max+min)/2;
			count++;
		}
		
		System.out.println(count);
	}
}
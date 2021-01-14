import java.util.Scanner;

public class NextPrime {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		if (input == 1) {
			System.out.println(2);
		} else {
			boolean stopLoop = false;
			while (!stopLoop) {
				stopLoop = checkIfPrime(input);
				input++;
			}
			
			input--;
			System.out.println(input);
		}
		
	}
	public static boolean checkIfPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num%i == 0) {
				return false;
			}
		}
		return true;
	}
}
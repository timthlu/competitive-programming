import java.util.Scanner;

public class BridgeTransport {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int w = scanner.nextInt();
		int cars = scanner.nextInt();
		
		int[] array = new int[cars];
		
		for (int i = 0; i < cars; i++) {
			array[i] = scanner.nextInt();
		}
		
		int countCars = 0;
		int currentSum = 0;
		int finalCount = 0;
		for (int i = 0; i < cars; i++) {
			if (countCars < 4) {
				currentSum += array[i];
				countCars++;
			} else  {
				currentSum -= array[i-4];
				currentSum += array[i];
			}
			
			if (currentSum > w) {
				System.out.println(finalCount);
				System.exit(0);
			} else {
				finalCount++;
			}
		}
		
		System.out.println(finalCount);
	}
}
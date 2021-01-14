import java.util.Scanner;

public class LeftThenRight {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] list = new int[size];
		for (int i = 0; i < size; i++) {
			list[i] = scanner.nextInt();
		}
		
		int[] finalList = new int[size];
		int countLeft = 0;
		int countRight = 0;
		for (int i = 0; i < size; i = i + 2) {
			finalList[i] = list[countLeft];
			if (size > i+1) {
				finalList[i+1] = list[size-countRight-1];
			}
			countLeft++;
			countRight++;
		}
		
		for (int i = 0; i < size; i++) {
			System.out.print(finalList[i] + " ");
		}
	}
}
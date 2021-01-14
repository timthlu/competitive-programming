import java.util.Scanner;
import java.util.Arrays;

public class WhoIsInTheMiddle {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int[] array = new int[3];
		for (int i = 0; i < 3; i++) {
			array[i] = scanner.nextInt();
		}
		
		Arrays.sort(array);
		System.out.println(array[1]);
	}
}
import java.util.Scanner;
import java.util.Arrays;

public class Cetiri {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int[] array = new int[3];
		for (int i = 0; i < 3; i++) {
			array[i] = scanner.nextInt();
		}
		
		Arrays.sort(array);
		int diff = array[1] - array[0];
		if (array[2] - array[1] == diff) {
			System.out.println(array[2] + diff);
		} else if (array[2] - array[1] == 2*diff) {
			System.out.println(array[1] + diff);
		} else {
			diff = array[2] - array[1];
			if (array[1] - array[0] == diff*2) {
				System.out.println(array[0] + diff);
			} else {
				System.out.println(array[0] - diff);
			}
		}
	}
}
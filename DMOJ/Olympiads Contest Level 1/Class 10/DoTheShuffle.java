import java.util.Scanner;

public class DoTheShuffle {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String[] array = {"A", "B", "C", "D", "E"};
		
		while (true) {
			int input = scanner.nextInt();
			int times = scanner.nextInt();
			
			if (input == 1) {
				for (int i = 0; i < times; i++) {
					String temp = array[0];
					array[0] = array[1];
					array[1] = array[2];
					array[2] = array[3];
					array[3] = array[4];
					array[4] = temp;
				}
			} else if (input == 2) {
				for (int i = 0; i < times; i++) {
					String temp = array[4];
					array[4] = array[3];
					array[3] = array[2];
					array[2] = array[1];
					array[1] = array[0];
					array[0] = temp;
				}
			} else if (input == 3) {
				for (int i = 0; i < times; i++) {
					String temp = array[0];
					array[0] = array[1];
					array[1] = temp;
				}
			} else if (input == 4) {
				for (int i = 0; i < 5; i++) {
					System.out.print(array[i] + " ");
				}
				System.out.println();
				break;
			}
		}
	}
}
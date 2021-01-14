import java.util.Scanner;

public class 8Queens {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int[] array = new int[8];
		for (int i = 0; i < 8; i++) {
			array[i] = scanner.nextInt();
		}
		boolean isSol = true;
		
		for (int i = 0; i < 8; i++) {
			for (int j = 7; j > i; j++) {
				if (array[i] == array[j]) {
					isSol = false;
				}
				
				if (Math.abs(i-j) == Math.abs(array[i]-array[j])) {
					isSol = false;
				}
			}
		}
		
		if (isSol) {
			System.out.println("A solution.");
		} else {
			System.out.println("Not a solution.");
		}
	}
}
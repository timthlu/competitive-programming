import java.util.Scanner;

public class EightQueens {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int[] array = new int[8];
		for (int i = 0; i < 8; i++) {
			array[i] = scanner.nextInt();
		}
		boolean isSol = true;
		
		for (int i = 0; i < 7; i++) {
			for (int j = i+1; j < 8; j++) {
				if (array[i] == array[j]) {
					isSol = false;
				}
				
				if (i-j == array[i]-array[j]) {
					isSol = false;
				} else if (j-i == array[i]-array[j]) {
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
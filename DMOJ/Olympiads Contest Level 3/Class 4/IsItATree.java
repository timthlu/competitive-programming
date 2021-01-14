import java.util.Scanner;

public class IsItATree {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int[][] array = new int[4][4];
		int count = 0;
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int num = scanner.nextInt();
				array[i][j] = num;
				if (num == 1) {
					count++;
				}
			}
		}
		
		if (count != 6) {
			System.out.println("No");
		} else {
			boolean notFound = true;
			
			for (int i = 0; i < 4; i++) {
				notFound = true;
				for (int j = 0; j < 4; j++) {
					if (array[i][j] == 1) {
						notFound = false;
						break;
					}
				}
				
				if (notFound) {
					break;
				}
			}
			
			if (notFound) {
				System.out.println("No");
			} else {
				System.out.println("Yes");
			}
		}
	}
}
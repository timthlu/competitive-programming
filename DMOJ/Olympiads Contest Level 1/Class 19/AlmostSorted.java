import java.util.Scanner;

public class AlmostSorted {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		for (int m = 0; m < 10; m++) {
			int n = scanner.nextInt();
			scanner.nextLine();
			String[] array = new String[n];
			for (int j = 0; j < n; j++) {
				array[j] = scanner.nextLine();
			}
			
			int minSteps = Integer.MIN_VALUE;
			int steps = 0;
			for (int i = 0; i < n; i++) {
				String[] list = new String[n-1];
				boolean foundI = false;
				for (int j = 0; j < n; j++) {
					if (j != i && !foundI) {
						list[j] = array[j];
					} else if (j == i) {
						foundI = true;
						j--;
					} else if (foundI && j != n-1) {
						list[j] = array[j+1];
					}
				}
				
				boolean sorted = false;
				while (!sorted) {
					sorted = true;
					for (int j = 1; j < n; j++) {
						if (list[j].compareTo(list[j-1]) > 0) {
							sorted = false;
							String temp = list[j];
							list[j] = list[j-1];
							list[j-1] = temp;
						}
					}
					steps++;
				}
				
				if (minSteps > steps) {
					minSteps = steps;
				}
			}
			
			System.out.println(minSteps);
		}
	}
}
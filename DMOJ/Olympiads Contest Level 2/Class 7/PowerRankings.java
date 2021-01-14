import java.util.Scanner;

public class PowerRankings {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int numStudents = scanner.nextInt();
		int numPresents = scanner.nextInt();
		scanner.nextLine();
		
		String[] studentNames = new String[numStudents];
		int[] studentTimes = new int[numStudents];
		
		for (int i = 0; i < numStudents; i++) {
			studentNames[i] = scanner.nextLine();
		}
		
		for (int i = 0; i < numPresents; i++) {
			for (int j = 0; j < numStudents; j++) {
				studentTimes[j] = studentTimes[j] + scanner.nextInt();
			}
		}
		
		for (int i = 0; i < numStudents; i++) {
			int maxIndex = findMaxIndex(studentTimes);
			int pr = 3 + i;
			System.out.println(pr + ". " + studentNames[maxIndex]);
			
			studentTimes[maxIndex] = -1;
		}
	}
	public static int findMaxIndex(int[] array) {
		int max = 0;
		
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[max]) {
				max = i;
			}
		}
		
		return max;
	}
}
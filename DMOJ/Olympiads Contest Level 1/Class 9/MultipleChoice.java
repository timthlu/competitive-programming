import java.util.Scanner;

public class MultipleChoice {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		scanner.nextLine();
		
		String[] student = new String[num];
		
		for (int i = 0; i < num; i++) {
			student[i] = scanner.nextLine();
		}
		
		String response;
		int count = 0;
		for (int i = 0; i < num; i++) {
			response = scanner.nextLine();
			if (response.equals(student[i])) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}
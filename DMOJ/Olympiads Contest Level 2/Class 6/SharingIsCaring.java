import java.util.Scanner;

public class SharingIsCaring {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int people = scanner.nextInt();
		int docs = scanner.nextInt();
		 
		int[] authors = new int[docs];
		int[] recipients = new int[docs];
		String[] docNames = new String[docs];
		
		for (int i = 0; i < docs; i++) {
			authors[i] = scanner.nextInt();
			recipients[i] = scanner.nextInt();
			scanner.nextLine();
			
			docNames[i] = scanner.nextLine();
		}
		
		int you = scanner.nextInt();
		
		for (int i = 0; i < docs; i++) {
			if (you == recipients[i]) {
				System.out.println(docNames[i]);
			}
		}
	}
}
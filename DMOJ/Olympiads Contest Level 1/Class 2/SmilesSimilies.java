import java.util.Scanner;

public class SmilesSimilies {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numAdj = scanner.nextInt();
		int numNns = scanner.nextInt();
		
		for (int i = 0; i < numAdj; i++) {
			String adj = scanner.nextLine();
			for (int j = 0; j < numNns; i++) { 
				String noun = scanner.nextLine();
				System.out.print(adj + " as " + noun);
			}
		}
	
	}
}
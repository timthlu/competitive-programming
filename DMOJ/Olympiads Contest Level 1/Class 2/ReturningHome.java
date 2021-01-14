import java.util.Scanner;
import java.util.ArrayList; 

public class ReturningHome {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList list = new ArrayList();
		
		while (true) {
			String input = scanner.nextLine();
			list.add(input);
			
			if (input.equals("SCHOOL")) {
				break;
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			int pos = i + 1; 
			if (list.get(list.size() - pos).equals("R")) {
				System.out.print("Turn LEFT ");
			} else if (list.get(list.size() - pos).equals("L")) {
				System.out.print("Turn RIGHT ");
			} else {
				System.out.println("onto " + list.get(list.size()- pos) + " street.");
			}
			
		}
		
		System.out.println("into your HOME.");
	}
}
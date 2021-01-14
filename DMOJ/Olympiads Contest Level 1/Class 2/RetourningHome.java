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
		
		length = list.size();
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(list.size() - i).equals("R")) {
				System.out.print("Turn LEFT ");
			} else if (list.get(list.size() - i).equals("L")) {
				System.out.print("Turn RIGHT ");
			} else {
				System.out.println("onto " + input + " street.");
			}
			
		}
		
		System.out.println("into your HOME.");
	}
}
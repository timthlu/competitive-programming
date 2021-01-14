import java.util.Scanner;
import java.util.ArrayList;

public class ReturningHome {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> turns = new ArrayList<String>();
		ArrayList<String> streets = new ArrayList<String>();
		
		while (true) {
			String dir = scanner.nextLine();
			String str = scanner.nextLine();
			
			turns.add(dir);
			streets.add(str);
			
			if (str.equals("SCHOOL")) {
				break;
			}
		}
		
		for (int i = turns.size()-1; i >= 0; i--) {
			System.out.print("Turn ");
			
			if (turns.get(i).equals("R")) {
				System.out.print("LEFT");
			} else {
				System.out.print("RIGHT");
			}
			
			if (i >= 1) {
				System.out.println(" onto " + streets.get(i-1) + " street.");
			} else {
				System.out.println(" into your HOME.");
			}
		}
	}
}
import java.util.Scanner;
import java.util.ArrayList;

public class CrayolaLightsaber {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> sword = new ArrayList<String>();
		ArrayList<String> notFound = new ArrayList<String>();
		int num = scanner.nextInt();
		scanner.nextLine();
		
		for (int i = 0; i < num; i++) {
			String colour = scanner.next();
			
			if (colour.equals("red") || colour.equals("orange") || colour.equals("yellow") || colour.equals("green") || colour.equals("blue") || colour.equals("black")) {
				boolean found = findPlace(colour, sword);
				if (!found) {
					notFound.add(colour);
				}
			}
		}
		
		boolean removed = true;
		
		while (removed) {
			removed = false;
			
			for (int i = 0; i < notFound.size(); i++) {
				boolean found = findPlace(notFound.get(i), sword);
				
				if (found) {
					notFound.remove(i);
					i--;
					removed = true;
				}
			}
		}
		
		System.out.println(sword.size());
	}
	public static boolean findPlace(String colour, ArrayList<String> sword) {
		if (sword.size() == 0) {
			sword.add(colour);
			return true;
		} else {
			if (!sword.get(sword.size()-1).equals(colour)) {
				sword.add(colour);
				return true;
			} else {
				for (int j = 0; j < sword.size()-1; j++) {
					if (j == 0 && !sword.get(j).equals(colour)) {
						sword.add(0, colour);
						return true;
					} else if (!sword.get(j).equals(colour) && !sword.get(j+1).equals(colour)) {
						sword.add(j+1, colour);
						return true;
					}
				}
			}
		}
		
		return false;
	}
}
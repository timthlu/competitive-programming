import java.util.Scanner;
import java.util.ArrayList;

public class UniqueElements {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		ArrayList<Integer> elements = new ArrayList<Integer>();
		
		for (int i = 0; i < num; i++) {
			int input = scanner.nextInt();
			
			boolean alreadyExists = false;
			for (int j = 0; j < elements.size(); j++) {
				if (elements.get(j) == input) {
					alreadyExists = true;
					break;
				}
			}
			
			if (!alreadyExists) {
				elements.add(input);
			}
		}
		
		System.out.println(elements.size());
	}
}
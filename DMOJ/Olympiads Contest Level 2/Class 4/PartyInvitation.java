import java.util.Scanner;
import java.util.ArrayList;

public class PartyInvitation {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int listSize = scanner.nextInt();
		
		int counter = 1;
		for (int i = 0; i < listSize; i++) {
			list.add(counter);
			counter++;
		}
		
		int numInputs = scanner.nextInt();
		
		for (int i = 0; i < numInputs; i++) {
			int remove = scanner.nextInt();
			int count = 1;
			
			for (int j = 0; j < list.size(); j++) {
				if (count == remove) {
					list.remove(j);
					count = 1;
				}
				
				count++;
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
}
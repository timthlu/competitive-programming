import java.util.Scanner;
import java.util.ArrayList;

public class WaitTime {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		ArrayList<Integer> friends = new ArrayList<Integer>();
		ArrayList<Integer> startTimes = new ArrayList<Integer>();
		int[] endTimes = new int[num];
		
		int currentTime = 0;
		for (int i = 0; i < num; i++) {
			String action = scanner.next();
			int integer = scanner.nextInt();
			scanner.nextLine();
			
			if (action.equals("R")) {
				boolean exists = false;
				int existingIndex = -1;
				
				for (int j = 0; j < friends.size(); j++) {
					if (friends.get(j).equals(integer)) {
						exists = true;
						existingIndex = j;
						break;
					}
				}
				
				if (!exists) {
					friends.add(integer);
					startTimes.add(currentTime);
				} else {
					startTimes.remove(existingIndex);
					startTimes.add(existingIndex, currentTime);
					
				}
				
				currentTime++;
			} else if (action.equals("S")) {
				boolean exists = false;
				int existingIndex = -1;
				
				for (int j = 0; j < friends.size(); j++) {
					if (friends.get(j).equals(integer)) {
						exists = true;
						existingIndex = j;
						break;
					}
				}
				
				if (exists) {
					endTimes[existingIndex] = currentTime;
				}
				
				currentTime++;
			} else {
				currentTime = currentTime + integer - 1;
			}
		}
		
		for (int i = 0; i < friends.size(); i++) {
			int time = endTimes[i] - startTimes.get(i);
			System.out.println(friends.get(i) + " " + time);
		}
	}
}
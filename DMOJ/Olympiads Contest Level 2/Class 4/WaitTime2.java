import java.util.Scanner;
import java.util.ArrayList;

public class WaitTime2 {
	public static void main(String[] args) {
			
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		scanner.nextLine();
		
		ArrayList<Integer> friends = new ArrayList<Integer>();
		ArrayList<Integer> times = new ArrayList<Integer>();
		ArrayList<Boolean> waiting = new ArrayList<Boolean>();
		
		for (int i = 0; i < num; i++) {
			String action = scanner.next();
			int integer = scanner.nextInt();
			scanner.nextLine();
			
			if (!action.equals("W")) {
				int index = -1;
					
				for (int j = 0; j < friends.size(); j++) {
					if (integer == friends.get(j)) {
						index = j;
						break;
					}
				}
				
				if (action.equals("R")) {
					if (index == -1) {
						boolean added = false;
						
						for (int j = 0; j < friends.size(); j++) {
							if (friends.get(j) > integer) {
								friends.add(j, integer);
								added = true;
								index = j;
								break;
							}
						}
						
						if (!added) {
							friends.add(integer);
							index = friends.size()-1;
						}
						
						waiting.add(index, true);
						times.add(index, 0);
					} else {
						if (waiting.get(index)) {
							times.set(index, -1);
						} else {
							waiting.set(index, true);
						}
					}
				} else if (action.equals("S")) {
					waiting.set(index, false);
				}
				
				addTime(1, times, waiting);
			} else {
				addTime(integer-1, times, waiting);
			}
		}
		
		for (int i = 0; i < friends.size(); i++) {
			if (waiting.get(i)) {
				times.set(i, -1);
			}
		}
		
		for (int i = 0; i < friends.size(); i++) {
			System.out.println(friends.get(i) + " " + times.get(i));
		}
	}
	
	public static void addTime(int timeAdded, ArrayList<Integer> t, ArrayList<Boolean> w) {
		for (int i = 0; i < w.size(); i++) {
			if (w.get(i) && t.get(i) != -1) {
				t.set(i, t.get(i) + timeAdded);
			}
		}
	}
}
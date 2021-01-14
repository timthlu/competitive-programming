import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class LeftoverEggnog {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int volA = scanner.nextInt();
		int volB = scanner.nextInt();
		int goal = scanner.nextInt();
		
		Queue<int[]> q = new LinkedList<>();
		int[] start1 = {volA, 0};
		int[] start2 = {0, volB};
		q.add(start1);
		q.add(start2);
		
		ArrayList<ArrayList<int[]>> paths = new ArrayList<>();
		
		while (!q.isEmpty()) {
			int[] vols = q.remove();
			
			if (vols[0] == goal || vols[1] == goal) {
				System.out.println("found");
				break;
			} else {
				int[] one = {volA, vols[1]}; //fill cup A
				int[] two = {vols[0], volB}; //fill cup B
				
				int three1, three2;
				if (vols[0] < volB - vols[1]) {
					three1 = 0;
					three2 = vols[0] + vols[1];
				} else {
					three1 = vols[0] - (volB - vols[1]);
					three2 = volB;
				}
				
				int[] three = {three1, three2}; //pour A into B
				
				int four1, four2;
				if (vols[1] < volA - vols[0]) {
					four1 = vols[0] + vols[1];
					four2 = 0;
				} else {
					four1 = volA;
					four2 = vols[1] - (volA - vols[0]);
				}
				
				int[] four = {four1, four2}; //pour B into A
				int[] five = {0, vols[1]}; //chug A
				int[] six = {vols[0], 0}; //chug B
				
				q.add(one);
				q.add(two); 
				q.add(three);
				q.add(four);
				q.add(five);
				q.add(six);
			}
		}
	}
}
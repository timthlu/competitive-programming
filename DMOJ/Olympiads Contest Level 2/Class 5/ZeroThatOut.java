import java.util.Scanner;
import java.util.ArrayList;

public class ZeroThatOut {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int num = scanner.nextInt();
		
		for (int i = 0; i < num; i++) {
			int input = scanner.nextInt();
			if (input == 0) {
				list.remove(list.size()-1);
			} else {
				list.add(input);
			}
		}
		
		if (list.size() == 0) {
			System.out.println(0);
		} else {
			int sum = 0;
			for (int i = 0; i < list.size(); i++) {
				sum = sum + list.get(i);
			}
			
			System.out.println(sum);
		}
	}
}
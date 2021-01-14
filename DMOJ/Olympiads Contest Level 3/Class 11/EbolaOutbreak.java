import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class EbolaOutbreak {
	static int[] dis;
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int people = scanner.nextInt();
		int classes = scanner.nextInt();
		
		dis = new int[people+1];
		
		for (int i = 0; i < people; i++) {
			dis[i+1] = i+1;
		}
		
		for (int i = 0; i < classes; i++) {
			int num = scanner.nextInt();
			
			int first = scanner.nextInt();
			for (int j = 1; j < num; j++) {
				dis[find(scanner.nextInt())] = find(first);
			}
		}
		
		int in = find(1);
		ArrayList<Integer> p = new ArrayList<Integer>();
		for (int i = 1; i < dis.length; i++) {
			if (find(1) == find(i)) {
				p.add(i);
			}
		}
		
		int[] array = new int[p.size()];
		for (int i = 0; i < p.size(); i++) {
			array[i] = p.get(i);
		}
		
		Arrays.sort(array);
		System.out.println(p.size());
		for (int i = 0; i < p.size(); i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
	}
	public static int find(int x) {
		if (dis[x] != x) {
			dis[x] = find(dis[x]);
		}
		return dis[x];
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class PortalsCheck {
	static int[] dis;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			int queries = Integer.parseInt(br.readLine());
			
			dis = new int[queries*2];
			HashMap<String, Integer> hm = new HashMap<String, Integer>();
			int nextIndex = 0;
			
			for (int j = 0; j < queries*2; j++) {
				dis[j] = j;
			}
			
			for (int j = 0; j < queries; j++) {
				String[] input = br.readLine().split(" ");
				String command = input[0];
				String city1 = input[1];
				String city2 = input[2];
				
				if (!hm.containsKey(city1)) {
					hm.put(city1, new Integer(nextIndex));
					nextIndex++;
				}
				if (!hm.containsKey(city2)) {
					hm.put(city2, new Integer(nextIndex));
					nextIndex++;
				}
				
				int index1 = hm.get(city1);
				int index2 = hm.get(city2);
				
				if (command.equals("p")) {
					dis[find(index1)] = find(index2);
				} else {
					if (find(index1) == find(index2)) {
						System.out.println("connected");
					} else {
						System.out.println("not connected");
					}
				}
				
			}
		}
	}
	public static int find(int x) {
		if (dis[x] != x) {
			dis[x] = find(dis[x]);
		}
		return dis[x];
	}
}
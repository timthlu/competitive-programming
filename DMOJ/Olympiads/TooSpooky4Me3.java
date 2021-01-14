import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class TooSpooky4Me3 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int L = Integer.parseInt(input[1]);
		int S = Integer.parseInt(input[2]);
		
		ArrayList<Node> array = new ArrayList<Node>();
		
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int s = Integer.parseInt(input[2]);
			
			boolean foundA = false;
			boolean foundB = false;
			for (int j = 0; j < array.size(); j++) {
				if (array.get(j).index == a) {
					array.get(j).value += s;
					foundA = true;
				}
				
				if (array.get(j).index == b+1) {
					array.get(j).value -= s;
					foundB = true;
				}
				
				if (foundA && foundB) {
					break;
				}
			}
			
			if (!foundA) {
				array.add(new Node(a, s));
			}
			
			if (!foundB) {
				array.add(new Node(b+1, -s));
			}
		}
		
		Collections.sort(array);
		
		int curSum = 0;
		int ans = array.get(0).index - 1;
		
		for (int i = 0; i < array.size()-1; i++) {
			curSum += array.get(i).value;
			
			if (curSum < S) {
				ans += array.get(i+1).index - array.get(i).index;
			}
		}
		
		curSum += array.get(array.size()-1).value;
		if (curSum < S) {
			ans += L - array.get(array.size()-1).index + 1;
		}
		
		System.out.println(ans);
	}
	static class Node implements Comparable<Node> {
		int index;
		int value;
		
		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
		
		public int compareTo(Node n) {
			return index - n.index;
		}
	}
}
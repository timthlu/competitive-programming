import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class TooSpooky4Me2 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int L = Integer.parseInt(input[1]);
		int S = Integer.parseInt(input[2]);
		
		Node[] array = new Node[(int)2e4];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = new Node(0, 0);
		}
		
		int highestActiveIndex = 0;
		
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int s = Integer.parseInt(input[2]);
			
			boolean foundA = false;
			boolean foundB = false;
			for (int j = 0; j < highestActiveIndex; j++) {
				if (array[j].index == a) {
					array[j].value += s;
					foundA = true;
				}
				
				if (array[j].index == b+1) {
					array[j].value -= s;
					foundB = true;
				}
				
				if (foundA && foundB) {
					break;
				}
			}
			
			if (!foundA) {
				array[highestActiveIndex].index = a;
				array[highestActiveIndex].value = s;
				highestActiveIndex++;
			}
			
			if (!foundB) {
				array[highestActiveIndex].index = b+1;
				array[highestActiveIndex].value = -s;
				highestActiveIndex++;
			}
		}
		
		Arrays.sort(array);
		
		int curSum = array[0].value;
		int ans = array[0].index-1;
		
		for (int i = 1; i < array.length-1; i++) {
			curSum += array[i].value;
			
			if (curSum < S) {
				ans += array[i+1].index - array[i].index;
			}
		}
		
		curSum += array[array.length-1].value;
		if (curSum < S) {
			ans += L - array[array.length-1].index+1;
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
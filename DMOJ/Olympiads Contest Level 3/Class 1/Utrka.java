import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Utrka {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int num = Integer.parseInt(input);
		String[] listOne = new String[num];
		String[] listTwo = new String[num-1];
		
		for (int i = 0; i < num; i++) {
			listOne[i] = br.readLine();
		}
		
		for (int i = 0; i < num-1; i++) {
			listTwo[i] = br.readLine();
		}
		
		Arrays.sort(listOne);
		Arrays.sort(listTwo);
		
		for (int i = 0; i < num-1; i++) {
			if (!listOne[i].equals(listTwo[i])) {
				System.out.println(listOne[i]);
				break;
			} else if (i == num-2) {
				System.out.println(listOne[num-1]);
			}
		}
	}
}
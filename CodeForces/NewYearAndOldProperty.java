import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class NewYearAndOldProperty {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		long a = Long.parseLong(input[0]);
		long b = Long.parseLong(input[1]);
		
		long power = (long) Math.floor(Math.log(a)/Math.log(2));
		
		if ((long) Math.pow(2, power)-1 < a) {
			power++;
		}
		
		ArrayList<Long> list = new ArrayList<Long>();
		
		while (Math.pow(2, power)-1 <= b) {
			list.add(power);
			power++;
		}
		
		list.add(power);
		
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			
			long curNum = (long)Math.pow(2, list.get(i)) - 1;
			
			for (int j = 0; j < list.get(i)-1; j++) {
				long test = curNum - (long)Math.pow(2, j);
				
				if (test >= a && test <= b) {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
}
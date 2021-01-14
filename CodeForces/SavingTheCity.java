import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SavingTheCity {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			int costActivation = Integer.parseInt(input[0]);
			int costPlace = Integer.parseInt(input[1]);
			
			int inARow = costActivation/costPlace;
			
			String map = br.readLine();
			
			boolean inZeros = false;
			boolean firstOneFound = false;
			int count = 0;
			int sum = 0;
			for (int j = 0; j < map.length(); j++) {
				if (map.charAt(j) == '0') {
					if (inZeros) {
						count++;
					} else {
						if (j != 0) {
							sum += costActivation;
						}
						
						inZeros = true;
						count = 1;
					}
				} else {
					if (!firstOneFound) {
						firstOneFound = true;
						inZeros = false;
						count = 0;
					} else {
						if (inZeros && count <= inARow) {
							for (int k = j-1; k >= j-count; k--) {
								if (map.charAt(k) == '0') {
									sum += costPlace;
								}
							}
							
							sum -= costActivation;
						}
						
						inZeros = false;
						count = 0;
					}
				}
			}
			
			if (map.charAt(map.length()-1) == '1') {
				sum += costActivation;
			}
			
			System.out.println(sum);
		}
	}
}
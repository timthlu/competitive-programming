import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WhereToBuildMyHouse {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		int animals = Integer.parseInt(br.readLine());
		
		String spacesTaken = "";
		for (int i = 0; i < length; i++) {
			spacesTaken = spacesTaken + i;
		}
		
		for (int i = 0; i < animals; i++) {
			String input = br.readLine();
			String[] expanded = input.split(" ");
			int startPos = Integer.parseInt(expanded[0]);
			int endPos = Integer.parseInt(expanded[1]);
			
			String newString = "";
			for (int j = 0; j < length; j++) {
				if (j >= startPos && j < endPos) {
					newString = newString + " ";
				} else {
					newString = newString + spacesTaken.substring(j, j+1);
				}
			}
			
			spacesTaken = newString;
		}
		
		int currentSeg = 0;
		int longestSeg = 0;
		for (int i = 0; i < length; i++) {
			if (spacesTaken.charAt(i) != ' ') {
				currentSeg++;
			} else {
				if (longestSeg < currentSeg) {
					longestSeg = currentSeg;
				}
				currentSeg = 0;
			}
		}
		
		if (currentSeg > longestSeg) {
			longestSeg = currentSeg;
		}
		
		System.out.println(longestSeg);
	}
}
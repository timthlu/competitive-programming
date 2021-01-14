import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BaseConversion {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String baseTwo = br.readLine();
		String baseThree = br.readLine();
		
		for (int i = 0; i < baseTwo.length(); i++) { //baseTwo at index i is wrong
			for (int j = 0; j < baseThree.length(); j++) { //baseThree at index j is wrong
				int twoNum = 0;
				for (int a = 0; a < baseTwo.length(); a++) {
					if (a == i && baseTwo.charAt(a) == '0') {
						twoNum = twoNum + (int)Math.pow(2, baseTwo.length() - a - 1);
					} else if (a != i && baseTwo.charAt(a) == '1') {
						twoNum = twoNum + (int)Math.pow(2, baseTwo.length() - a - 1);
					}
				}
				
				int threeNum = 0;
				
				for (int a = 0; a < baseThree.length(); a++) {
					if (a == j) {
						continue;
					} else if (baseThree.charAt(a) == '1') {
						threeNum = threeNum + (int)Math.pow(3, baseThree.length() - a - 1);
					} else if (baseThree.charAt(a) == '2') {
						threeNum = threeNum + 2*(int)Math.pow(3, baseThree.length() - a - 1);
					}
				}
				
				if (threeNum == twoNum) {
					System.out.println(threeNum);
					System.exit(0);
				}
				int added = (int)Math.pow(3, baseThree.length() - j - 1);
				threeNum += added;
				if (threeNum == twoNum) {
					System.out.println(threeNum);
					System.exit(0);
				}
				threeNum -= added;
				added = 2*(int)Math.pow(3, baseThree.length() - j - 1);
				threeNum += added;
				if (threeNum == twoNum) {
					System.out.println(threeNum);
					System.exit(0);
				}
				threeNum -= added;
			}
		}
	}
}
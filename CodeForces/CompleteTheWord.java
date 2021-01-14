import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CompleteTheWord {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		if (s.length() < 26) {
			System.out.println(-1);
		} else {
			boolean possible = true;
			int left = 0;
			int right = 25;
			
			int[] count = new int[26];
			
			int counter = 0;
			
			for (int i = 0; i <= 25; i++) { //A = 65
				if (s.charAt(i) != '?') {
					if (count[((int) s.charAt(i)) - 65] == 0) {
						counter++;
					}
					
					count[((int) s.charAt(i)) - 65]++;
				} else {
					counter++;
				}
			}
			
			for (int i = 0; i < 26; i++) {
				if (count[i] >= 2) {
					possible = false;
					break;
				}
			}
			
			if (possible) {
				System.out.println(getAnswer(left, right, count, s));
				System.exit(0);
			} else {
				for (int i = 0; i < s.length()-26; i++) {
					if (s.charAt(left) != '?') {
						count[((int) s.charAt(left)) - 65]--;
						
						if (count[((int) s.charAt(left)) - 65] == 0) {
							counter--;
						}
					} else {
						counter--;
					}
					
					if (s.charAt(right+1) != '?') {
						count[((int) s.charAt(right+1)) - 65]++;
						
						if (count[((int) s.charAt(right+1)) - 65] == 1) {
							counter++;
						}
					} else {
						counter++;
					}
					
					left++;
					right++;
					
					if (counter == 26) {
						System.out.println(getAnswer(left, right, count, s));
						System.exit(0);
					}
				}
				
				System.out.println(-1);
			}
		}
	}
	public static String getAnswer(int left, int right, int[] count, String s) {
		String ret = "";
		for (int i = 0; i < left; i++) {
			if (s.charAt(i) != '?') {
				ret += s.substring(i, i+1);
			} else {
				ret += "A";
			}
		}
		
		for (int i = left; i <= right; i++) {
			if (s.charAt(i) != '?') {
				ret += s.substring(i, i+1);
			} else {
				for (int j = 0; j < 26; j++) {
					if (count[j] == 0) {
						char letter = (char) (j+65);
						String sletter = Character.toString(letter);
						ret += sletter;
						count[j]++;
						break;
					}
				}
			}
		}
		
		for (int i = right+1; i < s.length(); i++) {
			if (s.charAt(i) != '?') {
				ret += s.substring(i, i+1);
			} else {
				ret += "A";
			}
		}
		
		return ret;
	}
}
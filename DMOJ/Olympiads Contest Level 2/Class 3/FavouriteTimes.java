import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FavouriteTimes {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int minutesAfter12 = Integer.parseInt(input);
		
		int hour = 12;
		int tensMinute = 0;
		int onesMinute = 0;
		int countTimes = 0;
		for (int i = 0; i <= minutesAfter12; i++) {
			if (checkIfArithmeticSequence(hour, tensMinute, onesMinute)) {
				countTimes++;
			}
			
			onesMinute++;
			if (onesMinute == 10) {
				onesMinute = 0;
				tensMinute++;
			}
			if (tensMinute == 6) {
				tensMinute = 0;
				hour++;
			}
			if (hour == 13) {
				hour = 1;
			}
		}
		
		System.out.println(countTimes);
	}
	public static boolean checkIfArithmeticSequence(int hour, int tensMinute, int onesMinute) {
		if (hour/10 > 0) {
			int diff = hour/10 - hour%10;
			if (hour%10 - tensMinute == diff && tensMinute - onesMinute == diff) {
				return true;
			}
		} else {
			int diff = hour - tensMinute;
			if (tensMinute - onesMinute == diff) {
				return true;
			}
		}
		return false;
	}
}
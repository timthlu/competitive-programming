import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FavouriteTimes2 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int minutesAfter12 = Integer.parseInt(input);
		
		int hour = 12;
		int tensMinute = 0;
		int onesMinute = 0;
		ArrayList<Integer> favTimes = new ArrayList<Integer>();
		for (int i = 0; i <= 720; i++) {
			if (checkIfArithmeticSequence(hour, tensMinute, onesMinute)) {
				if (hour == 12) {
					favTimes.add(tensMinute*10 + onesMinute);
				} else {
					favTimes.add(hour*60 + tensMinute*10 + onesMinute);
				}
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
		
		int finalTimes = (minutesAfter12/720)*favTimes.size() + countTimes(favTimes, minutesAfter12%720) + 1;
		System.out.println(finalTimes);
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
	public static int countTimes(ArrayList<Integer> list, int minutes) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == minutes) {
				return i;
			} else if (list.get(i) > minutes) {
				return i-1;
			}
		}
		return 0;
	}
}
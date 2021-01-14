import java.util.Scanner;
//COMPLETED AND FUNCTIONAL
public class DaysBetDays { 
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String year = scanner.nextLine();
		int yearNum;
		if (year.equals("S")) {
			yearNum = 0;
		} else if (year.equals("M")) {
			yearNum = 1;
		} else if (year.equals("T")) {
			yearNum = 2;
		} else if (year.equals("W")) {
			yearNum = 3;
		} else if (year.equals("U") || year.equals("R")) {
			yearNum = 4;
		} else if (year.equals("F")) {
			yearNum = 5;
		} else {
			yearNum = 6;
		}
		
		String first = scanner.nextLine();
		int month1 = Integer.parseInt(first.substring(0, 1));
		String day1 = first.substring(3, 4);
		int ordi1 = Integer.parseInt(first.substring(4, 5));
		
		
		String second = scanner.nextLine();
		int month2 = Integer.parseInt(second.substring(0, 1));
		String day2 = second.substring(3, 4);
		int ordi2 = Integer.parseInt(second.substring(4, 5));
		
		int days = 0;
		if (month1 == month2) {
			if (day1.equals(day2)) {
				days = 7*(ordi2 - ordi1) - 1;
			} else {
				days = 7*(ordi2 - ordi1);
				int one;
				int two;
				if (day1.equals("S")) {
					one = 0;
				} else if (day1.equals("M")) {
					one = 1;
				} else if (day1.equals("T")) {
					one = 2;
				} else if (day1.equals("W")) {
					one = 3;
				} else if (day1.equals("U") || day1.equals("R")) {
					one = 4;
				} else if (day1.equals("F")) {
					one = 5;
				} else {
					one = 6;
				}
				
				if (day2.equals("S")) {
					two = 0;
				} else if (day2.equals("M")) {
					two = 1;
				} else if (day2.equals("T")) {
					two = 2;
				} else if (day2.equals("W")) {
					two = 3;
				} else if (day2.equals("U") || day2.equals("R")) {
					two = 4;
				} else if (day2.equals("F")) {
					two = 5;
				} else {
					two = 6;
				}

				days = days + two - one;
			}
		} else {
			int[] daysInMonth = {30, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			int oneM = 0;
			int day1M = yearNum;
			int day2M = yearNum;
			for (int i = 0; i < month1-1; i++) {
				oneM = oneM + daysInMonth[i];
				day1M = (day1M + daysInMonth[i])%7;
			}
			int twoM = 0;
			for (int i = 0; i < month2-1; i++) {
				twoM = twoM + daysInMonth[i];
				day2M = (day2M + daysInMonth[i])%7;
			}
			int oneD;
			int twoD;
			if (day1.equals("S")) {
				oneD = 0;
			} else if (day1.equals("M")) {
				oneD = 1;
			} else if (day1.equals("T")) {
				oneD = 2;
			} else if (day1.equals("W")) {
				oneD = 3;
			} else if (day1.equals("U") || day1.equals("R")) {
				oneD = 4;
			} else if (day1.equals("F")) {
				oneD = 5;
			} else {
				oneD = 6;
			}
			
			int totalDays1 = oneM + 7*ordi1 + oneD - day1M;
			
			if (day2.equals("S")) {
				twoD = 0;
			} else if (day2.equals("M")) {
				twoD = 1;
			} else if (day2.equals("T")) {
				twoD = 2;
			} else if (day2.equals("W")) {
				twoD = 3;
			} else if (day2.equals("U") || day2.equals("R")) {
				twoD = 4;
			} else if (day2.equals("F")) {
				twoD = 5;
			} else {
				twoD = 6;
			}
			
			int totalDays2 = twoM + 7*ordi2 + twoD - day2M + 1;
			days = totalDays2 - totalDays1;
		}
		
		System.out.println(days + " days");
	}
}
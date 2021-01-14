import java.util.Scanner;

public class LappedOnTheTrack {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Length of track (miles): ");
		double length = scanner.nextDouble();
		System.out.print("Time you took to complete the lap (hours): ");
		double time = scanner.nextDouble();
		System.out.print("Number of times your friend lapped you/are next to you when you were running one lap: ");
		int X = scanner.nextInt();
		
		double yourSpeed = length/time;
		double friendsSpeed = yourSpeed*(X+1);
		
		double answer = Math.round((friendsSpeed - yourSpeed)*10)/10.0;
		
		System.out.println(answer + " miles/hour faster");
	}
}
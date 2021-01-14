import java.util.Scanner;
//PARTIALLY WORKS, WORKS FOR FIRST TEST CASE
public class Tiling {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int length1 = scanner.nextInt();
		int cost1 = scanner.nextInt();
		double ratio1 = cost1*1.0/length1;
		
		int length2 = scanner.nextInt();
		int cost2 = scanner.nextInt();
		double ratio2 = cost2*1.0/length2;
		int length = scanner.nextInt();
		int width = scanner.nextInt();
		
		boolean tile1 = false;
		if (ratio1 > ratio2) {
			System.out.println("Tile 2");
		} else {
			System.out.println("Tile 1");
			tile1 = true;
		}
		
		int totalArea = width*length;
		int areaTile;
		int whole;
		int part;
		double cost;
		if (tile1) {
			areaTile = length1*length1;
			whole = totalArea/areaTile;
			int remArea = totalArea - whole*areaTile;
			part = remArea/areaTile;
			
			cost = (whole + part)*cost1/100;
		} else {
			areaTile = length2*length2;
			whole = totalArea/areaTile;
			int remArea = totalArea - whole*areaTile;
			part = remArea/areaTile;
			
			cost = (whole + part)*cost2/100;
		}
		
		System.out.println(whole + " whole tiles, "+ part + " part tiles");
		System.out.println("$" + cost);
	}
}
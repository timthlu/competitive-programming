import java.util.Scanner;

public class TilingProblem {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the length of tile 1: ");
		int tile1 = scanner.nextInt();
		System.out.print("Enter the cost of a box of 100: ");
		int cost1 = scanner.nextInt();
		
		System.out.print("Enter the length of tile 2: ");
		int tile2 = scanner.nextInt();
		System.out.print("Enter the cost of a box of 100: ");
		int cost2 = scanner.nextInt();
		
		System.out.print("Enter the length of the room in inches: ");
		int roomLength = scanner.nextInt();
		System.out.print("Enter the width of the room in inches: ");
		int roomWidth = scanner.nextInt();
		
		double ratio1 = (cost1*1.0/100)/tile1;
		double ratio2 = (cost2*1.0/100)/tile2;
		double costPerTile1 = cost1*1.0/100;
		double costPerTile2 = cost2*1.0/100;
		
		int wholeTiles1 = (roomLength/tile1)*(roomWidth/tile1);
		int partTiles1 = 0;
		if (roomLength%tile1 != 0 && roomWidth%tile1 == 0) {
			partTiles1 = partTiles1 + roomWidth/tile1;
		} else if (roomLength%tile1 == 0 && roomWidth%tile1 != 0) {
			partTiles1 = partTiles1 + roomLength/tile1;
		} else if (roomLength%tile1 != 0 && roomWidth%tile1 != 0) {
			partTiles1 = roomLength/tile1 + roomWidth/tile1 + 1;
		}
		double finalCost1 = (wholeTiles1 + partTiles1)*costPerTile1;
		
		int wholeTiles2 = (roomLength/tile2)*(roomWidth/tile2);
		int partTiles2 = 0;
		if (roomLength%tile2 != 0 && roomWidth%tile2 == 0) {
			partTiles2 = partTiles2 + roomWidth/tile2;
		} else if (roomLength%tile2 == 0 && roomWidth%tile2 != 0) {
			partTiles2 = partTiles2 + roomLength/tile2;
		} else if (roomLength%tile2 != 0 && roomWidth%tile2 != 0) {
			partTiles2 = roomLength/tile2 + roomWidth/tile2 + 1;
		}
		double finalCost2 = (wholeTiles2 + partTiles2)*costPerTile2;
		
		if (finalCost1 < finalCost2) {
			System.out.println("The lower cost is using tile 1.");
			System.out.println(wholeTiles1 + " whole tiles and " + partTiles1 + " part tiles are necessary.");
			System.out.println("The cost is $" + finalCost1 + ".");
		} else {
			System.out.println("The lower cost is using tile 2.");
			System.out.println(wholeTiles2 + " whole tiles and " + partTiles2 + " part tiles are necessary.");
			System.out.println("The cost is $" + finalCost2 + ".");
		}
	}
}
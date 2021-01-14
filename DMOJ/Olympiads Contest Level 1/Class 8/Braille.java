import java.util.Scanner;
import java.util.ArrayList;

public class Braille {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> input = new ArrayList<String>();
		String line = scanner.nextLine();
		while (!line.isEmpty()) {
			//input then press enter again
			input.add(line);
			line = scanner.nextLine();
		}
		
		int i = 0;
		int j = 0;
		while (true) {
			String[][] array = new String[3][2];
			array[0][0] = input.get(i).substring(j, j+1);
			array[0][1] = input.get(i).substring(j+1, j+2);
			array[1][0] = input.get(i+1).substring(j, j+1);
			array[1][1] = input.get(i+1).substring(j+1, j+2);
			array[2][0] = input.get(i+2).substring(j, j+1);
			array[2][1] = input.get(i+2).substring(j+1, j+2);
			
			int num = 0;
			boolean w = false;
			boolean x = false;
			if (array[2][0].equals("x") && array[2][1].equals("o")) {
				num = num + 10;
			} else if (array[2][0].equals("x") && array[2][1].equals("x")) {
				num = num + 20;
			} else if (array[2][0].equals("o") && array[2][1].equals("x")) {
				w = true;
			}
			
			if (array[0][0].equals("x") && array[0][1].equals("o") && array[1][0].equals("o") && array[1][1].equals("o")) {
				num = num + 1;
			} else if (array[0][0].equals("x") && array[0][1].equals("o") && array[1][0].equals("x") && array[1][1].equals("o")) {
				num = num + 2;
			} else if (array[0][0].equals("x") && array[0][1].equals("x") && array[1][0].equals("o") && array[1][1].equals("o")) {
				num = num + 3;
			} else if (array[0][0].equals("x") && array[0][1].equals("x") && array[1][0].equals("o") && array[1][1].equals("x")) {
				num = num + 4;
			} else if (array[0][0].equals("x") && array[0][1].equals("o") && array[1][0].equals("o") && array[1][1].equals("x")) {
				num = num + 5;
			} else if (array[0][0].equals("x") && array[0][1].equals("x") && array[1][0].equals("x") && array[1][1].equals("o")) {
				num = num + 6;
			} else if (array[0][0].equals("x") && array[0][1].equals("x") && array[1][0].equals("x") && array[1][1].equals("x")) {
				num = num + 7;
			} else if (array[0][0].equals("x") && array[0][1].equals("o") && array[1][0].equals("x") && array[1][1].equals("x")) {
				num = num + 8;
			} else if (array[0][0].equals("o") && array[0][1].equals("x") && array[1][0].equals("x") && array[1][1].equals("o")) {
				num = num + 9;
			} else if (array[0][0].equals("o") && array[0][1].equals("x") && array[1][0].equals("x") && array[1][1].equals("x")) {
				num = num + 10;
			} else if (array[0][0].equals("x") && array[0][1].equals("x") && array[1][0].equals("o") && array[1][1].equals("o")) {
				x = true;
			}
				
			if (w) System.out.print("w");
			else if (x) System.out.print("x");
			else if (num == 1) System.out.print("a");
			else if (num == 2) System.out.print("b");
			else if (num == 3) System.out.print("c");
			else if (num == 4) System.out.print("d");
			else if (num == 5) System.out.print("e");
			else if (num == 6) System.out.print("f");
			else if (num == 7) System.out.print("g");
			else if (num == 8) System.out.print("h");
			else if (num == 9) System.out.print("i");
			else if (num == 10) System.out.print("j");
			else if (num == 11) System.out.print("k");
			else if (num == 12) System.out.print("l");
			else if (num == 13) System.out.print("m");
			else if (num == 14) System.out.print("n");
			else if (num == 15) System.out.print("o");
			else if (num == 16) System.out.print("p");
			else if (num == 17) System.out.print("q");
			else if (num == 18) System.out.print("r");
			else if (num == 19) System.out.print("s");
			else if (num == 20) System.out.print("t");
			else if (num == 21) System.out.print("u");
			else if (num == 22) System.out.print("v");
			else if (num == 24) System.out.print("y");
			else if (num == 25) System.out.print("z");
			else System.out.print(" ");
			
			j = j + 2;
			
			if (j == input.get(i).length()) {
				j = 0;
				i = i + 3;
				System.out.println();
				if (i == input.size()) {
					break;
				}
			}
		}
	}
}
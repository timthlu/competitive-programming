import java.util.Scanner;

public class MarsMission {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		//not inputed from file, inputed from keyboard
		String compressed = compress(input);
		System.out.println(compressed);
	}
	public static String compress(String str) {
		String output = "";
		String substring;
		if (str.charAt(0) == '0' && str.indexOf("1") != -1) {
			substring = str.substring(0, str.indexOf("1"));
			output = "0" + toBinary(substring.length()) + compress(str.substring(str.indexOf("1")));
		} else if (str.charAt(0) == '1' && str.indexOf("0") != -1) {
			substring = str.substring(0, str.indexOf("0"));
			output = "1" + toBinary(substring.length()) + compress(str.substring(str.indexOf("0")));
		} else {
			output = str.charAt(0) + toBinary(str.length());
		}
		return output;
	}
	public static String toBinary (int dec) {
		int exp = 0;
		
		while (Math.pow(2, exp) < dec) {
			exp++;
		}
		
		String bin = "";
		for (int i = exp; i >= 0; i--) {
			if (dec >= Math.pow(2, i)) {
				bin = bin + "1";
				dec = dec - (int) Math.pow(2, i);
			} else {
				bin = bin + "0";
			}
		}
		
		if (bin.charAt(0) == '0') return bin.substring(1);
		else return bin;
	}
}
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class ZigZag {
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		File file = new File("DATA41.txt");
		Scanner scannerf = null;
		try {
			scannerf = new Scanner(file);
		} catch (FileNotFoundException E) {}
		
		while (scannerf.hasNext()) {
			list.add(scannerf.nextInt());
		}
		scannerf.close();
		
		boolean isZigZag = true;
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				continue;
			} else if (i%2 == 1 && list.get(i) < list.get(i-1)) {
				isZigZag = false;
				break;
			} else if (i%2 == 0 && list.get(i) > list.get(i-1)) {
				isZigZag = false;
				break;
			}
		}
		
		if (isZigZag) {
			System.out.println("Is zig zag.");
		} else {
			System.out.println("Is not zig zag.");
		}
	}
}
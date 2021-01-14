import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Boxes {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int boxes = scanner.nextInt();
		Box[] box = new Box[boxes];
		
		for (int i = 0; i < boxes; i++) {
			box[i] = new Box(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
		}
		
		BoxComparator boxComp = new BoxComparator();
		Arrays.sort(box, boxComp);
		
		int cases = scanner.nextInt();
		
		for (int i = 0; i < cases; i++) {
			int l = scanner.nextInt();
			int w = scanner.nextInt();
			int h = scanner.nextInt();
			
			boolean found = false;
			for (int j = 0; j < boxes; j++) {
				if (l <= box[j].l && w <= box[j].w && h <= box[j].h) {
					found = true;
					System.out.println(box[j].volume);
					break;
				} else if (l <= box[j].l && w <= box[j].h && h <= box[j].w) {
					found = true;
					System.out.println(box[j].volume);
					break;
				} else if (l <= box[j].w && w <= box[j].l && h <= box[j].h) {
					found = true;
					System.out.println(box[j].volume);
					break;
				} else if (l <= box[j].w && w <= box[j].h && h <= box[j].l) {
					found = true;
					System.out.println(box[j].volume);
					break;
				} else if (l <= box[j].h && w <= box[j].l && h <= box[j].w) {
					found = true;
					System.out.println(box[j].volume);
					break;
				} else if (l <= box[j].h && w <= box[j].w && h <= box[j].l) {
					found = true;
					System.out.println(box[j].volume);
					break;
				}
			}
			
			if (!found) {
				System.out.println("Item does not fit.");
			}
		}
	}
}

class Box {
	int l, w, h;
	int volume;

	public Box(int l, int w, int h) {
		this.l = l;
		this.w = w;
		this.h = h;
		
		volume = l*w*h;
	}
}

class BoxComparator implements Comparator<Box> {
	public int compare(Box a, Box b) {
		if (a.volume > b.volume) {
			return 1;
		} else if (a.volume == b.volume) {
			return 0;
		}
		
		return -1;
	}
}
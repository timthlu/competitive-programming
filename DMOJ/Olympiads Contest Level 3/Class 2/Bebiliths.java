import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Arrays;

public class Bebiliths {
	static int convictSpeed;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		convictSpeed = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		Bebilith[] bebs = new Bebilith[num];
		
		for (int i = 0; i < num; i++) {
			String[] input = br.readLine().split(" ");
			bebs[i] = new Bebilith(i, Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]));
		}
		
		BebComparator bebComp = new BebComparator();
		Arrays.sort(bebs, bebComp);
		
		int cases = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < cases; i++) {
			System.out.println(bebs[num - Integer.parseInt(br.readLine())].order + 1);
		}
		
	}
}

class Bebilith {
	int order;
	int speed;
	int vDistance;
	int cSharpness;
	
	public Bebilith(int order, int speed, int vDistance, int cSharpness) {
		this.order = order;
		this.speed = speed;
		this.vDistance = vDistance;
		this.cSharpness = cSharpness;
	}
}

class BebComparator implements Comparator<Bebilith> {
	public int compare(Bebilith a, Bebilith b){
		if (a.speed == b.speed && a.speed >= Bebiliths.convictSpeed) {
			if (a.cSharpness > b.cSharpness) {
				return 1;
			} else if (a.cSharpness < b.cSharpness) {
				return -1;
			} else {
				return 0;
			}
		} else if (a.speed == b.speed) {
			if (a.vDistance > b.vDistance) {
				return 1;
			} else if (a.vDistance < b.vDistance) {
				return -1;
			} else {
				return 0;
			}
		} else {
			if (a.speed > b.speed) {
				return 1;
			} else if (a.speed < b.speed) {
				return -1;
			} else {
				return 0;
			}
		}
	}
}

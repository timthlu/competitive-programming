import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Homework {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int a = 0; a < 10; a++) {
			int n = Integer.parseInt(br.readLine());
			
			Comparator<Project> projectComparator = new Comparator<Project>() {
				public int compare(Project x, Project y) {
					if (x.weight > y.weight) return -1;
					else if (y.weight > x.weight) return 1;
					else {
						if (x.deadline < y.deadline) return -1;
						else return 1;
					}
				}
			};
			
			PriorityQueue<Project> pq = new PriorityQueue<>(projectComparator);
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				pq.add(new Project(Integer.parseInt(st.nextToken()), Double.parseDouble(st.nextToken())));
			}
			
			boolean[] daysTaken = new boolean[n+1];
			double ans = 0;
			while (!pq.isEmpty()) {
				Project p = pq.remove();
				for (int i = p.deadline; i >= 1; i--) {
					if (i <= n && !daysTaken[i]) {
						daysTaken[i] = true;
						ans += p.weight;
						break;
					}
				}
			}
			
			System.out.printf("%.4f", ans);
			System.out.println();
			
		}
	}
}
class Project {
	int deadline;
	double weight;
	
	Project (int d, double w) {
		deadline = d;
		weight = w;
	}
}
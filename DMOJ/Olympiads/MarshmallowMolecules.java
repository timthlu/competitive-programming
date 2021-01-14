import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

public class MarshmallowMolecules {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        TreeSet<Integer>[] adj = new TreeSet[n+1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new TreeSet<Integer>();
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            adj[a].add(b);
        }

        long count = 0;
        for (int i = 1; i <= n; i++) {
            if (!adj[i].isEmpty()) {
                count += adj[i].size();
                int first = adj[i].pollFirst();

                if (adj[i].size() > adj[first].size()) {
                    Iterator it = adj[first].iterator();
                    while (it.hasNext()) {
                        adj[i].add((int)it.next());
                    }

                    adj[first] = adj[i];
                } else {
                    Iterator it = adj[i].iterator();
                    while (it.hasNext()) {
                        adj[first].add((int)it.next());
                    }
                }
            }
        }

        System.out.println(count);
    }
}
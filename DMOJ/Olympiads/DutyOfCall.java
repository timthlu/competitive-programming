import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class DutyOfCall {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int friend = Integer.parseInt(input[1]);
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        boolean[] dead = new boolean[n+1];
        
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= n; i++) {
            input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]);

            for (int j = 0; j < m; j++) {
                adj[i].add(Integer.parseInt(input[j+1]));
                dead[Integer.parseInt(input[j+1])] = true;
            }
        }

        int[] team = new int[n+1];
        Queue<Integer> q = new LinkedList();
        q.add(friend);
        team[friend] = 1;
        while (!q.isEmpty()) {
            int cur = q.remove();
            int curTeam = team[cur];

            for (int i = 0; i < adj[cur].size(); i++) {
                int next = adj[cur].get(i);
                if (team[next] == 0) {
                    q.add(next);

                    if (curTeam == 1) {
                        team[next] = -1;
                    } else {
                        team[next] = 1;
                    }
                }
            }
        }

        int soupAlive = 0;
        int notSoupAlive = 0;

        for (int i = 1; i <= n; i++) {
            if (dead[i] == true) {
                if (team[i] == 1) {
                    soupAlive++;
                } else {
                    notSoupAlive++;
                }
            }
        }

        System.out.println(soupAlive + " " + notSoupAlive);
    }
}